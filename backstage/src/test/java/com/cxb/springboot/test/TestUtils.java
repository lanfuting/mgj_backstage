package com.cxb.springboot.test;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class TestUtils {
	
	@Test
	public void test1(){
		String key = "666666";
		String salt = "tom1";
		System.out.println(key);
		Md5Hash md_1 = new Md5Hash(key);
		Md5Hash md_2 = new Md5Hash(key, salt);
		Md5Hash md_3 = new Md5Hash(key, salt,2);
		System.out.println(md_1);
		System.out.println(md_2);
		System.out.println(md_3);
		
	}

}
