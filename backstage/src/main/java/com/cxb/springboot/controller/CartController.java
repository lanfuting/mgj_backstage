package com.cxb.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.springboot.pojo.Cart;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.service.GoodsinfoService;

@RestController
public class CartController {
	@Autowired
	GoodsinfoService goodsinfoService;
	
	
	@RequestMapping(value="/updatecart")
	public Object updateCart(Integer ctid,Integer count){
		goodsinfoService.updateCartCount(ctid, count);
		return true;
	}
	
	@RequestMapping(value="/deletecartbyctid")
	public Object deleteCartByCtid(Integer ctid){
		goodsinfoService.deleteCartById(ctid);
		return true;
	}
	
	@RequestMapping(value="/selectcurrentusercart")
	public Object selectCurrentUserCart(HttpSession session,Integer page){
		Map mp = new HashMap();
		Integer rows=5;
		User user = (User) session.getAttribute("user");
		Integer pagecount = goodsinfoService.getPage(rows,user);
		List<Map> cartlist = goodsinfoService.selectUserCart(user,rows,page);
		mp.put("pagecount", pagecount);
		mp.put("cartlist", cartlist);
		return mp;
	}
	
	@RequestMapping(value="/getshopputusercart")
	public Object getShopPutUserCart(Cart cart,HttpSession session){
		User user = (User) session.getAttribute("user");
		cart.setUserid(user.getUserid());
		goodsinfoService.putUserCart(cart);
		return true;
	}
	
	
}
