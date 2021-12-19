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

import com.grocery.model.ProductSubCategory;
import com.grocery.repository.SubCategoryRepository;

@RestController
public class SubCategoryController {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@GetMapping("/subcategories")
	public List<ProductSubCategory> getAllProduct() {
		return subCategoryRepository.findAll();
	}

	@GetMapping(value = "/subcategories/{subCategoryId}")
	public Optional<ProductSubCategory> getProductByCatID(@PathVariable("subCategoryId") Integer id) {
		return subCategoryRepository.findById(id);
	}

	@PostMapping(value = "/subcategories")
	public ProductSubCategory addSubCatgory(@RequestBody ProductSubCategory productSubCategory) {
		return subCategoryRepository.save(productSubCategory);
	}

	@PutMapping(value = "/subcategories")
	public ProductSubCategory updateSubCategory(@RequestBody ProductSubCategory productSubCategory) {
		ProductSubCategory productSubCategories = subCategoryRepository.findById(productSubCategory.getSubcategoryId())
				.get();
		productSubCategories.setCategory_Id(productSubCategory.getCategory_Id());
		productSubCategories.setSubcategoryName(productSubCategory.getSubcategoryName());
		return subCategoryRepository.save(productSubCategory);
	}

	@DeleteMapping(value = "/subcategories/{subCategoryId}")
	public void deleteSubCategoriesById(@PathVariable("subCategoryId") Integer id) {
		subCategoryRepository.deleteById(id);
	}

}
