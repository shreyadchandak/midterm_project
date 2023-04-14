package com.hdfc.midtermproject.grocery.exception;

public class ChoiceNotValid extends Exception {
	@Override
	public String getMessage() {
		return "Wrong choice of Number,Try Again to set Valid Order Status";
	}
}
