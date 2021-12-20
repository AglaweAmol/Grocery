package com.grocery.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "mobile_no")
	private Long mobileNo;

	@OneToOne
	@JoinColumn(name = "customer_id", updatable = false, insertable = false)
	private Cart cart;

	@OneToMany
	@JoinColumn(name = "customer_id", updatable = false, insertable = false)
	private List<CustomerAddress> customerAddress;
}
