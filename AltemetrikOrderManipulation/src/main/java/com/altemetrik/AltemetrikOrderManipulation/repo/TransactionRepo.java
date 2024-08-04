package com.altemetrik.AltemetrikOrderManipulation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altemetrik.AltemetrikOrderManipulation.entity.TransactionEntity;
import com.altemetrik.AltemetrikOrderManipulation.entity.TransactionId;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity, TransactionId>{

}
