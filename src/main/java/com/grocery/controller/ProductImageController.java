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

import com.grocery.model.ProductImage;
import com.grocery.repository.ProductImageRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductImageController {

	@Autowired
	private ProductImageRepository productImageRepository;

	@GetMapping(value = "/product-image")
	public List<ProductImage> getAllProductImage() {
		return productImageRepository.findAll();
	}

	@GetMapping(value = "/product-image/{imageId}")
	public Optional<ProductImage> getProductIamgeById(@PathVariable("imageId") Integer imageId) {
		return productImageRepository.findById(imageId);
	}

	@PostMapping(value = "/product-image")
	public ProductImage addProductImage(@RequestBody ProductImage productImage) {
		return productImageRepository.save(productImage);
	}

	@PutMapping(value = "/product-image")
	public ProductImage updateProductImage(@RequestBody ProductImage productImageRequest) {
		ProductImage productimage = productImageRepository.findById(productImageRequest.getImageId()).get();
		productimage.setImageProductId(productImageRequest.getImageProductId());
		productimage.setImageUrl(productImageRequest.getImageUrl());
		return productImageRepository.save(productimage);
	}

	@DeleteMapping(value = "/product-image/{imageId}")
	public void deleteImageById(@PathVariable("imageId") Integer id) {
		productImageRepository.deleteById(id);
	}

}
