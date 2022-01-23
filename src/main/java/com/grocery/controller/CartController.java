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
import com.grocery.model.CartProduct;
import com.grocery.model.Product;
import com.grocery.repository.CartRepository;
import com.grocery.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(value = "/cart")
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

	@GetMapping(value = "/cart/{cartId}")
	public Optional<Cart> getAllProductsByCartId(@PathVariable("cartId") Integer cartId) {
		return cartRepository.findById(cartId);
	}

	// @GetMapping(value = "/cart/customer/{customerId}")
	// public List<Cart> getCartByCustomerId(@PathVariable("customerId") Integer
	// customerId) {
	// return cartRepository.findByCustomerId(customerId);
	// }

	@PostMapping(value = "/cart")
	public Cart addCart(@RequestBody Cart cartRequest) {

		Integer cartItemQuantity = 0;
		Double CartTotalPrice = 0.0;
		boolean isCheckProductQuantity = true;
		List<CartProduct> cartProductlist = cartRequest.getCartProducts();

		for (CartProduct i : cartProductlist) {
			Integer cartProductItemQuantity = i.getCartProductQuantity();
			Integer productId = i.getProductId();
			Optional<Product> product = productRepository.findById(productId);
			Integer productAvailableQuantity= product.get().getProductAvailableQuantity();
			if(productAvailableQuantity < cartProductItemQuantity)
			{
				isCheckProductQuantity=false;
				System.out.println("Requested quantity is too high. Order cannot be saved");
			}
			else {
				Double productBuyingPrice = product.get().getProductBuyingPrice();
				cartItemQuantity = cartItemQuantity + cartProductItemQuantity;
				Double cartProductQuantityPricing = productBuyingPrice * cartProductItemQuantity;
				CartTotalPrice = CartTotalPrice + cartProductQuantityPricing;

			}
		}
		if(isCheckProductQuantity==false)
		{
			System.out.println("Requested quantity is too high. Order cannot be saved");
		}
		else {
			cartRequest.setCartItemQuantity(cartItemQuantity);
			cartRequest.setCartTotalPrice(CartTotalPrice);

			cartRepository.save(cartRequest);

			//		cartRequest.setCustomerId(cartItemQuantity)
			System.out.println(cartRequest);
		}
		// System.out.println("CartObject"+cartRequest);
		// return cartRepository.save(cartRequest);

		return null;
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
