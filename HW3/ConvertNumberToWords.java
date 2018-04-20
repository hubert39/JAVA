import java.util.Scanner;

/**
 * Homework 3-4: Convert numbers to words
 * @author Kuei-Lin Yang
 * Feb 5, 2018
 */

public class ConvertNumberToWords {
	// declare class variables and initialize
	private static final String[] UNITS_ARR = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static final String[] TEENS_ARR = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static final String[] TENS_ARR = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	private static String units, tens, hundreds, thousands;
	private static StringBuilder output;
	
	// parse a valid input string to thousands, hundreds, tens, and units
	public static void parseNumber(String number) {
		units = "";
		tens = "";
		hundreds = "";
		thousands = "";
		int length = number.trim().length();
		switch (length) {
		case 4:
			thousands = number.substring(length-4, length-3);
		case 3:
			hundreds = number.substring(length-3, length-2);
		case 2:
			tens = number.substring(length-2, length-1);
		case 1:
			units = number.substring(length-1, length);
			break;
		default:
			System.out.println("Invalid");
			break;
		}	
		//System.out.println("thousands:" + thousands + "\nhundreds:" + hundreds + "\ntens:" + tens + "\nunits:" + units);
	}

	// append a mapping string to output string
	public static void printUnits(String number) {
		output = new StringBuilder("");
		int length = number.trim().length();
		switch (length) {
		case 4:
			if(!thousands.equals("0"))
				output.append(UNITS_ARR[Integer.parseInt(thousands)] + " thousand ");
		case 3:
			if(!hundreds.equals("0"))
				output.append(UNITS_ARR[Integer.parseInt(hundreds)] + " hundred ");			
		case 2:
			if(!tens.equals("1") && !tens.equals("0")) 
				output.append(TENS_ARR[Integer.parseInt(tens)-2] + " ");
			else if(tens.equals("1")) {
				output.append(TEENS_ARR[Integer.parseInt(units)]);
				break;
			}
		case 1:
			if(length == 4 && thousands.equals("0") && hundreds.equals("0") && tens.equals("0") && units.equals("0"))
				output.append(UNITS_ARR[Integer.parseInt(units)]);
			else if(length == 3 && hundreds.equals("0") && tens.equals("0") && units.equals("0"))
				output.append(UNITS_ARR[Integer.parseInt(units)]);
			else if(length == 2 && tens.equals("0") && units.equals("0"))
				output.append(UNITS_ARR[Integer.parseInt(units)]);
			else if(length == 1 && units.equals("0"))
				output.append(UNITS_ARR[Integer.parseInt(units)]);			
			else if( !units.equals("0") )
				output.append(UNITS_ARR[Integer.parseInt(units)]);
			break;
		default:	
			System.out.println("Invalid");
			break;
		}
		//System.out.println(output);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Number to Word Converter.");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			String input = Validator.getRequiredStringWithRange(sc, "Enter the number you want to convert to words: ", 0, 9999);
			//System.out.println(input);
			
			// check if it belongs to decimal cases
			if(input.contains(".")) {
				String[] splitInput = input.split("\\.");
				String integer = "", decimal = "";
				if(splitInput.length > 1) {
					integer = splitInput[0];
					decimal = splitInput[1];
				}else
					integer = splitInput[0];
				//System.out.println("integer:" + integer + "\ndecimal:" + decimal);
				
				if(!integer.isEmpty()) {
					parseNumber(integer);
					printUnits(integer);
				}
				if(!decimal.isEmpty()) {
					if( Integer.parseInt(decimal) != 0)
						output.append(" and " + Integer.parseInt(decimal) + " cents");
				}
			}else {
				if(!input.isEmpty()) {
					parseNumber(input);
					printUnits(input);
				}
			}
			
			// display the result
			System.out.println(output);
			System.out.println();
			
			// ask for users to continue or not
			choice = Validator.getChoiceString(sc, "Convert another number? (y/n): ", "y", "n");
			System.out.println();
		}
	}

}
