package com.hdfc.midtermproject.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.grocery.dto.CartDTO;
import com.hdfc.midtermproject.grocery.entity.ItemRequest;
import com.hdfc.midtermproject.grocery.exception.CartIsEmpty;
import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;
import com.hdfc.midtermproject.grocery.exception.ItemNotFound;
import com.hdfc.midtermproject.grocery.exception.ProductNotFound;
import com.hdfc.midtermproject.grocery.service.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ICartService service;;
	
	@PostMapping("/user/add/{email}")
	public ResponseEntity<CartDTO> addtoCart(@RequestBody ItemRequest itemRequest,@PathVariable String email) throws CustomerNotFound, ProductNotFound{
		
		CartDTO addItem=this.service.addItem(itemRequest,email);
		return new ResponseEntity<CartDTO>(addItem,HttpStatus.OK);
	}
	
	@PostMapping("/user/remove/{productId}/{email}")
     public ResponseEntity<CartDTO> removeFromCart(@PathVariable long productId,@PathVariable String email) throws ProductNotFound, ItemNotFound{
		
		CartDTO addItem=this.service.removeItem(productId,email);
		return new ResponseEntity<CartDTO>(addItem,HttpStatus.OK);
	}
	@GetMapping("/user/view/{email}")
    public ResponseEntity<CartDTO> viewCart(@PathVariable String email) throws  CustomerNotFound, CartIsEmpty{
		
		CartDTO addItem=this.service.viewCart(email);
		return new ResponseEntity<CartDTO>(addItem,HttpStatus.OK);
	}
	
}
