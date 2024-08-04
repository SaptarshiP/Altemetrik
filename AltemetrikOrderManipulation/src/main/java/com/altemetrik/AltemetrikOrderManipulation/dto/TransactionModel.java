package com.altemetrik.AltemetrikOrderManipulation.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionModel {

	@JsonProperty("TRANSACTION_ID")
	private String transactionId;
	@JsonProperty("USER_ID")
	private String userId;
	@JsonProperty("TRANSACTION_NAME")
	private String transactionName;
	@JsonProperty("ORDER")
	private List<OrderModel> orderList;
	
	
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
	
	public String getTransactionName() {
		return this.transactionName;
	}
	public void setTransactionName( String transactionName ) {
		this.transactionName = transactionName;
	}
		
	public List<OrderModel> getOrderList(){
		return this.orderList;
	}
	public void setOrderList(List<OrderModel> orderList) {
		this.orderList = orderList;
	}
}
