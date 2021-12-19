package com.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
