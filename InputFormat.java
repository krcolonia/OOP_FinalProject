package finalProject;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;

public class InputFormat {
	
	// Input Variables and Methods
	static Scanner strInput = new Scanner(System.in);
	static Scanner intInput = new Scanner(System.in);
	
	// Input Validation for Time Input
	static String inputTime(String input) {
		
		String inputTime = "";
		
		try {
			inputTime = input;
			if(inputTime.matches("^(1[0-2]|0?[1-9]):[0-5][0-9](A|P|a|p)(M|m)$") // 12:00am 12:00AM
					&& !isSpace(inputTime)) {
				return inputTime;
			}
			else {
				throw new InputMismatchException();
			}
		}
		catch(InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Please only input a valid time such as: 12:00am", "ERROR: Invalid Time Input", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
		
	}
	
	// Input Validation for Date Input
	static String inputDate(String input) {
		
		String inputDate = "";
		
		try {
			inputDate = input;
			if(inputDate.matches("(?i)^(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) (([0-9])|([0-2][0-9])|([3][0-1]))\\, \\d{4}$") // Jan 1, 2020, Nov 10, 2020
					&& !isSpace(inputDate)) {
				return inputDate;
			}
			else {
				throw new InputMismatchException();
			}
		}
		catch(InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Please only input a valid date such as: Jan 1, 2000", "ERROR: Invalid Date Input", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
		
	}
	
	// Input Validation for String Input
	static String inputString(String input) {
		
		String inputString = "";
		
		try {
			inputString = input.trim();
			if(inputString.matches("[A-Za-z\\.\s]+") && !isSpace(inputString)) {
				return inputString;
			}
			else {
				throw new InputMismatchException();
			}
		}
		catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Please only input a valid name", "ERROR: Invalid Name Input", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
	
	// Input Validation for Int Input
	static Integer inputInt(String input, String title) {
		
		int inputInt = 0;
		
		try {
			inputInt = Integer.parseInt(input);
			if(inputInt < 1)
				throw new InputMismatchException();
			return inputInt;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: Please only input Positive Integer values", "ERROR: Invalid " + title + " Input", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
	
	// Checks if string contains only spacs.
	static boolean isSpace(String inputString) {
		String check = inputString.trim();
		return check.isEmpty();
	}
	
	// Text Formatting Methods
	
	static String lJust(String s, int n) {
	     return String.format("%-" + n + "s", s);  
	}
	
	static String rJust(String s, int n) {
	     return String.format("%" + n + "s", s);  
	}
	
	static String center (String s, int n) {
	    return String.format("%-" + n  + "s", String.format("%" + (s.length() + (n - s.length()) / 2) + "s", s));
	}
	
	static String endReport() {
		String endReport = "";
		for(int i = 0; i < 40; i++)
			endReport += "-";
		endReport += "nothing follows";
		for(int i = 0; i < 40; i++)
			endReport += "-";
		return endReport;
	}
}
