/**
 * Homework 4-2: Work with customer and employee data
 * @author Kuei-Lin Yang
 * Feb 12, 2018
 */

public abstract class Person {
	// declare object variables
	private String firstName;
	private String lastName;
	private String emailAddr;
	
	// constructor
	public Person(){
		firstName = "";
		lastName = "";
		emailAddr = "";
	}
	
	protected void setFirstName(String fName) {
		firstName = fName;
	}
	
	protected String getFirstName() {
		return firstName;
	}
	
	protected void setLastName(String lName) {
		lastName = lName;
	}
	
	protected String getLastName() {
		return lastName;
	}
	
	protected void setEmail(String email) {
		emailAddr = email;
	}
	
	protected String getEmail() {
		return emailAddr;
	}
	
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\n" 
			 + "Email: " + emailAddr;
	}
	
	protected abstract String getDisplayText();
}
