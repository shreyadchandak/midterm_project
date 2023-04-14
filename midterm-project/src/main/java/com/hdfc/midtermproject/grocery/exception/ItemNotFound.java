package com.hdfc.midtermproject.grocery.exception;

public class ItemNotFound extends Exception{
	@Override
	public String getMessage() {
		return "Item  not Found in Cart";
	}
}
