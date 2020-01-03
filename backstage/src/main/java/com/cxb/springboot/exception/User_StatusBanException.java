package com.cxb.springboot.exception;

public class User_StatusBanException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void printStackTrace() {
		System.out.println("the user status is ban");
	}

}
