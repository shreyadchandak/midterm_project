package com.hdfc.midtermproject.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midtermproject.grocery.entity.CartItem;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {

}
