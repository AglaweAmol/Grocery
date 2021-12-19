package com.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Cart;
import com.grocery.model.Customer;
import com.grocery.repository.CartRepository;
import com.grocery.repository.CustomerRepository;

@RestController
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping(value = "/cart")
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

	@GetMapping(value = "/cart/{cartId}")
	public Optional<Cart> getAllProductsByCartId(@PathVariable("cartId") Integer cartId) {
		return cartRepository.findById(cartId);
	}

	@GetMapping(value = "/customer/{customerId}")
	public Optional<Customer> getCartByCustomerId(@PathVariable("customerId") Integer customerId) {
		return customerRepository.findAllByCustomerId(customerId);
	}

}
