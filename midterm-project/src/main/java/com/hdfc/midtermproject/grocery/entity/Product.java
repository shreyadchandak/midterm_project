package com.hdfc.midtermproject.grocery.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "products")

public class Product {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "product_id")
	  private long productId;

	  @Column(name = "name", nullable = false)
	  private String productName;

	  @Column(name = "description")
	  private String productDescription;

	  @Column(name = "price", nullable = false)
	  private double productPrice;

	  @Column(name = "brand")
	  private String productBrand;

	  @Column(name = "category")
	  private String productCategory;

	  
	  @Column(name="stock")
	  private boolean stock;
	  
	  @Column(name="image_url")
	  private String productImageName;
	  
	  @Column(name="is_live")
	  private boolean live;
	  
	  
	  
	 
	}



