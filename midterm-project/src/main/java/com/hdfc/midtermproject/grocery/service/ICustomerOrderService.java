package com.hdfc.midtermproject.grocery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.grocery.dto.CustomerOrderDTO;
import com.hdfc.midtermproject.grocery.dto.OrderHistoryDTO;
import com.hdfc.midtermproject.grocery.exception.CartIsEmpty;
import com.hdfc.midtermproject.grocery.exception.ChoiceNotValid;
import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;
import com.hdfc.midtermproject.grocery.exception.NoOrdersAvailable;
import com.hdfc.midtermproject.grocery.exception.OrderNotAvailable;

@Service
public interface ICustomerOrderService {

	public CustomerOrderDTO placeOrder(String email)throws CustomerNotFound, CartIsEmpty;
	public List<OrderHistoryDTO> viewOrderHistory(String email) throws CustomerNotFound, NoOrdersAvailable;
	public String cancelOrder(long id,String email) throws CustomerNotFound, OrderNotAvailable;
	public CustomerOrderDTO viewOrder(long id,String email) throws CustomerNotFound, OrderNotAvailable ;
	public String setStatusShop(long id,int choice) throws ChoiceNotValid, OrderNotAvailable ;
	public String setStatusAgent(long id,int choice) throws ChoiceNotValid, OrderNotAvailable ;
	public String getStatus(String trackingId) throws OrderNotAvailable ;
	
		
}
