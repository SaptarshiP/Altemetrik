package com.altemetrik.UserManipulation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altemetrik.UserManipulation.entity.UserEntity;

/*
 * This is the repository interface working on user manipulation
 * */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, String>{

	public List<UserEntity> findByUserId( String userId );
	public List<UserEntity> findByUserNameAndPassword( String userName, String password );
}
