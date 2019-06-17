package com.ocjp.practise.virtusa.code.test;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToWordsConverterTool {
	
	private static final String[] specialNames = {
	        "",
	        " thousand",
	        " million",
	        " billion",
	        " trillion",
	        " quadrillion",
	        " quintillion"
	    };
	
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
	
	private static String convertLessThanOneThousand(int number) {
        String current;
        
        if (number % 100 < 20){
            current = units[number % 100];
            number /= 100;
        }
        else {
            current = units[number % 10];
            number /= 10;
            
            current = tensPosition[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return units[number] + " hundred" + current;
    }
	
	 public static String convert(int number) {

	        if (number == 0) { return "zero"; }
	        
	        String prefix = "";
	        
	        if (number < 0) {
	            number = -number;
	            prefix = "negative";
	        }
	        
	        String current = "";
	        int place = 0;
	        
	        do {
	            int n = number % 1000;
	            if (n != 0){
	                String s = convertLessThanOneThousand(n);
	                current = s + specialNames[place] + current;
	            }
	            place++;
	            number /= 1000;
	        } while (number > 0);
	        
	        return (prefix + current).trim();
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
