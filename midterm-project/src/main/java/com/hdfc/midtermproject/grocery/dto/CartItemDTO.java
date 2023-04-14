package com.hdfc.midtermproject.grocery.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {

	private long cartItemId;
	private int quantity;
	private double totalPrice;
	private CartDTO cart;
	private ProductDTO product;
}
