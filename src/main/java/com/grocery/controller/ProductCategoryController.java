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

import com.grocery.model.ProductCategory;
import com.grocery.repository.ProductCategoryRepository;

@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@GetMapping(value = "/categories")
	public List<ProductCategory> getAllCategory() {
		return productCategoryRepository.findAll();
	}

	@GetMapping(value = "/categories/{categoryId}")
	public Optional<ProductCategory> getCategoryId(@PathVariable("categoryId") Integer id) {
		return productCategoryRepository.findById(id);
	}

	@PostMapping(value = "/categories")
	public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	@DeleteMapping(value = "/categories/{categoryId}")
	public void deleteCategoryById(@PathVariable("categoryId") Integer id) {
		productCategoryRepository.deleteById(id);
	}

	@PutMapping(value = "/categories")
	public ProductCategory updateCategoryById(@RequestBody ProductCategory productCategoryRequest) {
		ProductCategory productCategory = productCategoryRepository.findById(productCategoryRequest.getCategoryId()).get();
		productCategory.setCategoryName(productCategoryRequest.getCategoryName());
		productCategory.setCategoryIsActive(productCategoryRequest.getCategoryIsActive());
		return productCategoryRepository.save(productCategory);
	}

}
