package com.altemetrik.AltemetrikOrderManipulation.exception;

public class OrderManipulationCustomException extends RuntimeException{

	private String errCode;
	private String errMessage;
	
	public OrderManipulationCustomException( Exception exp, String errCode,
												String errMessage) {
		super(exp);
		this.errCode = errCode;
		this.errMessage = errMessage;
	}
	
	public String getErrorCode() {
		return this.errCode;
	}
	public String getErrMessage() {
		return this.errMessage;
	}
	
}
