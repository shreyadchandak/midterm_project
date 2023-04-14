package com.hdfc.midtermproject.grocery.exception;

public class ProductNotFound extends Exception{

	@Override
	public String getMessage() {
		return "Product(s) not Found";
	}
}
