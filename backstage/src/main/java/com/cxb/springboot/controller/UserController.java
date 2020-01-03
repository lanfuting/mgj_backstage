package com.cxb.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.cxb.springboot.exception.Logname_UsedException;
import com.cxb.springboot.exception.Password_ErroerException;
import com.cxb.springboot.exception.User_StatusBanException;
import com.cxb.springboot.exception.Username_isNullException;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.service.GoodsinfoService;

@RestController
public class UserController {
	@Autowired
	GoodsinfoService goodsinfoService;

	//退出登录注销当前的session
	@RequestMapping(value = "/outlogin")
	public Boolean outLogin(HttpSession session, SessionStatus sessionStatus){
		session.removeAttribute("user");// 取出httpsession中的user属性
		session.invalidate(); // 然后是让httpsession失效
		sessionStatus.setComplete();// 最后是调用sessionStatus方法
		return true;
	}

	@RequestMapping(value = "/useronline")
	public Object userOnLine(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return user;
	}

	@RequestMapping(value = "/getcurrentusertotable")
	public Object getCurrentUserToTable(String logname, String password, String keycode, HttpSession session) {
		Map map = new HashMap();
		String code = (String) session.getAttribute("rightCode");
		if (!code.equalsIgnoreCase(keycode)) {
			map.put("mge", 0);
			return map;
		}
		try {
			User user = goodsinfoService.selectCurrentUser(logname, password);
			session.setAttribute("user", user);
			map.put("mge", 1);
		} catch (Password_ErroerException e) {
			map.put("mge", 2);
		} catch (Username_isNullException e) {
			map.put("mge", 3);
		} catch (User_StatusBanException e) {
			map.put("mge", 4);
		}

		return map;
	}

	@RequestMapping(value = "/gettoinfregisterouser")
	public Object gettoRegisterUser(String logname, String password, String keycode, HttpSession session) {
		Map map = new HashMap();
		String code = (String) session.getAttribute("rightCode");
		if (!code.equalsIgnoreCase(keycode)) {
			map.put("mge", "0");
			return map;
		}
		try {
			goodsinfoService.getinfoInsertUser(logname, password);
			map.put("mge", "1");
		} catch (Logname_UsedException e) {
			map.put("mge", "2");
		}
		return map;
	}
}
