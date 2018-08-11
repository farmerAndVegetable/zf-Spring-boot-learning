package org.zf.web.rpc;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zf.bo.UserBo;
import org.zf.web.bean.XMLSimple;
import org.zf.web.bean.XmlSonClass;

@RestController
@RequestMapping(value="/userManager")
public class UserController {
	@Autowired
	private UserBo userbo;
	public void init(){
		System.out.println("controller=================================");
	}
	@RequestMapping(value="/login.do")
	public void login(@Param(value = "userName") String userName,@Param(value = "password") String password){
		System.out.println("login==============================login");
		userbo.login(userName, password);
	}
	
	@RequestMapping(value="/xmldata",produces={"application/xml;charset=UTF-8"})
	public XMLSimple returnXmlData(){
		System.out.println("xmldata==============================xmldata");
		XmlSonClass xmlSonClass=new XmlSonClass();
		xmlSonClass.setAge_son(12);
		xmlSonClass.setId_son("232423232");
		xmlSonClass.setName_son("张三");
		XMLSimple xMLSimple=new XMLSimple();
		xMLSimple.setAge(24);
		xMLSimple.setId("12sfdsrf");
		xMLSimple.setName("l;koj");
		xMLSimple.setXmlSonClass(xmlSonClass);
		
		return xMLSimple;
		
	}

}
