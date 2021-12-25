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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Customer;
import com.grocery.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	//	@GetMapping(value="/customers")
	//	public List<Customer> getAllCustomer() {
	//		return customerRepository.findAll();
	//	}

	@GetMapping(value="/customers")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAllByCustomertIsActiveTrue();
	}


	@GetMapping(value = "/customers/{customerId}")
	public Optional<Customer> getCustomersById(@PathVariable("customerId") Integer customerId) {
		return customerRepository.findAllByCustomerId(customerId);
	}

	@PostMapping(value = "/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping(value = "/customers")
	public Customer updateCustomer(@RequestBody Customer customerRequest) {
		Customer customer = customerRepository.findById(customerRequest.getCustomerId()).get();
		customer.setCart(customerRequest.getCart());
		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setMobileNo(customerRequest.getMobileNo());
		return customerRepository.save(customer);
	}

	@DeleteMapping(value = "/customers/{customerId}")
	public void deleteCustomerById(@PathVariable("customerId") Integer id) {
		customerRepository.deleteById(id);
	}

}
