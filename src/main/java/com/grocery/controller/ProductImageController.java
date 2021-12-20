package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.ProductImage;
import com.grocery.repository.ProductImageRepository;

@RestController
public class ProductImageController {

	@Autowired
	private ProductImageRepository productImageRepository;

	@GetMapping(value = "/product-image")
	public List<ProductImage> getAllProductImage() {
		return productImageRepository.findAll();

	}
}
