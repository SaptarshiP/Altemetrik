package com.altemetrik.UserManipulation.exception;

/*
 * This is the custom exception used over all in user manipulation
 * */
public class UserManipulationCustomException extends RuntimeException{

	private String errorCode;
	private String errorMessage;
	
	public UserManipulationCustomException( Exception exp, String errorCode, String errorMessage ) {
		super(exp);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	public String getErrorCode() {
		return this.errorCode;
	}
	public String getErrorMessage() {
		return this.errorMessage;
	}
}
