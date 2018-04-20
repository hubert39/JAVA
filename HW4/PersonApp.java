import java.util.Scanner;
/**
 * Homework 4-2: Work with customer and employee data
 * @author Kuei-Lin Yang
 * Feb 12, 2018
 */

public class PersonApp {
	// declare class variables
	private static Scanner sc = null;
	private static Customer customer = null;
	private static Employee employee = null;

	private static void print(Person person) {
		System.out.println("You entered:\n" + person.getDisplayText());
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Person Tester application");
		System.out.println();
		
		sc = new Scanner(System.in);
		String choice = "y";
		do {
			// ask a user to input a required string
			String created = Validator.getChoiceString(sc, "Create customer or employee? (c/e): ", "c", "e");
			System.out.println();
			
			// check the user's input and create a related object
			if(created.equalsIgnoreCase("c")) {
				String firstname = Validator.getRequiredString(sc, "Enter first name: ");
				String lastname = Validator.getRequiredString(sc, "Enter last name: ");
				String email = Validator.getRequiredString(sc, "Enter email address: ");
				String customerNumber = Validator.getRequiredString(sc, "Customer number: ");
				customer = new Customer();
				customer.setFirstName(firstname);
				customer.setLastName(lastname);
				customer.setEmail(email);
				customer.setCustomerNumber(customerNumber);
				System.out.println();
				print(customer);
			}else if(created.equalsIgnoreCase("e")) {
				String firstname = Validator.getRequiredString(sc, "Enter first name: ");
				String lastname = Validator.getRequiredString(sc, "Enter last name: ");
				String email = Validator.getRequiredString(sc, "Enter email address: ");
				String socialSecurityNumber = Validator.getRequiredString(sc, "Social security number: ");
				employee = new Employee();
				employee.setFirstName(firstname);
				employee.setLastName(lastname);
				employee.setEmail(email);
				employee.setSSN(socialSecurityNumber);
				System.out.println();
				print(employee);
			}else
				System.out.println("Not Valid!");
			
			System.out.println();
			// ask a user to input a required string
			choice = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
			System.out.println();
		}while(choice.equalsIgnoreCase("y"));
	}

}
