package com.hdfc.midtermproject.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.midtermproject.grocery.entity.CustomerOrder;

public interface OrderRepo extends JpaRepository<CustomerOrder,Long>{
	
  public CustomerOrder findByTrackingId(String trackingId);
}
