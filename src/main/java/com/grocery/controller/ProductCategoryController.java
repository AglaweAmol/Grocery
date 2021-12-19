package com.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.ProductCategory;
import com.grocery.repository.ProductCategoryRepository;

@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@GetMapping(value = "/categories")
	public List<ProductCategory> getAllProductCategory() {
		return productCategoryRepository.findAll();
	}

	@GetMapping(value = "/categories/{categoryId}")
	public Optional<ProductCategory> getProductByCatID(@PathVariable("categoryId") Integer id) {
		return productCategoryRepository.findById(id);
	}

	@DeleteMapping(value = "/categories/{categoryId}")
	public void deleteProductByCatId(@PathVariable("categoryId") Integer id) {
		productCategoryRepository.deleteById(id);
	}

	@PutMapping(value = "/categories")
	public ProductCategory updateProductByCatId(@RequestBody ProductCategory productcategory) {
		ProductCategory prodcat = productCategoryRepository.findById(productcategory.getCategoryId()).get();
		prodcat.setCategoryName(productcategory.getCategoryName());
		return productCategoryRepository.save(prodcat);
	}

}
