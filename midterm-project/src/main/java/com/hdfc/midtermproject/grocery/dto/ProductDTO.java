package com.hdfc.midtermproject.grocery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

	  
	  

	  private String productName;

	
	  private String productDescription;

	  
	  private double productPrice;

	 
	  private String productBrand;

	 
	  private String productCategory;

	 
	  
	  
	 
	  private boolean live;
	  private boolean stock;
	  
	  
	  private String productImageName;
	  
	  
	  
}
