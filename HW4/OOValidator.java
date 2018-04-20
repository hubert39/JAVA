import java.util.Scanner;

/**
 * Homework 4-1: Create an object-oriented validation class
 * @author Kuei-Lin Yang
 * Feb 11, 2018
 */

public class OOValidator {
	// declare instance variables
	protected Scanner sc = null;
	private Validator validator = null;
	
	// constructor
	public OOValidator(Scanner sc) {
		this.sc = sc;
		validator = new Validator();
	}
	
	protected int getInt(String prompt) {
		return validator.getInt(sc, prompt);
	}
	
	protected int getIntWithinRange(String prompt, int min, int max) {
		return validator.getIntWithinRange(sc, prompt, min, max);
	}
	
	protected double getDouble(String prompt) {
		return validator.getDouble(sc, prompt);
	}
	
	public double getDoubleWithinRange(String prompt, int min, int max) {
		return validator.getDoubleWithinRange(sc, prompt, min, max);
	}

}
