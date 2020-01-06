package com.cxb.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.springboot.exception.Logname_UsedException;
import com.cxb.springboot.service.Supplier_Service;

@RestController
public class SupplierRegistration {	
	@Autowired
	Supplier_Service supplier_Service;
	
	/**
	 * 供应商注册
	 * @param logname
	 * @param password
	 * @param keycode
	 * @param session
	 * @return  map {msg : value} value= 0 验证码错误， 1 注册成功，  2 用户已存在，
	 */
	@RequestMapping(value="/registration")
	public Object Registration(String slogname,String spassword,String keycode,HttpSession session){
		Map message=new HashMap();
		String code=(String) session.getAttribute("rightCode");
		if(! keycode.equalsIgnoreCase(code)){
			message.put("msg", 0);
			return message;
		}
		try {
			supplier_Service.SupplierRegistrationMethod(slogname, spassword);
			message.put("msg", 1);
		} catch (Logname_UsedException e) {
			message.put("msg", 2);
		}
		return message;
	}
	

}
