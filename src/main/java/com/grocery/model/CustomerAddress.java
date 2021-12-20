package com.grocery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customer_address")
public class CustomerAddress {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custAddressId;

	@Column(name="customer_id")
	private Integer customerId;

	@Column(name="street")
	private String street;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="country")
	private String country;
	
	@Column(name="is_default")
	private Boolean isDefault;


}
