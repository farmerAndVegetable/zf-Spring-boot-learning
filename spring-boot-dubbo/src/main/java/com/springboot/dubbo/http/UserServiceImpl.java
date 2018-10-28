package com.springboot.dubbo.http;

import org.springframework.stereotype.Component;
import org.zf.dubbo.commonservice.UserService;


@Component
public class UserServiceImpl implements UserService{

	@Override
	public String getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dubboInterfaceTest() {
		// TODO Auto-generated method stub
		return "hello word dubbo service!";
	}

}
