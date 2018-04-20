
/**
 * Homework 7-2: Maintain customer data
 * @author Kuei-Lin Yang
 * Mar 13, 2018
 */

public class Customer {
	// declare instance variables
	private String emailAddress;
	private String firstName;
	private String lastName;
		
	// constructor
	public Customer(String emailAddress, String firstName, String lastName) {
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	protected String getEmailAddress() {
		return emailAddress;
	}
	
	protected String getFirstName() {
		return firstName;
	}
	
	protected String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return emailAddress + "\t\t" + firstName + "\t\t" + lastName;
	}
}
