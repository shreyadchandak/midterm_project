package com.hdfc.midtermproject.grocery.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private long cartId;
	
	
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL )
	@JsonManagedReference
	private Set<CartItem> items=new HashSet<>();
	
	@OneToOne
	private Customer customer;
	
	@Column(name="Bill_Amount")
	private double billAmount;
	
	
}
