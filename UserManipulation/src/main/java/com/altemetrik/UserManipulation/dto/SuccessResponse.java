package com.altemetrik.UserManipulation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResponse {

	@JsonProperty("SUCCESS_CODE")
	private String successCode;
	@JsonProperty("SUCCESS_MESSAGE")
	private String successMessage;
	
	public SuccessResponse( String successCode, String successMessage ) {
		this.successCode = successCode;
		this.successMessage = successMessage;
	}
	
	public String getSuccessCode() {
		return this.successCode;
	}
	public void setSuccessCode( String successCode ) {
		this.successCode = successCode;
	}
	
	public String getSuccessMessage() {
		return this.successMessage;
	}
	public void setSuccessMessage( String successMessage ) {
		this.successMessage = successMessage;
	}
	
}
