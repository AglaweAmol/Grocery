package com.grocery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "cart_product")
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartProductId;

	@Column(name = "cart_id")
	private Integer cartId;

	@Column(name = "product_id")
	private Integer productId;

	@OneToOne
	@JoinColumn(name = "cart_Id", updatable = false, insertable = false)
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "product_id", updatable = false, insertable = false)
	@JsonIgnoreProperties("prodRatingList")
	private Product product;

}
