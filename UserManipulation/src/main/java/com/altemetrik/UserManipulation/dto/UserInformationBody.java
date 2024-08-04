package com.altemetrik.UserManipulation.dto;

public class UserInformationBody {

	private String userName;
	private String userId;
	private String userPassword;
	
	public String getUserName() {
		return this.userName;
	}
	public void setUserName( String userName ) {
		this.userName = userName;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId( String userId ) {
		this.userId = userId;
	}
	
	public String getUserPassword() {
		return this.userPassword;
	}
	public void setUserPassword( String userPassword ) {
		this.userPassword = userPassword;
	}
}
