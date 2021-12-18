package com.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.model.Product;
import com.grocery.model.ProductRating;

@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating, Integer> {




	List<ProductRating> findByProductId(Integer prId);


	List<ProductRating> findByProductRatingLessThan(String productRatings);


}
