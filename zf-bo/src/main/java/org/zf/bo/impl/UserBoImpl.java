package org.zf.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zf.bo.UserBo;
import org.zf.dal.mapper.UserExtMapper;
import org.zf.dal.mapper.UserMapper;
import org.zf.dal.model.User;

@Service("userBo")
public class UserBoImpl implements UserBo {
	@Autowired 
	private UserMapper userMapper;
	@Autowired 
	private UserExtMapper userExtMapper;
	
	public void init(){
		System.out.println("controller=================================");
	}
	
	/*@Transactional*/
	@Override
	public void login(String userName, String password) {
		User user=new User();
		user.setUserName(userName);
		user.setAge(20);
		user.setPassword(password);
		user.setGender("男");
		user.setIsDeleted("n");;
		userMapper.insert(user);
		
		System.out.println("当前登录用户是:"+userName);
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
