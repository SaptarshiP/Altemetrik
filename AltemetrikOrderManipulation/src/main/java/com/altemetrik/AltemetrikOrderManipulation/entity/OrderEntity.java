package com.altemetrik.AltemetrikOrderManipulation.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "ORDER")
public class OrderEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String orderId;
	@Column(name = "ORDER_NAME")
	private String orderName;
	@Column(name = "ORDER_BRAND")
	private String orderBrand;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "TRANSACTION_ID", referencedColumnName= "id")
	private TransactionId transactionId;
	
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
	public void setOrderBrand( String orderBrand ) {
		this.orderBrand = orderBrand;
	}
	
	public TransactionId getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId( TransactionId transactionId ) {
		this.transactionId = transactionId;
	}
}
