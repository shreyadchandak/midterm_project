package com.hdfc.midtermproject.grocery.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryDTO {

    private Long orderId;
    private Set<OrderItemDTOPretty> items = new HashSet<>();
    private double billAmount;  
    private LocalDateTime orderDate;
    private String OrderStatus;
    private String deliveryAddress;

}
