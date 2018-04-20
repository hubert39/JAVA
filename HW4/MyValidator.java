import java.util.Scanner;

/**
 * Homework 4-1: Create an object-oriented validation class
 * @author Kuei-Lin Yang
 * Feb 11, 2018
 */

public class MyValidator extends OOValidator{
	// constructor
	public MyValidator(Scanner sc) {
		super(sc);
	}

	protected String getRequiredString(String prompt) {
		String s = "";
		boolean isValid = false;
		while(isValid == false) {
			System.out.print(prompt);
			s = sc.nextLine();
			if(s.trim().isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			}else
				isValid = true;
		}
		return s;
	}
	
	protected String getChoiceString(String prompt, String s1, String s2) {
		String s = "";
		boolean isValid = false;
		while(isValid == false) {
			s = getRequiredString(prompt);
			if( !s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
				System.out.println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			}else
				isValid = true;
		}
		return s;
	}
}
