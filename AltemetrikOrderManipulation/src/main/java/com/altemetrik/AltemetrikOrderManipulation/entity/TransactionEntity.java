package com.altemetrik.AltemetrikOrderManipulation.entity;

import java.util.List;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity implements Serializable{

	@EmbeddedId
	private TransactionId id;
	@Column(name="TRANSACTION_ID")
	private String transactionId;
	@Column(name = "USER_ID")
	private String userName;
	@Column(name="TRANSACTION_NAME")
	private String transactionName;
	@OneToMany(cascade=CascadeType.ALL )
	private List<OrderEntity> orderEntityList;
	
	public TransactionId getId() {
		return this.id;
	}
	public void setId( TransactionId id ) {
		this.id = id;
	}
	
	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId( String transactionId ) {
		this.transactionId = transactionId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	public void setUserName( String userName ) {
		this.userName = userName;
	}
	
	public String getTransactionName() {
		return this.transactionName;
	}
	public void setTransactionName( String transactionName ) {
		this.transactionName = transactionName;
	}
	
	public List<OrderEntity> getOrderEntityList(){
		return this.orderEntityList;
	}
	public void setOrderEntityList( List<OrderEntity> orderEntityList ) {
		this.orderEntityList = orderEntityList;
	}
}
