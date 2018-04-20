/**
 * Homework 4-2: Work with customer and employee data
 * @author Kuei-Lin Yang
 * Feb 12, 2018
 */

public class Employee extends Person{
	// declare a object variable
	private String socialSecurityNumber;
	
	// constructor
	public Employee() {
		socialSecurityNumber = "";
	}

	protected void setSSN(String ssn) {
		socialSecurityNumber = ssn;
	}
	
	protected String getSSN() {
		return socialSecurityNumber;
	}
	
	@Override
	protected String getDisplayText() {
		return super.toString() + "\nSocial security number: " + socialSecurityNumber;
	}
}
