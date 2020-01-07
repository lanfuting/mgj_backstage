package com.cxb.springboot.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxb.springboot.pojo.Collect;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.service.Collect_Service;

@SpringBootApplication(scanBasePackages="com.cxb.springboot")
@MapperScan(basePackages="com.cxb.springboot.mapper")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCollect {
	@Autowired
	Collect_Service collect_Service;
	
	@Autowired
	Collect collect;
	
	@Test
	public void te1(){
		Collect co=new Collect();
		co.setGdid(2);
		co.setUserid(1);
		collect_Service.collection(co);
	}
	
	
	@Test
	public void te2(){
		User user = new User();
		user.setUserid(1);
		List<Map> list = collect_Service.getProductDisplay(user);
		for (Map map : list) {
			System.out.println(map);
		}		
	}
	
	@Test
	public void te3(){
		Collect co = new Collect();
		collect_Service.deleteId(7);
	}
	

}
