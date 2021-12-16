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
@Table(name="product_category")
public class ProductCategory {
	
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	
	@Column(name="category_is_active")
	private Boolean categoryIsActive;
	
	
	@OneToMany
	@JoinColumn(name="category_id")
	private List<ProductSubCategory> subCategoryList; 
	
	
	

}
