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

import com.grocery.model.Product;
import com.grocery.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productRepository.findAllByProductIsActiveTrue();
	}

	@GetMapping(value = "/products/{productId}")
	public Optional<Product> getProductById(@PathVariable("productId") Integer id) {
		return productRepository.findById(id);
	}

	@PostMapping(value = "/products")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@DeleteMapping(value = "/products/{productId}")
	public void deleteProductByIs(@PathVariable("productId") Integer id) {
		productRepository.deleteById(id);
	}

	@PutMapping(value = "/products")
	public Product updateProductById(@RequestBody Product productRequest) {
		Product product = productRepository.findById(productRequest.getProductId()).get();
		product.setProductName(productRequest.getProductName());
		product.setProductDescription(productRequest.getProductDescription());
		product.setProductAvailableQuantity(productRequest.getProductAvailableQuantity());
		product.setProductIsActive(productRequest.getProductIsActive());
		return productRepository.save(product);
	}

}
