package com.cxb.springboot.service;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.springboot.exception.Logname_UsedException;
import com.cxb.springboot.exception.Password_ErroerException;
import com.cxb.springboot.exception.Username_isNullException;
import com.cxb.springboot.mapper.SupplierMapper;
import com.cxb.springboot.pojo.Supplier;
import com.cxb.springboot.pojo.SupplierExample;


@Service
public class Supplier_Service {
	
	@Autowired
	SupplierMapper supplierMapper;
	
	/**
	 * 供应商登录的方法
	 * @param logname 用户名
	 * @param password 密码
	 * @return 完整的用户信息对象
	 * @throws Username_isNullException 表示用户不存在
	 * @throws Password_ErroerException  密码错误
	 */
	public Supplier supplierLoginMethod(String slogname,String spassword) throws Username_isNullException,Password_ErroerException{
		SupplierExample  example= new SupplierExample();
		example.createCriteria().andSlognameEqualTo(slogname);
		List<Supplier> suppliers = supplierMapper.selectByExample(example);
		if(suppliers==null || suppliers.size()==0){
			throw new Username_isNullException();
		}
		Supplier supplier = suppliers.get(0);
		Md5Hash md5=new Md5Hash(spassword, supplier.getSsalt());
		if(!supplier.getSpassword().equals(md5.toString())){
			throw new Password_ErroerException();
		}
		return supplier;	
	}
	
	/**
	 * 供应商注册方法
	 * @param logname
	 * @param password
	 * @throws Logname_UsedException 用户名已经被使用
	 */
	@Transactional
	public void SupplierRegistrationMethod(String slogname,String spassword) throws Logname_UsedException{
		SupplierExample example= new SupplierExample();
		//判断用户名是否以及被使用
		example.createCriteria().andSlognameEqualTo(slogname);
		Long count =(long) supplierMapper.countByExample(example);
		if(count == 1){
			//用户名已经被使用，抛出异常
			throw new Logname_UsedException();
		}
		//封装supplier信息以及salt、密码加密等操作
		Supplier supplier = new Supplier();
		String ssalt = UUID.randomUUID().toString();
		Md5Hash md5 = new Md5Hash(spassword, ssalt);
		supplier.setSlogname(slogname);
		supplier.setSpassword(md5.toString());
		supplier.setSsalt(ssalt);
		supplierMapper.insert(supplier);
	}

}
