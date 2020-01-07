package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.cxb.springboot.pojo.Goodsinfo;


public interface System_GoodsinfoMapper {
	
	
	public List<Map> selectGoodsinfoByPage(RowBounds bounds);
	
	public List<Map> selectByKeyword(String keyword);
	
	public Map selectOnlyGoodsinfo(Integer gdid);
	
	
    
}