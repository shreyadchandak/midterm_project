package com.hdfc.midtermproject.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.grocery.dto.CustomerDTO;
import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;
import com.hdfc.midtermproject.grocery.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	
	@PostMapping("/public/insertcustomer")
	public CustomerDTO createCustomer(@RequestBody CustomerDTO c) {
		
		return service.createCustomer(c);
		
	}
	
	@PutMapping("/public/updatecustomer")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO c) {
		return service.updateCustomer(c);
	}
	
	@GetMapping("/admin/getbyid/{id}")
	public CustomerDTO getById(@PathVariable long id) throws CustomerNotFound {
		return service.getById(id);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public String deleteById(@PathVariable long id) throws CustomerNotFound {
		return service.deleteById(id);
	}
	
	@GetMapping("/admin/findall")
	public List<CustomerDTO> findAll() throws CustomerNotFound{
		
		return service.findAll();
	}

}
