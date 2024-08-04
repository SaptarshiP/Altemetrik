package com.altemetrik.AltemetrikOrderManipulation.assembler;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.altemetrik.AltemetrikOrderManipulation.dto.OrderModel;
import com.altemetrik.AltemetrikOrderManipulation.dto.TransactionModel;
import com.altemetrik.AltemetrikOrderManipulation.entity.OrderEntity;
import com.altemetrik.AltemetrikOrderManipulation.entity.TransactionEntity;
import com.altemetrik.AltemetrikOrderManipulation.entity.TransactionId;

@Component
public class OrderManipulationAssembler {

	public TransactionEntity toDomain( TransactionModel transactionModel ) {
		
		TransactionEntity transactionEntity = new TransactionEntity();
		TransactionId transactionId = new TransactionId( transactionModel.getTransactionId(),
				transactionModel.getUserId());
		transactionEntity.setId(transactionId);
		transactionEntity.setTransactionId( transactionModel.getTransactionId() );
		transactionEntity.setTransactionName( transactionModel.getTransactionName() );
		List<OrderEntity> orderEntityList = new ArrayList<>();
		for ( OrderModel orderModel: transactionModel.getOrderList() ) {
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setOrderId( orderModel.getOrderId() );
			orderEntity.setOrderName( orderModel.getOrderName() );
			orderEntity.setOrderBrand( orderModel.getOrderBrand() );
			orderEntity.setTransactionId(transactionId);
			orderEntityList.add(orderEntity);
		}
		
		transactionEntity.setOrderEntityList( orderEntityList );
		return transactionEntity;
	}
	
}
