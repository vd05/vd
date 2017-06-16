package com.nu.ValidationFunction;

public class EmailValidation {
	boolean result = false;

	public boolean emailValidation(String userInput) {
		if (userInput.matches("[a-zA-Z0-9\\.\\S^\\@]+[\\@][A-Za-z0-9]+[\\.][A-Za-z0-9\\.]+")) {
			result = true;
		}
		return result;
	}
}
