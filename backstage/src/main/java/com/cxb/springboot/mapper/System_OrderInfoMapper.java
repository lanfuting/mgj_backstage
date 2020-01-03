package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;


public interface System_OrderInfoMapper {
	
	public List<Map> getOrderinfoByUserid(Integer userid);
	
	public Map getOrderinfoByOfid(String ofid);
	
    
}