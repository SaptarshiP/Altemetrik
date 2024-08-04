package com.altemetrik.UserManipulation.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.altemetrik.UserManipulation.dto.ErrorResponse;
import com.altemetrik.UserManipulation.dto.ResponseBody;
import com.altemetrik.UserManipulation.exception.UserManipulationCustomException;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/*
	 * It is used for globally handling custom exception handler
	 * */
	@ExceptionHandler( UserManipulationCustomException.class )
	public ResponseEntity<ResponseBody> handleUserManipulationCustomException( 
									UserManipulationCustomException userManipulationCustomException ) {

		LOGGER.error( userManipulationCustomException .getMessage() );
		ErrorResponse errMessage = new ErrorResponse(userManipulationCustomException.getErrorCode(), 
														userManipulationCustomException.getErrorMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
																.body( new ResponseBody( errMessage ) );
	}
}
