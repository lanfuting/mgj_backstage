package com.cxb.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.springboot.pojo.Areainfo;
import com.cxb.springboot.service.AreainfoService;

@RestController
@RequestMapping(value="/areainfocontroller")
public class AreainfoController {
	@Autowired
	AreainfoService areainfoService;
	
	@RequestMapping(value="selectall")
	public Object selectAll(){
		List<Areainfo> list = areainfoService.selectAreainfo();
		return list;
	}
	
	

}
