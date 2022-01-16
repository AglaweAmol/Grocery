package com.grocery.model;

import java.util.Date;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

	@Column(name="cart_total_price")
	private Integer cartTotalPrice;

	@Column(name="cart_product_quantity_pricing_id")
	private Integer cartProductQuantityPricingId;

	@Column(name="cart_offer_product_id")
	private Integer cartOfferProductId;

	@Column(name="cart_item_quantity")
	private Integer cartItemQuantity;

	@Column(name="cart_is_product_from_offer")
	private Boolean cartIsProdFromOffer;

	@Column(name="cart_last_updated_by")
	private String cartLastUpdatedBy;

	@CreatedDate
	@CreationTimestamp
	@Column(name="cart_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
	private Date cartCreatedDate;

	@LastModifiedDate
	@UpdateTimestamp
	@Column(name="cart_last_updated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
	private Date cartLastUpdatedDate;



	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="cart_id")
	@JsonIgnoreProperties({"cartProductId","cartId","cart"})
	private List<CartProduct> cartProducts;


}
