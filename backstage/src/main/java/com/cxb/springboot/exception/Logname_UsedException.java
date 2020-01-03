package com.cxb.springboot.exception;

public class Logname_UsedException extends Exception {
	private static final long serialVersionUID = 1L;
//	用户名已被占用抛出异常
	@Override
	public void printStackTrace() {
		System.out.println("logname be used!");
	}
	

}
