package com.altemetrik.UserManipulation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

	@JsonProperty("ERR_CODE")
	private String errCode;
	@JsonProperty("ERR_MESSAGE")
	private String errMessage;
	
	public ErrorResponse( String errCode, String errMessage ) {
		this.errCode = errCode;
		this.errMessage = errMessage;
	}
	
	public String getErrorCode() {
		return this.errCode;
	}
	public void setErrCode( String errCode ) {
		this.errCode = errCode;
	}
	
	public String getErrMessage() {
		return this.errMessage;
	}
	public void setErrMessage( String errMessage ) {
		this.errMessage = errMessage;
	}
}
