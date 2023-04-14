package com.hdfc.midtermproject.grocery.dto;

import com.hdfc.midtermproject.grocery.entity.CustomerOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderItemDTO {

    
    private Long orderItemId;
    private CustomerOrder order;
    private ProductDTO product;
    private int quantity;
    private double totalPrice;
}
