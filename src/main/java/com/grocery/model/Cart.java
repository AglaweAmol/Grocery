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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Integer cartId;

	@Column(name="customer_id")
	private Integer customerId;

	@Column(name="total_price")
	private Integer totalPrice;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="cart_id")
	@JsonIgnoreProperties({"cartProductId","cartId","cart"})
	private List<CartProduct> cartProducts;


}
