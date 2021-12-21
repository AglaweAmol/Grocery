package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.ProductRating;
import com.grocery.repository.ProductRatingRepository;

@RestController
public class ProductRatingController {

	@Autowired
	private ProductRatingRepository productRatingRepository;

	@GetMapping("/products-rating")
	public List<ProductRating> getAllProductRating() {
		return productRatingRepository.findAll();
	}

	/* Find all product ratings for the perticular product using productby */

	@GetMapping(value = "/products-rating/{productId}")
	public List<ProductRating> getProductRatingById(@PathVariable("productId") Integer prId) {
		List<ProductRating> productRating = productRatingRepository.findByProductId(prId);
		return productRating;
	}

	/* Find productratings by product */

	@GetMapping(value = "/products-ratings/{productRating}")
	public List<ProductRating> getProductRatingsById(@PathVariable("productRating") String productRating) {
		List<ProductRating> productRatingList = productRatingRepository.findByProductRatingLessThan(productRating);
		return productRatingList;
	}



	@PostMapping(value = "/products-ratings")
	public ProductRating addProductRating(@RequestBody ProductRating productRating) {
		return productRatingRepository.save(productRating);
	}

	@PutMapping(value = "/products-ratings")
	public ProductRating updateProductRating(@RequestBody ProductRating productRatingRequest) {
		ProductRating productRating = productRatingRepository.findById(productRatingRequest.getRatingId()).get();
		productRating.setFeedback(productRatingRequest.getFeedback());
		productRating.setProductRating(productRatingRequest.getProductRating());
		productRating.setProductId(productRatingRequest.getProductId());
		return productRatingRepository.save(productRating);
	}

	@DeleteMapping(value = "/products-ratings/{productRatingId}")
	public void deleteByProductRatingID(@PathVariable("productRatingId") Integer id) {
		productRatingRepository.deleteById(id);
	}

}
