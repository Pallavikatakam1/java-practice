package com.questk2.main;

/*Custom exception class for handling invalid data scenarios.*/

public class InvalidDataException extends Exception {

	/*
	 * Constructs a new InvalidDataException with the specified detail message that
	 * describes the case of exception
	 */

	public InvalidDataException(String message) {
		super(message);
	}
}
