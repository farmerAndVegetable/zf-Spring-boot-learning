package org.zf.bo.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zf.common.unit.Preconditions;

import redis.clients.jedis.Jedis;

public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    //显然jedis还需要自己配置来初始化
    private Jedis jedis = new Jedis();

    //默认锁住15秒，尽力规避锁时间太短导致的错误释放
    private static final long DEFAULT_LOCK_TIME = 15 * 1000;

    //尝试锁住一个lock，设置尝试锁住的次数和超时时间（毫秒）,默认最短15秒
    //成功时返回这把锁的key，解锁时需要凭借锁的lock和key
    //失败时返回空字符串
    public String lock(String lock, int retryCount, long timeout) {
    	
        Preconditions.checkArgument(retryCount > 0 && timeout > 0, "retry count <= 0 or timeout <= 0 !");
        Preconditions.checkArgument(retryCount < Integer.MAX_VALUE && timeout < Long.MAX_VALUE - DEFAULT_LOCK_TIME,
                "retry count is too big or timeout is too big!");
        String $lock = Preconditions.checkNotNull(lock) + "_redis_lock";
        long $timeout = timeout + DEFAULT_LOCK_TIME;
        String ret = null;
        //重试一定次数，还是拿不到，就放弃
        try {
            long i, status;
            for (i = 0, status = 0; status == 0 && i < retryCount; ++i) {
                //尝试加锁，并设置超时时间为当前机器时间+超时时间
                if ((status = jedis.setnx($lock, ret = Long.toString(System.currentTimeMillis() + $timeout))) == 0) {
                    //获取锁失败，查看锁是否超时
                    String time = jedis.get($lock);
                    //在加锁和检查之间，锁被删除了，尝试重新加锁
                    if (time == null) {
                        continue;
                    }
                    //锁的超时时间戳小于当前时间，证明锁已经超时
                    if (Long.parseLong(time) < System.currentTimeMillis()) {
                        String oldTime = jedis.getSet($lock, Long.toString(System.currentTimeMillis() + $timeout));
                        if (oldTime == null || oldTime.equals(time)) {
                            //拿到锁了，跳出循环
                            break;
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        logger.error("lock key:{} sleep failed!", lock);
                    }
                }
            }
            if (i == retryCount && status == 0) {
                logger.info("lock key:{} failed!", lock);
                return "";
            }
            //给锁加上过期时间
            jedis.pexpire($lock, $timeout);
            logger.info("lock key:{} succsee!", lock);
            return ret;
        } catch (Exception e) {
            logger.error("redis lock key:{} failed! cached exception: ", lock, e);
            return "";
        }
    }

    //释放lock的锁，需要传入lock和key
    //尽力确保删除属于自己的锁，但是不保证做得到
    public void releaseLock(String lock, String key) {
        String $lock = Preconditions.checkNotNull(lock) + "_redis_lock";
        Preconditions.checkNotNull(key);
        try {
            long timeout = Long.parseLong(key);
            //锁还没有超时，锁还属于自己可以直接删除
            //但由于线程运行的不确定性，其实不能完全保证删除时锁还属于自己
            //真正执行删除操作时，距离上语句判断可能过了很久
            if (timeout <= System.currentTimeMillis()) {
                jedis.del($lock);
                logger.info("release lock:{} with key:{} success!", lock, key);
            } else {
                logger.info("lock:{} with key:{} timeout! wait to expire", lock, key);
            }
        } catch (Exception e) {
            logger.error("redis release {}  with key:{} failed! cached exception: "+lock+key, e);
        }
    }
}
