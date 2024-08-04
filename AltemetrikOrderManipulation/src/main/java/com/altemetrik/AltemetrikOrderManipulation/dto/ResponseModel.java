package com.altemetrik.AltemetrikOrderManipulation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel {

	@JsonProperty("data")
	public String code;
	@JsonProperty("message")
	public String message;
	
	public ResponseModel( String code, String message ) {
		this.code = code;
		this.message = message;
	}
	
	public Object getCode() {
		return this.code;
	}
	public String getMessage() {
		return this.message;
	}
	
}
