package com.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findByCustomerId(Integer customerId);





}
