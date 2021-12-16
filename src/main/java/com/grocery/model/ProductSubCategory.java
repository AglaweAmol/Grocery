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

import lombok.Data;


@Data
@Entity
@Table(name="product_subcategory")
public class ProductSubCategory {

	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="sub_category_id")
	private Integer subcategoryId;
	
	@Column(name="sub_category_name")
	private String subcategoryName;
	
	
	@Column(name="category_id")
	private Integer category_Id;
	
	@Column(name="product_id")
	private Integer product_Id;
	
	@OneToMany
	@JoinColumn(name="sub_category_id")
	private List<Product> prodList; 
}
