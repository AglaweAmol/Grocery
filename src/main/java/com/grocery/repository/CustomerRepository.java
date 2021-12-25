package com.grocery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findAllByCustomerId(Integer customerId);

	List<Customer> findAllByCustomertIsActiveTrue();

}
