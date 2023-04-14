package com.hdfc.midtermproject.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midtermproject.grocery.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	public Customer findByCustomerEmail(String email);
}
