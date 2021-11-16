package com.br.fiap.exception;

public class DBException extends Exception {

	public DBException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DBException(String message) {
		super(message);
	}
	
	public DBException(Throwable cause) {
		super(cause);
	}

}
