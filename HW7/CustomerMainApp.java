import java.util.ArrayList;
import java.util.Scanner;

/**
 * Homework 7-2: Maintain customer data
 * @author Kuei-Lin Yang
 * Mar 13, 2018
 */
public class CustomerMainApp {
	// declare class variables
	private static CustomerDB customerDB = null;
	private static Scanner sc = null;
	
	// display the menu
	private static void displayMenu() {
		String menu = "COMMAND MENU\n" +
					  "list\t- List all customers\n" +
					  "add\t- Add a customer\n" +
					  "del\t- Delete a customer\n" +
					  "help\t- Show this menu\n" +
					  "exit\t- Exit this application";
		System.out.println(menu);
	}
	
	// display all customers
	private static void displayAllCustomers() {
		ArrayList<Customer> customers = customerDB.getCustomers();
		System.out.println("CUSTOMER LIST");
		for(Customer customer : customers) {
			System.out.println(customer.toString());
		}
	}
	
	// add a customer
	private static void addCustomer() {
		String emailAddress = Validator.getRequiredString(sc, "Enter customer email address: ");
		String firstName = Validator.getRequiredString(sc, "Enter first name: ");
		String lastName = Validator.getRequiredString(sc, "Enter last name: ");
		System.out.println();
		Customer c = new Customer(emailAddress, firstName, lastName);
		if(customerDB.addCustomer(c))
			System.out.println(firstName + " " + lastName + " was added to the database.");
		else
			System.out.println(firstName + " " + lastName + " was added unsuccessfully. Please try again.");
	}
	
	// delete a customer
	private static void deleteCustomer() {
		String emailAddress = Validator.getRequiredString(sc, "Enter customer email to delete: ");
		System.out.println();
		Customer c = customerDB.getProduct(emailAddress);
		if( c != null) {
			if(customerDB.deleteCustomer(c))
				System.out.println(c.getFirstName() + " " + c.getLastName() + " was deleted from the database.");
			else
				System.out.println(c.getFirstName() + " " + c.getLastName() + " was deleted unsuccessfully. Please try again.");
		}else
			System.out.println("No customer matches the email address: " + emailAddress);
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Customer Maintenance application");
		System.out.println();
		displayMenu();
		System.out.println();
		
		// set class variables
		customerDB = new CustomerDB();
		sc = new Scanner(System.in);
		
		String command = null;
		do {
			command = Validator.getRequiredString(sc, "Enter a command: ");
			System.out.println();
			
			if(command.equalsIgnoreCase("list")) {
				displayAllCustomers();
			}else if(command.equalsIgnoreCase("add")) {
				addCustomer();
			}else if(command.equalsIgnoreCase("del")) {
				deleteCustomer();
			}else if(command.equalsIgnoreCase("help")) {
				displayMenu();
			}else if(command.equalsIgnoreCase("exit")) {
				System.out.println("Bye.");
			}else
				System.out.println("Error! Not a valid command.");
			System.out.println();
		}while(!command.equalsIgnoreCase("exit"));
		
	}

}
