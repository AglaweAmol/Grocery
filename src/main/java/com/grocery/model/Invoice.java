package com.grocery.model;

import java.sql.Date;

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
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceId;

	@Column(name="product_id")
	private Integer productId;

	@Column(name="order_id")
	private Integer orderId;

	@Column(name="quantity")
	private Integer quantity;

	@Column(name="product_total_amount")
	private Double productTotalAmount;

	@Column(name="invoice_date")
	private Date invoiceDate;

	@OneToOne
	@JoinColumn(name = "product_id", updatable = false, insertable = false)
	@JsonIgnoreProperties({"prodRatingList","productImage"})
	private Product product; 	
}
