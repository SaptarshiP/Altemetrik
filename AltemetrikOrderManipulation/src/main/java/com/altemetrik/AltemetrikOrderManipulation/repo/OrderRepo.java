package com.altemetrik.AltemetrikOrderManipulation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altemetrik.AltemetrikOrderManipulation.entity.OrderEntity;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, String>{

}
