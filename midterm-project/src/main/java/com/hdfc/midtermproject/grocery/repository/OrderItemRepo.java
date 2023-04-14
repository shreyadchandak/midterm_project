package com.hdfc.midtermproject.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.midtermproject.grocery.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

}
