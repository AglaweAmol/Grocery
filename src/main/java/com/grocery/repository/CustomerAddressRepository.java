package com.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.model.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

	List<CustomerAddress> findByCustomerId(Integer customerId);

	CustomerAddress findByCustAddressId(Integer customerAddressID);

}
