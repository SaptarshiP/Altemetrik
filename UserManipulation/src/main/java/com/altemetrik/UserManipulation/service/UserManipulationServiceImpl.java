package com.altemetrik.UserManipulation.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import com.altemetrik.UserManipulation.assembler.UserAssembler;
import com.altemetrik.UserManipulation.dto.ErrorResponse;
import com.altemetrik.UserManipulation.dto.ResponseBody;
import com.altemetrik.UserManipulation.dto.SuccessResponse;
import com.altemetrik.UserManipulation.dto.UserInformationBody;
import com.altemetrik.UserManipulation.entity.UserEntity;
import com.altemetrik.UserManipulation.exception.UserManipulationCustomException;
import com.altemetrik.UserManipulation.repo.UserRepo;
import com.altemetrik.UserManipulation.util.UserManipulationConstants;

import io.jsonwebtoken.Jwts;

@Service
public class UserManipulationServiceImpl implements UserManipulationService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserAssembler userAssembler;
	
	@Value("${error.in.save.code}")
	private String errorSaveCode;
	@Value("${error.in.save.message}")
	private String errorSaveMessage;
	@Value("${success.in.save.code}")
	private String successSaveCode;
	@Value("${success.in.save.message}")
	private String successSaveMessage;
	@Value("${error.retrieve.code}")
	private String errorRetrieveCode;
	@Value("${error.retrieve.message}")
	private String errorRetrieveMessage;
	@Value("${error.retrieve.unauthenticated.code}")
	private String unauthenticatedUserCode;
	@Value("${error.retrieve.unauthenticated.message}")
	private String unauthenticatedUserMessage;
	@Value("${error.in.authentication.code}")
	private String errorInAuthenticatingCode;
	@Value("${error.in.authentication.message}")
	private String errorInAuthenticatingMessage;
	
	/*
	 * This method on service is used for saving the user information in db
	 * */
	@Override
	public ResponseBody saveUserData( UserInformationBody createUserRequestBody) {
		try {
			UserEntity userEntity = userAssembler.toDomain(createUserRequestBody);
			userRepo.save( userEntity );
		}catch( Exception exp ) {
			throw new UserManipulationCustomException(exp, errorSaveCode, errorSaveMessage);
		}
		
		SuccessResponse successResponse = new SuccessResponse( successSaveCode, successSaveMessage );
		return new ResponseBody( successResponse );
	}
	
	/*
	 * This method is used for getting the user information
	 * */
	@Override
	public ResponseBody getUserData( String userId ) {
		List<UserInformationBody> userInformationBodyList = new ArrayList<>();
		try {
			List<UserEntity> userEntityList = userRepo.findByUserId( userId );
			for ( UserEntity userEntity: userEntityList ) {
				userInformationBodyList.add( userAssembler.fromDomain(userEntity) );
			}
		}catch( Exception exp ) {
			throw new UserManipulationCustomException(exp, errorRetrieveCode, errorRetrieveMessage);
		}
		return new ResponseBody( userInformationBodyList );
	}
	
	/*
	 * Authenticate the credential and return the proper response
	 * */
	@Override
	public ResponseEntity<ResponseBody> authenticateUsingUserNameAndPasswordAndReturnJWTToken( String userName, 
																		String password ) {
		ResponseBody responseBody = null;
		try {
			List<UserEntity> userEntityList = userRepo.findByUserNameAndPassword(userName, password);
			if ( userEntityList.isEmpty() ) {
				responseBody = new ResponseBody( 
										new ErrorResponse(unauthenticatedUserCode, unauthenticatedUserMessage) );
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).contentType(MediaType.APPLICATION_JSON)
																			.body( responseBody );
			}
			Map<String, String> claim = new HashMap<>();
			claim.put(UserManipulationConstants.USER_ID, userEntityList.get(0).getUserId());
			claim.put( UserManipulationConstants.USER_NAME, userEntityList.get(0).getUserName() );
			String jwtToken = createJWTAuthenticationToken( claim );
			Map<String, String> responseMap = new HashMap<>();
			responseMap.put(UserManipulationConstants.JWT_TOKEN, jwtToken);
			responseBody = new ResponseBody( responseMap );
		}catch( Exception exp ) {
			throw new UserManipulationCustomException(exp, errorInAuthenticatingCode, 
																errorInAuthenticatingMessage);
		}
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
																	.body(responseBody);
	}
	
	/*
	 * Create the JWT Token with respect to claim
	 * */
	public String createJWTAuthenticationToken( Map<String, String> claim ) {
		return Jwts.builder().claims(claim)
								.compact();
	}
}
