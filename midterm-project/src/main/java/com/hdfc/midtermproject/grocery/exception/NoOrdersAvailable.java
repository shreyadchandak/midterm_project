package com.hdfc.midtermproject.grocery.exception;

public class NoOrdersAvailable extends Exception {
	@Override
	public String getMessage() {
		return "No Orders placed to Show";
	}
}
