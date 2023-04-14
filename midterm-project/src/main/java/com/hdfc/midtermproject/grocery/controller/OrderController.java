package com.hdfc.midtermproject.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.grocery.dto.CustomerOrderDTO;
import com.hdfc.midtermproject.grocery.dto.OrderHistoryDTO;
import com.hdfc.midtermproject.grocery.exception.CartIsEmpty;
import com.hdfc.midtermproject.grocery.exception.ChoiceNotValid;
import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;
import com.hdfc.midtermproject.grocery.exception.NoOrdersAvailable;
import com.hdfc.midtermproject.grocery.exception.OrderNotAvailable;
import com.hdfc.midtermproject.grocery.service.ICustomerOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	
	@Autowired
	private ICustomerOrderService service;
	
	@PostMapping("/user/placeorder/{email}")
	public CustomerOrderDTO placeOrder(@PathVariable String email) throws CustomerNotFound,CartIsEmpty{
		
		 return this.service.placeOrder(email);
		
	}
	
	@GetMapping("/user/vieworders/{email}")
	public List<OrderHistoryDTO> viewOrderHistory(@PathVariable String email) throws CustomerNotFound, NoOrdersAvailable{
		return this.service.viewOrderHistory(email);
	}
	@GetMapping("/user/vieworder/{id}/{email}")
	public CustomerOrderDTO viewOrder(@PathVariable long id,@PathVariable String email ) throws CustomerNotFound, OrderNotAvailable {
		return this.service.viewOrder(id, email);
	}
	
	@PutMapping("/shop/setorderstatus/{id}/{choice}")
	public String setOrderStatusShop(@PathVariable long id,@PathVariable int choice) throws ChoiceNotValid, OrderNotAvailable {
		
		return this.service.setStatusShop(id,choice);
	}
	@PutMapping("/agent/setorderstatus/{id}/{choice}")
	public String setOrderStatusAgent(@PathVariable long id,@PathVariable int choice) throws ChoiceNotValid, OrderNotAvailable {
		
		return this.service.setStatusAgent(id,choice);
	}
	
	@GetMapping("/user/getStatus/{trackingId}")
	public String getOrderStatus(@PathVariable String trackingId) throws OrderNotAvailable {
		return this.service.getStatus(trackingId);
	}

	@PutMapping("/user/cancelOrder/{id}/{email}")
	public String cancelOrder(@PathVariable long id, @PathVariable String email) throws CustomerNotFound, OrderNotAvailable {
		return service.cancelOrder(id, email);
		
	}
	
}
