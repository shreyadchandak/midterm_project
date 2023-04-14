package com.hdfc.midtermproject.grocery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.grocery.dto.CustomerDTO;
import com.hdfc.midtermproject.grocery.entity.Customer;
import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;

@Service
public interface ICustomerService {

	public CustomerDTO createCustomer(CustomerDTO c);
	public CustomerDTO updateCustomer(CustomerDTO c);
	public CustomerDTO getById(long id) throws CustomerNotFound;
	public String deleteById(long id) throws CustomerNotFound;
	public List<CustomerDTO> findAll() throws CustomerNotFound;
	public Customer findByCustomerEmail(String email);
	public CustomerDTO toDTO(Customer customer);
	public Customer toEntity(CustomerDTO c);
}
