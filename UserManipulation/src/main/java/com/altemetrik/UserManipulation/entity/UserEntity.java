package com.altemetrik.UserManipulation.entity;

import java.io.Serializable;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.NamedQuery;

/*
 * This class is the representation of persistence storage in the database
 * */
@Table(name = "USER_DATA")
@Entity
public class UserEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	public String getId() {
		return this.id;
	}
	public void setId( String uid ) {
		this.id = uid;
	}
	
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
