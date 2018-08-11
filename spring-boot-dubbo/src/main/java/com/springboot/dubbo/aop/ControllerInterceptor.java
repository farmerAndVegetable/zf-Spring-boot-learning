package com.springboot.dubbo.aop;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect  
@Component 
public class ControllerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);  
      
    /** 
     * 定义拦截规则：拦截com.xjj.web.controller包下面的所有类中，有@RequestMapping注解的方法。 
     */  
    @Pointcut("execution(* com.xjj.web.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")  
    public void controllerMethodPointcut(){}  
      
    /** 
     * 拦截器具体实现 
     * @param pjp 
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。） 
     */  
    @Around("controllerMethodPointcut()") //指定拦截器规则；也可以直接把“execution(* com.xjj.........)”写进这里  
    public Object Interceptor(ProceedingJoinPoint pjp){  
        long beginTime = System.currentTimeMillis();  
        MethodSignature signature = (MethodSignature) pjp.getSignature();  
        Method method = signature.getMethod(); //获取被拦截的方法  
        String methodName = method.getName(); //获取被拦截的方法名  
          
        Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中  
          
        logger.info("请求开始，方法：{}", methodName);  
          
        Object result = null;  
  
        Object[] args = pjp.getArgs();  
        for(Object arg : args){  
            if (arg instanceof Map<?, ?>) {  
                //提取方法中的MAP参数，用于记录进日志中  
                Map<String, Object> map = (Map<String, Object>) arg;  
                allParams.add(map);  
            }else if(arg instanceof HttpServletRequest){  
                HttpServletRequest request = (HttpServletRequest) arg;  
                  
                //获取query string 或 posted form data参数  
                Map<String, String[]> paramMap = request.getParameterMap();  
                if(paramMap!=null && paramMap.size()>0){  
                    allParams.add(paramMap);  
                } 
            }
        }  
          
        try {  
            if(result == null){  
                // 一切正常的情况下，继续执行被拦截的方法  
                result = pjp.proceed();  
            }  
        } catch (Throwable e) {  
            logger.info("exception: ", e);  
        }  
          
     
        return result;  
    }  
      
}
