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

import com.grocery.model.Cart;
import com.grocery.repository.CartRepository;

@RestController
@RequestMapping("/api/v1")
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

	//	@GetMapping(value = "/cart/customer/{customerId}")
	//	public List<Cart> getCartByCustomerId(@PathVariable("customerId") Integer customerId) {
	//		return cartRepository.findByCustomerId(customerId);
	//	}

	@PostMapping(value = "/cart")
	public Cart addCart(@RequestBody Cart cart) {

		System.out.println("CartObject"+cart);
		return cartRepository.save(cart);
	}

	@PutMapping(value = "/cart")
	public Cart updateCart(@RequestBody Cart cartRequest) {
		Cart cart = cartRepository.findById(cartRequest.getCartId()).get();
		cart.setCartProducts(cartRequest.getCartProducts());
		cart.setCartTotalPrice(cartRequest.getCartTotalPrice());
		cart.setCustomerId(cartRequest.getCustomerId());
		return cartRepository.save(cart);
	}

	@DeleteMapping(value = "/cart/{cartId}")
	public void deleteCartById(@PathVariable("cartId") Integer id) {
		cartRepository.deleteById(id);
	}



}
