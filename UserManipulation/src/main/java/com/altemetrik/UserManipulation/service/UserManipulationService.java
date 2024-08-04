package com.altemetrik.UserManipulation.service;

import org.springframework.http.ResponseEntity;

import com.altemetrik.UserManipulation.dto.ResponseBody;
import com.altemetrik.UserManipulation.dto.UserInformationBody;

public interface UserManipulationService {

	public ResponseBody saveUserData( UserInformationBody createUserRequestBody);
	public ResponseBody getUserData( String userId );
	public ResponseEntity<ResponseBody> authenticateUsingUserNameAndPasswordAndReturnJWTToken( String userName, String password );
}
