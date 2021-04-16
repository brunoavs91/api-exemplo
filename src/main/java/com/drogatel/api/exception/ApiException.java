package com.drogatel.api.exception;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiException(String msg) {
		super(msg);
	}

	public ApiException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
