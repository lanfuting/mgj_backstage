package com.cxb.springboot.exception;

public class Username_isNullException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void printStackTrace() {
		System.out.println("the username is null");
	}

}
