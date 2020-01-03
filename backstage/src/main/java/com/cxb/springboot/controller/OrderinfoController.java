package com.cxb.springboot.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cxb.springboot.pojo.Orderinfo;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.service.GoodsinfoService;

@RestController
public class OrderinfoController {
	@Autowired
	GoodsinfoService goodsinfoService;
	
	@RequestMapping(value="/getorderinfobyuserid")
	public Object getOrderinfoByUserid(HttpSession session){
		User user = (User) session.getAttribute("user");
		return goodsinfoService.getOrderinfoByUserid(user.getUserid());
	}
	
	@RequestMapping(value="/getorderinfo")
	public Object getOrderinfo(Orderinfo orderinfo,Integer[] orderlist,HttpSession session){
		User user = (User) session.getAttribute("user");
		orderinfo.setUserid(user.getUserid());
		return goodsinfoService.getOrderinfos(orderinfo, orderlist);
	}
	
	
	
}
