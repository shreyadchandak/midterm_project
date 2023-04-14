package com.hdfc.midtermproject.grocery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.grocery.dto.CustomerDTO;
import com.hdfc.midtermproject.grocery.entity.Customer;

import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;
import com.hdfc.midtermproject.grocery.repository.CustomerRepo;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	CustomerRepo repo;

	
	
	  
//	 
	 
	public CustomerDTO createCustomer(CustomerDTO c) {

		return toDTO(repo.save(toEntity(c)));
	}

	public CustomerDTO updateCustomer(CustomerDTO c) {
		return toDTO(repo.save(toEntity(c)));
	}

	public CustomerDTO getById(long id) throws CustomerNotFound {

		if (repo.existsById(id)) {
			return toDTO(repo.findById(id).orElse(null));
		} else {
			throw new CustomerNotFound();
		}
	}

	public String deleteById(long id) throws CustomerNotFound {

		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Deleted Successfully";
		} else {
			throw new CustomerNotFound();
		}
	}

	public List<CustomerDTO> findAll() throws CustomerNotFound {

		List<Customer> customers = repo.findAll();
		if (customers.isEmpty()) {
			throw new CustomerNotFound();
		}

		else
			return customers.stream().map(customer -> toDTO(customer)).collect(Collectors.toList());
	}
	
	

	public Customer toEntity(CustomerDTO c) {

		/*
		 * String encryptedPassword = passwordEncoder.encode(c.getCustomerPassword());
		 */
		Customer customer = new Customer();
		customer.setCustomerName(c.getCustomerName());
		customer.setCustomerEmail(c.getCustomerEmail());
		customer.setCustomerPassword(c.getCustomerPassword());
		customer.setCustomerPhone(c.getCustomerPhone());
		customer.setCustomerAddress(c.getCustomerAddress());
		customer.setActive(c.isActive());
		customer.setRole("USER");

		
		return customer;
	}

	public CustomerDTO toDTO(Customer customer) {

		CustomerDTO c = new CustomerDTO();
		c.setCustomerId(customer.getCustomerId());
		c.setCustomerName(customer.getCustomerName());
		c.setCustomerEmail(customer.getCustomerEmail());
		c.setCustomerPassword(customer.getCustomerPassword());
		c.setCustomerPhone(customer.getCustomerPhone());
		c.setCustomerAddress(customer.getCustomerAddress());
		c.setActive(customer.isActive());
		return c;
	}

	@Override
	public Customer findByCustomerEmail(String email) {
		// TODO Auto-generated method stub
		return (repo.findByCustomerEmail(email));
	}
}
