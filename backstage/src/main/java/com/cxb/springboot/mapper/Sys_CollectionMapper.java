package com.cxb.springboot.mapper;

import java.util.List;
import java.util.Map;

public interface Sys_CollectionMapper {
	public List<Map> getCollectionByUserID(Integer userid);

}
