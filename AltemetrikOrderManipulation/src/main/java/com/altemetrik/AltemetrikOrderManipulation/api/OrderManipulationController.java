package com.altemetrik.AltemetrikOrderManipulation.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.altemetrik.AltemetrikOrderManipulation.dto.ResponseModel;
import com.altemetrik.AltemetrikOrderManipulation.dto.TransactionModel;
import com.altemetrik.AltemetrikOrderManipulation.service.OrderManipulationService;

@RestController
public class OrderManipulationController {

	@Autowired
	@Qualifier("ORDER_MANIPULATION_SERVICE")
	private OrderManipulationService orderManipulationService;
	
	
	/*
	 * This api takes the order information and saves it into the table and if exception
	 * happens it will throw the exception to global exception handler
	 * */
	@RequestMapping(value="/orderManipulation", method=RequestMethod.POST)
	public ResponseEntity<ResponseModel> manipulateOrder(@RequestBody TransactionModel transactionModel ){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
				orderManipulationService.manipulateOrder(transactionModel));
	}
	
}
