package com.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.model.ProductSubCategory;

@Repository
public interface SubCategoryRepository  extends JpaRepository<ProductSubCategory,Integer> {

}
