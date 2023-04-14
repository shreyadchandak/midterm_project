package com.hdfc.midtermproject.grocery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTOPretty {

	private long productId;
	private String productName;
	private int Quantity;
	private double totalPrice;
}
