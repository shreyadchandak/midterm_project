package com.hdfc.midtermproject.grocery.exception;

public class OrderNotAvailable extends Exception {

	@Override
	public String getMessage() {
		return "Order with given id not available";
	}

}
