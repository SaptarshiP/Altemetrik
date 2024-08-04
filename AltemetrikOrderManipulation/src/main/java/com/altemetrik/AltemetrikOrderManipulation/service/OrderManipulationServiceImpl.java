package com.altemetrik.AltemetrikOrderManipulation.service;

import java.util.Optional;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.altemetrik.AltemetrikOrderManipulation.assembler.OrderManipulationAssembler;
import com.altemetrik.AltemetrikOrderManipulation.dto.ResponseModel;
import com.altemetrik.AltemetrikOrderManipulation.dto.TransactionModel;
import com.altemetrik.AltemetrikOrderManipulation.entity.TransactionEntity;
import com.altemetrik.AltemetrikOrderManipulation.exception.OrderManipulationCustomException;
import com.altemetrik.AltemetrikOrderManipulation.repo.TransactionRepo;
import com.altemetrik.AltemetrikOrderManipulation.util.OrderManipulationConstants;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service("ORDER_MANIPULATION_SERVICE")
public class OrderManipulationServiceImpl implements OrderManipulationService{

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OrderManipulationAssembler orderManipulationAssembler;
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Value("${service.UserManipulationService.getUserName.url}")
	private String getUserEndPoint;
	@Value("${err.user.info.not.got.code}")
	private String errUserInfoNoGotCode;
	@Value("${err.user.info.not.got.message}")
	private String errUserInfoNoGotMessage;
	@Value("${err.in.saving.data.code}")
	private String errorInSavingDataErrorCode;
	@Value("${err.in.saving.data.message}")
	private String errorInSavingDataErrorMessage;
	@Value("${success.saving.code}")
	private String successSavingCode;
	@Value("${success.saving.message}")
	private String successSavingMessage;
	
	
	/*
	 * This method takes order information then calls to user manipulation service
	 * to get the username with respect to the user id and stores the required order data and
	 * transaction data into table
	 * */
	@Override
	@Transactional
	public ResponseModel manipulateOrder( TransactionModel transactionModel ) {
	
		try {
			Optional<String> userNameOptional = Optional.ofNullable(getUserNameFromUserId( transactionModel.getUserId() ));
			if ( userNameOptional.isEmpty() ) {
				throw new OrderManipulationCustomException(new Exception(errUserInfoNoGotCode), errUserInfoNoGotCode,
																	errUserInfoNoGotMessage);
			}
			String userName = parseJsonForUserName(userNameOptional.get());
			TransactionEntity transactionEntity = orderManipulationAssembler.toDomain(transactionModel);
			transactionEntity.setUserName(userName);
			transactionRepo.save( transactionEntity );
		}catch( OrderManipulationCustomException exp ) {
			throw exp;
		}catch(Exception exp) {
			throw new OrderManipulationCustomException(exp, errorInSavingDataErrorCode,
					errorInSavingDataErrorMessage);
		}
		return new ResponseModel( successSavingCode, successSavingMessage );
	}
	
	/*
	 * This method is called from manipulateOrder which retrieves the username using userId 
	 * from the user service and returns the json data this works on loadbalanced(ribbon) and
	 * circuit breaker archtecture(ressilence4j)
	 * */
	@CircuitBreaker(name = "CircuitBreakerService", fallbackMethod = "fallBackMethod")
	private String getUserNameFromUserId( String userId ) {
		ResponseEntity<String> response = null;
		try {
			StringBuilder urlBuilder  = new StringBuilder( "http://" );
			urlBuilder = urlBuilder.append(OrderManipulationConstants.USER_MANIPULATION_SERVICE)
																.append(getUserEndPoint).append("?userId=").append(userId);
		
			response = restTemplate.getForEntity(urlBuilder.toString(), 
																			String.class, Map.class);
		} catch( Exception exp ) {
			throw exp;
		}
		
		return response.getBody();
	}
	
	/*
	 * This works as a fallbackmethod using ressilence4j
	 * */
	public String fallBackMethod() {
		return null;
	}
	
	/*
	 * Parse the json response and return the username from user service
	 * */
	private String parseJsonForUserName( String jsonBody )throws Exception {
		JSONObject jsonObject = new JSONObject(jsonBody);
		return jsonObject.getJSONArray("DATA").getJSONObject(0).getString("userName");
	}
	
}
