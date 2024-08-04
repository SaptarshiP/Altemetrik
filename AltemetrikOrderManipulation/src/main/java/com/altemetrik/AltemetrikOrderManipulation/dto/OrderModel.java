package com.altemetrik.AltemetrikOrderManipulation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderModel {

	@JsonProperty("ORDER_ID")
	private String orderId;
	@JsonProperty("ORDER_NAME")
	private String orderName;
	@JsonProperty("ORDER_BRAND")
	private String orderBrand;
	
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId( String orderId ) {
		this.orderId = orderId;
	}
	
	public String getOrderName() {
		return this.orderName;
	}
	public void setOrderName( String orderName ) {
		this.orderName = orderName;
	}
	
	public String getOrderBrand() {
		return this.orderBrand;
	}
	
}
