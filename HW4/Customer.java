/**
 * Homework 4-2: Work with customer and employee data
 * @author Kuei-Lin Yang
 * Feb 12, 2018
 */

public class Customer extends Person{
	// declare a object variable
	private String customerNumber;
	
	// constructor
	public Customer() {
		customerNumber = "";
	}
	
	protected void setCustomerNumber(String cNumber) {
		customerNumber = cNumber;
	}
	
	protected String getCustomerNumber() {
		return customerNumber;
	}
	
	@Override
	protected String getDisplayText() {
		return super.toString() + "\nCustomer number: " + customerNumber;
				
	}
}
