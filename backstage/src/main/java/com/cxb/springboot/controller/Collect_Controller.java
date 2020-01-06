package com.cxb.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.springboot.pojo.Collect;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.service.Collect_Service;


@RestController
@RequestMapping("/collect")
public class Collect_Controller {
	//用户商品收藏功能，用户登录后，个人收藏的商品收藏图标为金色，为收藏的为白色
	
	@Autowired
	Collect_Service collect_Service;
	
	
	//根据页面滚动获取信息
	@RequestMapping(value="getinfoes")
	public Object getinfoes(Integer pagenum){
		Integer rowcount=20;
		return collect_Service.pageCommodityInformation(rowcount, pagenum);
	}
	
	/**
	 * 根据用户id，放入用户收藏夹中
	 * @param collect
	 * @param session
	 * @return	封装有收藏商品信息的对象
	 */
	@RequestMapping("favorites")
	public Object favorites(Collect collect,HttpSession session){
		User user=(User) session.getAttribute("user");
		collect.setUserid(user.getUserid());
		collect_Service.collection(collect);
		return true;
	}
	
	
	/**
	 * 根据用户id获取收藏夹信息
	 * @param session
	 * @return	封装有 编号、图片、单价等信息的列表
	 */
	@RequestMapping("favoriteinformations")
	public Object favoriteInformations(HttpSession session){
		User user=(User) session.getAttribute("user");
		return collect_Service.getProductDisplay(user);
	}
	
	/**
	 * 根据商品的id来删除收藏夹商品，以及信息
	 * @param clid
	 * @return	删除封装有 编号、图片、单价等信息的列表
	 */
	@RequestMapping("deletemerchandise")
	public Object deleteMerchandise(Integer clid){
		collect_Service.deleteId(clid);
		return true;
	}
	
	
	
	
	
	
	

}
