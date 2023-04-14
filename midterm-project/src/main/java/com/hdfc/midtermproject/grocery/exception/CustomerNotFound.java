package com.hdfc.midtermproject.grocery.exception;

public class CustomerNotFound extends Exception{
	
	
	@Override
	public String getMessage() {
		return "Customer(s) not Found";
	}
}
