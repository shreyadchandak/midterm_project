package com.hdfc.midtermproject.grocery.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="customers_info")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 	private long customerId;
	
	@Column(name="name" ,nullable=false)
 	private String customerName;
	
	@Column(name="email" ,unique=true,nullable=false)
 	private String customerEmail;
	@Column(name="phone",nullable=false)
 	private String customerPhone;
	@Column(name="password",nullable=false)
 	private String customerPassword;
	@Column(name="Address",nullable=false)
 	private String customerAddress;
	
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CustomerOrder> orders = new ArrayList<>();
	
 	private boolean active;
 	
 	@Column(name="role")
 	private String role;
 	
 	@OneToOne(mappedBy="customer")
 	private Cart cart;
 	
}
