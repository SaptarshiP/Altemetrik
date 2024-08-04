package com.altemetrik.UserManipulation.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.altemetrik.UserManipulation.dto.ResponseBody;
import com.altemetrik.UserManipulation.dto.UserInformationBody;
import com.altemetrik.UserManipulation.service.UserManipulationService;

@RestController
public class UserManipulationController {

	@Autowired
	private UserManipulationService userManipulationService;
	
	
	/*
	 * This method is used for retrieving the data for user creation
	 * */
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	public ResponseEntity<ResponseBody> createUser(@RequestBody UserInformationBody createUserRequest){
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
				userManipulationService.saveUserData(createUserRequest));
	}

	
	/*
	 * This api is for retrieving the user information of the user
	 * */
	@RequestMapping(value="/getUser", method=RequestMethod.GET)
	public ResponseEntity<ResponseBody> getUser( @RequestParam("userId")String userId ){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
												.body( userManipulationService.getUserData(userId) );
	}
	
	/*
	 * This api is provided with username and password and authenticating the credential
	 * if the user is authenticated it returns the jwt token
	 * if the user is not authenticated it will give unauthorized error
	 * */
	@RequestMapping(value="/authenticate", method=RequestMethod.GET)
	public ResponseEntity<ResponseBody> createJsonTokenAfterAuthentication( @RequestParam("USER_NAME")String userName,
																				@RequestParam("USER_PASSWORD")String userPassword){
		
		return userManipulationService.authenticateUsingUserNameAndPasswordAndReturnJWTToken(userName, 
																			userPassword);
	}
}
