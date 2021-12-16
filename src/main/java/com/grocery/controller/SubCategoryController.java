package com.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.ProductSubCategory;
import com.grocery.repository.SubCategoryRepository;

@RestController
public class SubCategoryController {

	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	@GetMapping("/getallsubcategory")
	public List<ProductSubCategory> getAllProduct()
	{
		return subCategoryRepository.findAll();
	}
	
	@GetMapping(value ="/getallsubcategory/{subCategoryId}")
    public Optional<ProductSubCategory> getProductByCatID(@PathVariable("subCategoryId") Integer id)
	{
    	return subCategoryRepository.findById(id);
    }
}
