package com.altemetrik.AltemetrikOrderManipulation.service;

import com.altemetrik.AltemetrikOrderManipulation.dto.ResponseModel;
import com.altemetrik.AltemetrikOrderManipulation.dto.TransactionModel;

public interface OrderManipulationService {

	public ResponseModel manipulateOrder( TransactionModel transactionModel );
	
}
