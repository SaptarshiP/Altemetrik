package com.altemetrik.UserManipulation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBody {

	@JsonProperty("DATA")
	private Object data;
	
	public ResponseBody( Object data ) {
		this.data = data;
	}
		
	public Object getData() {
		return this.data;
	}
	public void setData( Object data ) {
		this.data = data;
	}
}
