package com.cxb.springboot.exception;

public class Password_ErroerException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void printStackTrace() {
		System.out.println("user input the password is error");
	}

}
