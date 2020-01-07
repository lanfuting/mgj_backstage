package com.cxb.springboot.test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxb.springboot.exception.Logname_UsedException;
import com.cxb.springboot.exception.Password_ErroerException;
import com.cxb.springboot.exception.User_StatusBanException;
import com.cxb.springboot.exception.Username_isNullException;
import com.cxb.springboot.mapper.System_GoodsinfoMapper;
import com.cxb.springboot.pojo.Goodsinfo;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.service.AreainfoService;
import com.cxb.springboot.service.GoodsinfoService;
import com.cxb.springboot.service.SupplierService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAreainfo {
	@Autowired
	AreainfoService areainfoService;
	@Autowired
	GoodsinfoService goodsinfoService;
	@Autowired
	SupplierService supplierService;
	
	
	@Test
	public void test1(){
		
		 
		
		
	}

}
