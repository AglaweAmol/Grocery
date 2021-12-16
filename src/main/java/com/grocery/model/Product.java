package com.grocery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "product_selling_price")
	private Double productSellingPrice;

	@Column(name = "product_offer_price")
	private Double productOfferPrice;

	@Column(name = "product_is_active")
	private Boolean productIsActive;

	@Column(name = "product_category_id")
	private Integer productCategoryId;
	
	
}
