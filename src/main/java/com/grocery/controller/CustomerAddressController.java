package com.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.CustomerAddress;
import com.grocery.repository.CustomerAddressRepository;

@RestController
public class CustomerAddressController {

	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@GetMapping(value = "/customer-address")
	public List<CustomerAddress> getAllCustomerAddress() {
		return customerAddressRepository.findAll();
	}

	@GetMapping(value = "/customer-address/{customerAddressId}")
	public Optional<CustomerAddress> getCustomersAddressById(
			@PathVariable("customerAddressId") Integer customerAddressId) {
		return customerAddressRepository.findById(customerAddressId);
	}

	@PostMapping(value = "/customer-address")
	public CustomerAddress addCustomerAddress(@RequestBody CustomerAddress customerAddress) {
		return customerAddressRepository.save(customerAddress);
	}

	@PutMapping(value = "/customer-address")
	public CustomerAddress updateCustomerAddresss(@RequestBody CustomerAddress customerAddress) {
		CustomerAddress customersAddr = customerAddressRepository.findById(customerAddress.getCustAddressId()).get();
		customersAddr.setCity(customerAddress.getCity());
		customersAddr.setStreet(customerAddress.getStreet());
		customersAddr.setState(customerAddress.getState());
		customersAddr.setCountry(customerAddress.getCountry());
		return customerAddressRepository.save(customerAddress);
	}

	@DeleteMapping(value = "/customer-address/{customerAddressId}")
	public void deleteCustomeAddressrById(@PathVariable("customerAddressId") Integer id) {
		customerAddressRepository.deleteById(id);
	}

	@PutMapping(value = "/customer-address/mark-default/{customerAddressId}")
	public CustomerAddress markAddressAsDefault(@PathVariable("customerAddressId") Integer customerAddressId) {
		CustomerAddress customersAddr = customerAddressRepository.findById(customerAddressId).get();
		customersAddr.setIsDefault(customersAddr.getIsDefault()==false?true:customersAddr.getIsDefault());
		return customerAddressRepository.save(customersAddr);
	}

}
