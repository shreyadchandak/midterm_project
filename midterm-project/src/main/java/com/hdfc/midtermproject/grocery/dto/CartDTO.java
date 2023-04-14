package com.hdfc.midtermproject.grocery.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartDTO {

	private long cartId;
	private Set<CartItemDTO> items=new HashSet<>();
	private CustomerDTO customer;
	private double billAmount;
}
