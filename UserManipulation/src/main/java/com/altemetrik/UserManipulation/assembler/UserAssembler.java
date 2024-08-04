package com.altemetrik.UserManipulation.assembler;

import org.springframework.stereotype.Component;

import com.altemetrik.UserManipulation.dto.UserInformationBody;
import com.altemetrik.UserManipulation.entity.UserEntity;

@Component
public class UserAssembler {

	/*
	 * This method is used for converting the user information request body to user entity format
	 * */
	public UserEntity toDomain( UserInformationBody userInformationBody ) {
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserId(userInformationBody.getUserId());
		userEntity.setUserName( userInformationBody.getUserName() );
		userEntity.setUserPassword( userInformationBody.getUserPassword() );
		
		return userEntity;
	}
	 
	
	public UserInformationBody fromDomain( UserEntity userEntity ) {
		
		UserInformationBody userInformationBody = new UserInformationBody();
		userInformationBody.setUserId( userEntity.getUserId() );
		userInformationBody.setUserName( userEntity.getUserName() );
		userInformationBody.setUserPassword( userEntity.getUserPassword() );
		
		return userInformationBody;
	} 
	
}
