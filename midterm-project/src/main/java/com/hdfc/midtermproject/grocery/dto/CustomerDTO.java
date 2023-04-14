package com.hdfc.midtermproject.grocery.dto;

import java.util.ArrayList;
import java.util.List;

import com.hdfc.midtermproject.grocery.service.CustomerOrderDTOPretty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustomerDTO {

	private long customerId;
 	private String customerName;
 	private String customerEmail;
 	private String customerPhone;
 	private String customerPassword;
 	private String customerAddress;
    private List<CustomerOrderDTOPretty> orders = new ArrayList<>();
 	private boolean active;
}
