package com.grocery.model;

import java.sql.Date;
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

import lombok.Data;

@Data
@Entity
@Table(name="order_details")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;


	@Column(name="customer_id")
	private Integer customerId;

	@Column(name="customer_address_id")
	private Integer customerAddressID;

	@Column(name="order_status")
	private String orderStatus;

	@Column(name="order_total_quantity")
	private Integer orderTotalQuantity;

	@Column(name="order_total")
	private Double orderTotal;

	@Column(name="order_date")
	private Date orderDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<Invoice> invoiceList; 	




}
