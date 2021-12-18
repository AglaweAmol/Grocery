package com.grocery.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product_rating")
public class ProductRating {


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="rating_id")
	private Integer ratingId;
	
	@Column(name="product_Id")
	private Integer productId;
	
	@Column(name="product_rating")
	private String productRating;
	
	
	@Column(name="feedback")
	private String feedback;
	
	

}
