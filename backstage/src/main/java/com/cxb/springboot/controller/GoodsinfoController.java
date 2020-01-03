package com.cxb.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.springboot.pojo.Goodssize;
import com.cxb.springboot.service.GoodsinfoService;

@RestController
@RequestMapping(value="/goodsinfocontroller")
public class GoodsinfoController {
	@Autowired
	GoodsinfoService goodsinfoService;
	
	@RequestMapping(value="selectonlygoodsinfo")
	public Object selectOnlyGoodsinfo(Integer gdid){
		Map onlyGoodsinfo = goodsinfoService.selectOnlyGoodsinfo(gdid);
		List<Goodssize> goodssize = goodsinfoService.getGoodssize();
		Map map = new HashMap();
		map.put("onlyGoodsinfo", onlyGoodsinfo);
		map.put("goodssize", goodssize);
		return map;
	}
	
	@RequestMapping(value="selectbykeyword")
	public Object selectByKeyword(String keyword){
		StringBuffer buffer = new StringBuffer("%");
		buffer.append(keyword).append("%");
		return goodsinfoService.selectByKeyword(buffer.toString());
	}
	
	@RequestMapping(value="selectbypage")
	public Object selectByPage(Integer page){
		Integer rows = 20;
		List<Map> list = goodsinfoService.selectGoodsinfo(rows, page);
		return list;
	}
	
	

}
