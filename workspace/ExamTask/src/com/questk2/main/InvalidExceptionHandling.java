package com.questk2.main;

/* creating an exception class for  price 
 * if price is less than 100 and invalidExceptionn is shown
 * 
 */

class InvalidPriceException extends Exception {
	public InvalidPriceException(String message) {
		super(message);
	}
}

/*
 * creating an exception class for category if the entered category is not valid
 * then invalidException is shown
 */

class InvalidCategoryException extends Exception {
	public InvalidCategoryException(String message) {
		super(message);
	}
}
