import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Kuei-Lin Yang
 * Jan 28, 2018
 */

public class HW2 {
	// Homework 2-1: Calculate interest
	public void calInterest() {
		System.out.println("Welcome to the Interest Calculator");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			// get the input from the user
			System.out.print("Enter loan amount:   ");
			double amount = sc.nextDouble();
			System.out.print("Enter interest rate: ");
			double interestRate = sc.nextDouble();
			System.out.println();
			
			// convert amount and interest rate to BigDecimal
			BigDecimal decimalAmount = new BigDecimal(Double.toString(amount));
			BigDecimal decimalInterestRate = new BigDecimal(Double.toString(interestRate));
			
			// calculate interest
			BigDecimal decimalInterest = decimalAmount.multiply(decimalInterestRate);
			decimalInterest = decimalInterest.setScale(2, RoundingMode.HALF_UP);
			
			// get the currency and percent formatter objects
			NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(3);
			
			// display the loan amount, interest rate, and interest
			String message = "Loan amount:         " + currency.format(decimalAmount) + "\n"
							+ "Interest rate:       " + percent.format(decimalInterestRate) + "\n"
							+ "Interest:            " + currency.format(decimalInterest) + "\n";
			System.out.println(message);
			
			// see if user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	
	// Homework 2-2: Display a table of powers
	public void displayPowers() {
		System.out.println("Welcome to the Squares and Cubes table");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			// get input from the user
			System.out.print("Enter an integer: ");
			int number = sc.nextInt();
			System.out.println();
			
			String head = "Number  Squared Cubed\n"
						+ "======  ======= =====";
			System.out.println(head);
			
			// calculate squares and cubes
			String table = "";
			for(int i=1; i<=number; i++) {
				table += i + "\t" + i*i + "\t" + i*i*i + "\n";
			}
			System.out.println(table);
			
			// see if user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	
	
	// Homework 2-3: Add validation to an old project
	public static double getDouble(Scanner sc, String prompt) {
		double d = 0.0;
		boolean isValid = false;
		while(isValid == false) {
			System.out.print(prompt);
			if(sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			}else
				System.out.println("Error! Invalid decimal value. Try again.");
			sc.nextLine();		//discard any other data
		}
		return d;
	}
	
	public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {
		double d = 0.0;
		boolean isValid = false;
		while(isValid == false) {
			d = getDouble(sc, prompt);
			if(d <= min)
				System.out.println("Error! Number must be greater than " + min);
			else if(d >= max)
				System.out.println("Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return d;
	}
	
	public void calRect() {
		System.out.println("Welcome to the Area and Perimeter Calculator");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equals("y")) {
			// get input from the user
			double length = getDoubleWithinRange(sc, "Enter length: ", 0.0, 1000000.0);
			double width = getDoubleWithinRange(sc, "Enter width:  ", 0.0, 1000000.0);
			
			// display the calculated area and perimeter message
			String message = "Area:         " + length * width + "\n"
						   + "Perimeter     " + 2 * (length + width) + "\n";
			System.out.println(message);
			
			//see if user wants to continue, the input of y/n is acceptable
			boolean isValid = false;
			while(isValid == false) {	
				System.out.print("Continue? (y/n): ");				
				choice = sc.nextLine().trim();
				if(choice.isEmpty())
					System.out.println("Error! This entry is required. Try again.");
				else if(choice.equals("y") || choice.equals("n"))
					isValid = true;
				else
					System.out.println("Error! Entry must be \'y\' or \'n\'. Try again.");
			}
			System.out.println();
		}
	}
	
	// Homework 2-4: Calculate the monthly payment on a loan
	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while(isValid == false) {
			System.out.print(prompt);
			if(sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			}else
				System.out.println("Error! Invalid integer value. Try again.");
			sc.nextLine();		//discard any other data entered on the line
		}
		return i;
	}
	
	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while(isValid == false) {
			i = getInt(sc, prompt);
			if(i <= min)
				System.out.println("Error! Number must be greater than " + min);
			else if(i >= max)
				System.out.println("Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return i;
	}
	
	public void calLoan() {
		System.out.println("Welcome to the Loan Calculator");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equals("y")) {
			// get input from the user
			System.out.println("DATA ENTRY");
			double loanAmount = getDoubleWithinRange(sc, "Enter loan amount:          ", 0.0, 1000000.0);
			double monthlyInterestRate = getDoubleWithinRange(sc, "Enter yearly interest rate: ", 0.0, 20.0);
			int years = getIntWithinRange(sc, "Enter number of years:      ", 0, 100);
			System.out.println();
			
			// calculate monthly payment
			double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1/Math.pow(1 + monthlyInterestRate, years * 12));
			
			// get the currency and percent formatter objects
			NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(1);
			
			// display the loan amount, interest rate, years, and monthly payment
			String message = "FORMATTED RESULTS\n"
						   + "Loan amount:          " + currency.format(loanAmount) + "\n"
						   + "Yearly interest rate: " + percent.format(monthlyInterestRate) + "\n"
						   + "Number of years:      " + years + "\n"
						   + "Monthly payment:      " + currency.format(monthlyPayment) + "\n";
			System.out.println(message);
			
			//see if user wants to continue, the input of y/n is acceptable
			boolean isValid = false;
			while(isValid == false) {	
				System.out.print("Continue? (y/n): ");				
				choice = sc.nextLine().trim();
				if(choice.isEmpty())
					System.out.println("Error! This entry is required. Try again.");
				else if(choice.equals("y") || choice.equals("n"))
					isValid = true;
				else
					System.out.println("Error! Entry must be \'y\' or \'n\'. Try again.");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HW2 hw2 = new HW2();
		hw2.calInterest();
		hw2.displayPowers();
		hw2.calRect();
		hw2.calLoan();
	}

}
