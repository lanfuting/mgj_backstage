package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;


public interface System_SupplierMapper {
	
	public List<Map> getUserOrderTosupp(Integer gtid);
	
	public List<Map> getSuppGoods(Integer gtid);
		
    
}