package com.cxb.springboot.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.cxb.springboot.pojo.Cart;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.service.AliService;
import com.cxb.springboot.service.GoodsinfoService;

@RestController
public class AliController {
	@Autowired
	AliService aliService;
	@Autowired
	GoodsinfoService goodsinfoService;
	
	@RequestMapping("/alitest") 
	public void ali(String ofid,String money, HttpServletResponse response, HttpServletRequest request) throws IOException, AlipayApiException {
		aliService.ali(ofid,money,response,request);  
	} 
	
	@RequestMapping("/ali_finish")
	public String finish(String out_trade_no){		
		String ofid=out_trade_no;
		goodsinfoService.changeOrderinfo(out_trade_no);	
		return "http://127.0.0.1:8082/backstage/hello.html";
	}
	
	
	
}
