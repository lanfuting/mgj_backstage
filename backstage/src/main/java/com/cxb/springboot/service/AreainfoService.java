package com.cxb.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.springboot.mapper.AreainfoMapper;
import com.cxb.springboot.pojo.Areainfo;
import com.cxb.springboot.pojo.AreainfoExample;

@Service
public class AreainfoService {

	@Autowired
	AreainfoMapper areainfoMapper;
	
	public List<Areainfo> selectAreainfo(){
		AreainfoExample example = new AreainfoExample();
		return areainfoMapper.selectByExample(example );
	}
}
