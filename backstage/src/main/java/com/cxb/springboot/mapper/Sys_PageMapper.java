package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

public interface Sys_PageMapper {
	
	public List<Map> getPage(RowBounds bounds);


}
