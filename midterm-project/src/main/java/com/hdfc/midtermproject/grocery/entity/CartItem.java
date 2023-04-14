package com.hdfc.midtermproject.grocery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartItemId;
	private int quantity;
	private double totalPrice;
	
	
	@ManyToOne
	@JsonBackReference
	private Cart cart;
	
	@OneToOne
	private Product product;
	
}
