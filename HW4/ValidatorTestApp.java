import java.util.Scanner;

/**
 * Homework 4-1: Create an object-oriented validation class
 * @author Kuei-Lin Yang
 * Feb 11, 2018
 */

public class ValidatorTestApp {
	// declare class variables
	private static Scanner sc = null;
	private static MyValidator myValidator = null;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Validation Tester application");
		System.out.println();
		
		sc = new Scanner(System.in);
		myValidator = new MyValidator(sc);
	
		System.out.println("Int Test");
		myValidator.getIntWithinRange("Enter an integer between -100 and 100: ", -100, 100);
		System.out.println();
		
		System.out.println("Double Test");
		myValidator.getDoubleWithinRange("Enter any number between -100 and 100: ", -100, 100);
		System.out.println();
		
		System.out.println("Required String Test");
		myValidator.getRequiredString("Enter your email address: ");
		System.out.println();
		
		System.out.println("String Choice Test");
		myValidator.getChoiceString("Select one (x/y): ", "x", "y");
		System.out.println();
	}

}
