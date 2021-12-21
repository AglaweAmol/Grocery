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

import com.grocery.model.Cart;
import com.grocery.repository.CartRepository;

@RestController
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@GetMapping(value = "/cart")
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

	@GetMapping(value = "/cart/{cartId}")
	public Optional<Cart> getAllProductsByCartId(@PathVariable("cartId") Integer cartId) {
		return cartRepository.findById(cartId);
	}

	@PostMapping(value = "/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartRepository.save(cart);
	}

	@PutMapping(value = "/cart")
	public Cart updateCart(@RequestBody Cart cartRequest) {
		Cart cart = cartRepository.findById(cartRequest.getCartId()).get();
		cart.setCartProducts(cart.getCartProducts());
		cart.setTotalPrice(cart.getTotalPrice());
		cart.setCustomerId(cart.getCustomerId());
		return cartRepository.save(cartRequest);
	}
	
	@DeleteMapping(value = "/cart/{cartId}")
	public void deleteCartById(@PathVariable("cartId") Integer id) {
		cartRepository.deleteById(id);
	}

	

}
