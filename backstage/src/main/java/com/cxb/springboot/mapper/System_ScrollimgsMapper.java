package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;


public interface System_ScrollimgsMapper {
	
	public List<Map> getScrollimgs(RowBounds bounds);
	
	public Integer getPageScrollimgs();
	
	
    
}