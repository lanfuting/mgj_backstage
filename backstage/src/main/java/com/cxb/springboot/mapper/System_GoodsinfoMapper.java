package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;


public interface System_GoodsinfoMapper {
	
	
	public List<Map> selectGoodsinfoByPage(RowBounds bounds);
	
	public List<Map> selectByKeyword(String keyword);
	
	public Map selectOnlyGoodsinfo(Integer gdid);

	
    
}