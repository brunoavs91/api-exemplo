package com.drogatel.api.exception;

public class BusinessException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public BusinessException(String msg) {
		super(msg);
	}
	public BusinessException(String msg , Throwable cause) {
		super(msg,cause);
	}
}
