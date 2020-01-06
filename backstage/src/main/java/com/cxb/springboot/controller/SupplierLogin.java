package com.cxb.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.springboot.exception.Password_ErroerException;
import com.cxb.springboot.exception.Username_isNullException;
import com.cxb.springboot.pojo.Supplier;
import com.cxb.springboot.service.Supplier_Service;


@RestController
public class SupplierLogin {
	
	@Autowired
	Supplier_Service supplier_Service;
	
	@RequestMapping(value="/userisonline")
	public Object userisonline(HttpSession session){
		Supplier  supplier= (Supplier) session.getAttribute("supplier");
		
		return supplier;	
	}
	
	/**
	 * 供应商登录
	 * @param logname
	 * @param password
	 * @param keycode
	 * @param session
	 * @return	msg: 1 正常，  0  用户不存在  ，2  密码错误
	 */
	@RequestMapping(value="/login")
	public Object Login(String slogname,String spassword,String keycode,HttpSession session){
		Map msg=new HashMap();
		String code=(String) session.getAttribute("rightCode");
		if(!code.equalsIgnoreCase(keycode)){
			msg.put("msg", 3);
			return msg;
		}
		try {
			//登录成功后 将 获取的对象supplier 放入 session 属性中 备用
			Supplier supplier=supplier_Service.supplierLoginMethod(slogname, spassword);
			session.setAttribute("supplier", supplier);
			msg.put("msg", 1);
		} catch (Username_isNullException e) {
			msg.put("msg", 0);
		} catch (Password_ErroerException e) {
			msg.put("msg", 2);
		}return msg;
		
		
		
	}
	
	
	
	
	

}
