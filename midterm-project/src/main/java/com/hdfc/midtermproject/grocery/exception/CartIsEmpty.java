package com.hdfc.midtermproject.grocery.exception;

public class CartIsEmpty extends Exception{
	@Override
	public String getMessage() {
		return "Cart is Empty";
	}
}
