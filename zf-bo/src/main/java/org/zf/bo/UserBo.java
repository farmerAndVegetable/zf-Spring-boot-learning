package org.zf.bo;
/**
 * 用户接口
 * @author Administrator
 *
 */
public interface UserBo{
	/**
	 * 用户登录接口
	 * @param userName
	 * @param password
	 */
	void login(String userName,String password);
	/**
	 * 用户退出登录
	 * @param userId
	 */
	void outLogin(String userId);
}
