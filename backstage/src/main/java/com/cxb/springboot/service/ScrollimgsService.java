package com.cxb.springboot.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.springboot.mapper.ScrollimgsMapper;
import com.cxb.springboot.mapper.System_ScrollimgsMapper;

@Service
public class ScrollimgsService {

	@Autowired
	ScrollimgsMapper ScrollimgsMapper;
	@Autowired
	System_ScrollimgsMapper system_ScrollimgsMapper;
	
	public int getScrollimgsPage(Integer rows){
		Integer count = system_ScrollimgsMapper.getPageScrollimgs();
		return (count%rows==0)?(count/rows):(count/rows)+1;
	}
	
	public List<Map> getScrollimgsByPage(Integer rows,Integer page){
		RowBounds bounds = new RowBounds((page-1)*rows, rows);
		return system_ScrollimgsMapper.getScrollimgs(bounds );
	}
	
}
