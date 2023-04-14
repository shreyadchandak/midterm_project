package com.hdfc.midtermproject.grocery.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.grocery.dto.CustomerOrderDTO;
import com.hdfc.midtermproject.grocery.dto.OrderHistoryDTO;
import com.hdfc.midtermproject.grocery.dto.OrderItemDTOPretty;
import com.hdfc.midtermproject.grocery.entity.Cart;
import com.hdfc.midtermproject.grocery.entity.CartItem;
import com.hdfc.midtermproject.grocery.entity.Customer;
import com.hdfc.midtermproject.grocery.entity.CustomerOrder;
import com.hdfc.midtermproject.grocery.entity.OrderItem;
import com.hdfc.midtermproject.grocery.exception.CartIsEmpty;
import com.hdfc.midtermproject.grocery.exception.ChoiceNotValid;
import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;
import com.hdfc.midtermproject.grocery.exception.NoOrdersAvailable;
import com.hdfc.midtermproject.grocery.exception.OrderNotAvailable;
import com.hdfc.midtermproject.grocery.repository.CartItemRepo;
import com.hdfc.midtermproject.grocery.repository.CustomerRepo;
import com.hdfc.midtermproject.grocery.repository.OrderItemRepo;
import com.hdfc.midtermproject.grocery.repository.OrderRepo;

@Service
public class OrderServiceImp implements ICustomerOrderService {
	

@Autowired
CustomerRepo custRepo;	

@Autowired
OrderRepo ordRepo;

@Autowired 
OrderItemRepo itemRepo;

@Autowired
IProductService proService;

@Autowired
ICustomerService custService;

@Autowired
CartItemRepo cItemRepo;


	public CustomerOrderDTO placeOrder(String email) throws CustomerNotFound, CartIsEmpty {
	    Customer customer = custRepo.findByCustomerEmail(email);
	    if(customer == null) {
	        throw new CustomerNotFound();
	    }
	    Cart cart = customer.getCart();
	    if(cart == null || cart.getItems().isEmpty()) {
	        throw new CartIsEmpty();
	    }
	    Set<CartItem> cartItems=cart.getItems();
	    
	    CustomerOrder order=new CustomerOrder();
	    order.setCustomer(customer);
	    order.setDeliveryAddress(customer.getCustomerAddress());
	    order.setOrderDate( LocalDateTime.now());
	    order.setOrderStatus("PENDING");
	    Set<OrderItem> orderItems = new HashSet<>();
	    double totalAmount=0.0;
	    for(CartItem cartItem: cartItems) {
	        OrderItem orderItem = new OrderItem();
	        orderItem.setProduct(cartItem.getProduct());
	        orderItem.setQuantity(cartItem.getQuantity());
	        orderItem.setTotalPrice(cartItem.getTotalPrice());
	        orderItem.setOrder(order);
	        orderItems.add(orderItem);
	        totalAmount += cartItem.getTotalPrice();
	        cart.getItems().remove(cartItem);
	        cItemRepo.deleteById(cartItem.getCartItemId());
	    }
	    order.setExpectedDelivery(LocalDateTime.now().plusHours(2));
	    order.setOrderItems(orderItems);
	    order.setBillAmount(totalAmount);
	    ordRepo.save(order);
	    order.setTrackingId(order.getOrderId()+""+customer.getCustomerEmail());

	    cart.setItems(new HashSet<>());
	    cart.setBillAmount(0.0);
	    custRepo.save(customer);
	    ordRepo.save(order);
	    return toDTO(order);
	}
	public CustomerOrderDTO viewOrder(long id,String email) throws CustomerNotFound, OrderNotAvailable {
		
		Customer customer=custRepo.findByCustomerEmail(email);
		if(customer==null) {
			throw new CustomerNotFound();
		}

		List<CustomerOrder> orders=customer.getOrders();
		for(CustomerOrder order:orders) {
			if(order.getOrderId()==id) {
				return toDTO(order);
			}
		}
		throw new OrderNotAvailable();
		
		
	}
	
	public String cancelOrder(long id,String email) throws CustomerNotFound, OrderNotAvailable {
		
		Customer customer=custRepo.findByCustomerEmail(email);
		if(customer==null) {
			throw new CustomerNotFound();
		}
	
		List<CustomerOrder> orders=customer.getOrders();
		for(CustomerOrder order:orders) {
			if(order.getOrderId()==id) {
				if(order.getOrderStatus()=="PENDING" ||order.getOrderStatus() =="CONFIRMED" ||order.getOrderStatus()=="ON THE WAY" ||order.getOrderStatus()=="PACKING")
			    order.setOrderStatus("CANCELLED");
				ordRepo.save(order);
			    return "Order Cancelled Successfully";
			}else
			{
				return "Order Cannot be Cancelled at the stage" + order.getOrderStatus() +"minutes";
			}
				
		}
		throw new OrderNotAvailable();
	}
	
	public String setStatusShop(long id,int choice) throws ChoiceNotValid, OrderNotAvailable {
		CustomerOrder order=ordRepo.getById(id);
		if(order==null) {
			throw new OrderNotAvailable();
		}
		switch(choice) {
		case 1:if(order.getOrderStatus()=="PENDING")
		       {
			   order.setOrderStatus("CONFIRMED");
		       ordRepo.save(order);
		       }else return "DISABLED CHOICE";
		       break;
		case 2:if(order.getOrderStatus()=="CONFIRMED")
		       {
			    order.setOrderStatus("PACKING");
			       ordRepo.save(order);
		       }else return "DISABLED CHOICE";
		       break;
		       
		case 3:if(order.getOrderStatus()=="PACKING") 
		       {
			   order.setOrderStatus("ON THE WAY");
		       ordRepo.save(order);
		       }else return "DISABLED CHOICE";
		       break;
		default:throw new ChoiceNotValid();
		
		}
		return "Updated Order Status to "+order.getOrderStatus();
	}

	public String setStatusAgent(long id,int choice) throws ChoiceNotValid, OrderNotAvailable {
		CustomerOrder order=ordRepo.getById(id);
		if(order==null) {
			throw new OrderNotAvailable();
		}
		if(!(order.getOrderStatus()=="ON THE WAY")) {
			return "Cannot set the Status yet";
		}else
		{
		switch(choice) {
		case 1:order.setOrderStatus("DELIVERED");
		       ordRepo.save(order);
		       break;
		       
		case 2:if(!(order.getOrderStatus()=="DELIVERED")) {
			   order.setOrderStatus("RETURNED DUE TO ADDRESS NOT FOUND");
		       ordRepo.save(order);
		        }else return("DISABLED CHOICE");
		       break;
		case 3:if(!(order.getOrderStatus()=="DELIVERED")) {
			   order.setOrderStatus("RETURNED DUE TO NO ONE TO RECIEVE ORDER");
		       ordRepo.save(order);
		       }else return("DISABLED CHOICE");
		      break;
		case 4:if(!(order.getOrderStatus()=="DELIVERED")) {
			   order.setOrderStatus("RETURNED DUE TO CANNOT CONTACT THE CUSTOMER");
		       ordRepo.save(order);
		       }else return("DisABLED CHOICE");
		       break;
		
		default:throw new ChoiceNotValid();
		}
		}
		return "Updated Order Status to "+order.getOrderStatus();
	}
	
	
	
	public String getStatus(String trackingId) throws OrderNotAvailable {
		CustomerOrder order=ordRepo.findByTrackingId(trackingId);
		if(order==null) {
			throw new OrderNotAvailable();
		}
		if(order.getOrderStatus()!="DELIVERED" || order.getOrderStatus()!="CANCELLED" || order.getOrderStatus()!= "RETURNED DUE TO ADDRESS NOT FOUND"
			||order.getOrderStatus()!="RETURNED DUE TO NO ONE TO RECIEVE ORDER"||order.getOrderStatus()!="RETURNED DUE TO CANNOT CONTACT THE CUSTOMER")
			
			{
			long min=ChronoUnit.MINUTES.between(LocalDateTime.now(),order.getExpectedDelivery());
			if(min>0) {
			return order.getOrderStatus()+"-will be deliverd in "+ChronoUnit.MINUTES.between(LocalDateTime.now(),order.getExpectedDelivery());
			}
	}

		return order.getOrderStatus();

	}
	

    public List<OrderHistoryDTO> viewOrderHistory(String email) throws CustomerNotFound, NoOrdersAvailable{
    	Customer customer = custRepo.findByCustomerEmail(email);
	    if(customer == null) {
	        throw new CustomerNotFound();
	    }
	    
	    List<CustomerOrder> orders=customer.getOrders();
	    if(orders==null) {
	    	throw new NoOrdersAvailable();
	    }
    	List<OrderHistoryDTO> ordersHistoryDTO=new ArrayList<>();
    	for(CustomerOrder order:orders) {
    		ordersHistoryDTO.add(toHistoryDTO(order));
    	}
    	return ordersHistoryDTO;
    	
    }
	public OrderHistoryDTO toHistoryDTO(CustomerOrder order) {

	    OrderHistoryDTO orderDTO = new OrderHistoryDTO();
	    orderDTO.setOrderId(order.getOrderId());
	    orderDTO.setOrderDate(order.getOrderDate());
	    orderDTO.setBillAmount(order.getBillAmount());
	    orderDTO.setOrderStatus(order.getOrderStatus());
	    orderDTO.setDeliveryAddress(order.getDeliveryAddress());
	    
	    
	    Set<OrderItemDTOPretty> orderItemDTOs = new HashSet<>();
	    for (OrderItem orderItem : order.getOrderItems()) {
	        OrderItemDTOPretty orderItemDTO = new OrderItemDTOPretty();
	        orderItemDTO.setProductId(orderItem.getProduct().getProductId());
	        orderItemDTO.setProductName(orderItem.getProduct().getProductName());
	        orderItemDTO.setQuantity(orderItem.getQuantity());
	        orderItemDTO.setTotalPrice(orderItem.getTotalPrice());
	        orderItemDTOs.add(orderItemDTO);
	        
	    }
	    orderDTO.setItems(orderItemDTOs);
	       
	   return orderDTO;
		
	}
    public CustomerOrderDTO toDTO(CustomerOrder order) {
    CustomerOrderDTO orderDTO = new CustomerOrderDTO();
    orderDTO.setOrderId(order.getOrderId());
    orderDTO.setOrderDate(order.getOrderDate());
    orderDTO.setBillAmount(order.getBillAmount());
    orderDTO.setTrackingId(order.getTrackingId());
    orderDTO.setOrderStatus(order.getOrderStatus());
    orderDTO.setCustomer(custService.toDTO(order.getCustomer()));
    orderDTO.setExpectedDelivery(order.getExpectedDelivery());
    orderDTO.setDeliveryAddress(order.getDeliveryAddress());
    
    Set<OrderItemDTOPretty> orderItemDTOs = new HashSet<>();
    for (OrderItem orderItem : order.getOrderItems()) {
        OrderItemDTOPretty orderItemDTO = new OrderItemDTOPretty();
        orderItemDTO.setProductId(orderItem.getProduct().getProductId());
        orderItemDTO.setProductName(orderItem.getProduct().getProductName());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setTotalPrice(orderItem.getTotalPrice());
        orderItemDTOs.add(orderItemDTO);
        
    }
    orderDTO.setItems(orderItemDTOs);
       
   return orderDTO;

}
}
