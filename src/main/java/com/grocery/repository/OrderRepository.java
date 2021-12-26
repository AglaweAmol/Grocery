package com.grocery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Optional<Order> findAllOrdersByCustomerId(Integer id);

}
