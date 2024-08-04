package com.altemetrik.AltemetrikOrderManipulation.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class TransactionId implements Serializable{

	private String transactionId;
	private String userId;
	
	public TransactionId( String transactionId, String userId ) {
		this.transactionId = transactionId;
		this.userId = userId;
	}
	
	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId( String transactionId ) {
		this.transactionId = transactionId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId( String userId ) {
		this.userId = userId;
	}
}
