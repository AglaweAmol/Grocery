package com.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Product;
import com.grocery.model.ProductRating;
import com.grocery.repository.ProductRatingRepository;



@RestController
public class ProductRatingController {
	
	@Autowired
	private ProductRatingRepository productRatingRepository;
	
	@GetMapping("/products-rating")
	public List<ProductRating> getAllProductRating()
	{
		return productRatingRepository.findAll();
	}



	@GetMapping(value = "/products-rating/{productId}")
	public List<ProductRating> getProductRatingById(@PathVariable("productId") Integer prId) {
		List<ProductRating> productRating = productRatingRepository.findByProductId(prId);

		return  productRating;
	}
	
	
	@GetMapping(value = "/products-ratings/{productId}")
	public List<ProductRating> getProductRatingsById(@PathVariable("productId") String productRatings) {
		List<ProductRating> productRating = productRatingRepository.findByProductRatingLessThan(productRatings);

		return  productRating;
	}
	
	
//	findByAgeLessThan
	
	
}
