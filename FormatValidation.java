package com.nu.ValidationFunction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FormatValidation {
	boolean result;

	public boolean formatValidation(String userInput,String validDateFormat) {
		/*System.out.println("Enter valid date format");
		Scanner sc = new Scanner(System.in);*/
		String date = validDateFormat;
		SimpleDateFormat dateFormat = new SimpleDateFormat(date);
		Date date2 = null;

		try {
			date2 = dateFormat.parse(userInput);
			result = true;
		} catch (Exception ex) {
			result = false;
		}
		return result;
	}
}
