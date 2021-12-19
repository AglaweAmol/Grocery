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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="cart_Id")
	private Integer cartId;

	@Column(name="customer_Id")
	private Integer customerId;

	@Column(name="total_Price")
	private Integer totalPrice;

	@OneToMany
	@JoinColumn(name ="cart_Id")
	@JsonIgnoreProperties({"cartProductId","cartId","productId","cart"})
	private List<CartProduct> cartProducts;


}
