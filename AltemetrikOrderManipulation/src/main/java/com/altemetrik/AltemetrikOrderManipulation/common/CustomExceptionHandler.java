package com.altemetrik.AltemetrikOrderManipulation.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.altemetrik.AltemetrikOrderManipulation.dto.ResponseModel;
import com.altemetrik.AltemetrikOrderManipulation.exception.OrderManipulationCustomException;

@ControllerAdvice
public class CustomExceptionHandler {

	public static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(OrderManipulationCustomException.class)
	public ResponseEntity<ResponseModel> handleOrderManipulationCustomException( 
										OrderManipulationCustomException orderManipulationCustomException ){
		LOGGER.error( orderManipulationCustomException.getMessage() );
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
											.body( new ResponseModel( orderManipulationCustomException.getErrorCode(),
													orderManipulationCustomException.getErrMessage()) );
	}
	
}
