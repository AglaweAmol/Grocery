package com.grocery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@Column(name = "product_unit_id")
	private Integer productUnitId;

	@Column(name = "product_Name")
	private String productName;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_available_quantity")
	private Integer productAvailableQuantity;

	@Column(name = "product_buying_price")
	private Double productBuyingPrice;


	@Column(name = "product_is_active")
	private Boolean productIsActive;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_Id")
	private List<ProductRating> prodRatingList; 	
}
