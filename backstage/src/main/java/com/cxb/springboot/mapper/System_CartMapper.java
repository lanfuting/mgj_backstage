package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;


public interface System_CartMapper {
	
	public List<Map> getUserCart(Integer userid,RowBounds bounds);
	
	public Integer getPageCart(Integer userid);
	
    
}