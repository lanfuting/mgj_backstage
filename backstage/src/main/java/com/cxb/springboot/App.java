package com.cxb.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.cxb.springboot")
@MapperScan(basePackages="com.cxb.springboot.mapper")
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}


}
