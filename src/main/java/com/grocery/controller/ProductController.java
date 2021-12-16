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

import com.grocery.model.Product;
import com.grocery.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/getall")
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	
    @GetMapping(value ="/{productById}")
	public Optional<Product> getProductByID(@PathVariable("productById") Integer id) {
		return productRepository.findById(id);
	}
    
    
    @DeleteMapping(value ="/{deleteProductById}")
	public void deleteProductByID(@PathVariable("deleteProductById") Integer id) {
		 productRepository.deleteById(id); 
	}
    
    @PutMapping(value ="/update")
    public Product updateProductByID(@RequestBody Product product)
     {
    	Product prod = productRepository.findById(product.getProductId()).get();
    	prod.setProductName(product.getProductName());
    	 return productRepository.save(prod);
     }
    
}