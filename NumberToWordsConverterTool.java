package com.ocjp.practise.virtusa.code.test;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToWordsConverterTool {
	
	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	
	public static final String[] tensPosition = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};
	
	public static String convert(final int input) {
		if (input < 0) {
			return "Minus " + convert(-input);
		}

		if (input < 20) {
			return units[input];
		}

		if (input < 100) {
			return tensPosition[input / 10] + ((input % 10 != 0) ? " " : "") + units[input % 10];
		}

		if (input < 1000) {
			return units[input / 100] + " Hundred" + ((input % 100 != 0) ? " " : "") + convert(input % 100);
		}

		if (input < 100000) {
			return convert(input / 1000) + " Thousand" + ((input % 10000 != 0) ? " " : "") + convert(input % 1000);
		}

		if (input < 10000000) {
			return convert(input / 100000) + " Lakh" + ((input % 100000 != 0) ? " " : "") + convert(input % 100000);
		}

		return convert(input / 10000000) + " Crore" + ((input % 10000000 != 0) ? " " : "") + convert(input % 10000000);
	}
	
	public static void main(final String[] args) {

		int number;
		Scanner input=new Scanner(System.in);
	    System.out.println("Enter a number to convert into word format");
	    try {
	    	number =input.nextInt();	
			System.out.println(NumberFormat.getInstance().format(number) + "='" + convert(number) + "'");
		} catch (NumberFormatException ex) {
			// TODO: handle exception
		    System.out.println(" Error in Input. Please follow the below instruction."+ex.getLocalizedMessage());
		}catch (InputMismatchException e) {
			System.out.println(" Enter proper Input. Please Enter Numbers Only");
		}
	}
	
}
