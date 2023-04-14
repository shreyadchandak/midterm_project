package com.hdfc.midtermproject.grocery.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;



import com.hdfc.midtermproject.grocery.entity.Customer;
import com.hdfc.midtermproject.grocery.entity.OrderItem;
import com.hdfc.midtermproject.grocery.entity.OrderStatus;
import com.hdfc.midtermproject.grocery.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDTO {

   
    private Long orderId;
    private CustomerDTO customer;
    private Set<OrderItemDTOPretty> items = new HashSet<>();
    private double billAmount;  
    private LocalDateTime orderDate;
    private String OrderStatus;
    private String trackingId;
    private LocalDateTime expectedDelivery;
    private String deliveryAddress;

    
}
