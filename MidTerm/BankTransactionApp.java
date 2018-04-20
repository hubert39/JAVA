import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Midterm Project: A Bank Transaction System For A Regional Bank
 * @author Kuei-Lin Yang
 * Feb 18, 2018
 */

public class BankTransactionApp {
	// declare class variables
	private static Scanner sc = null;
	//private static Account account = null;
	private static CheckingAccount checkingAccount = new CheckingAccount();
	private static SavingAccount savingAccount = new SavingAccount();
	
	// a method to make a transaction by the type of an operation and an account
	private static void transcate(String operation, String account, BigDecimal amount) {	
		switch(operation.trim().toLowerCase()) {
			case "w": // a withdrawal case
				if(account.equalsIgnoreCase("c"))
					checkingAccount.withdrawal(amount);
				else
					savingAccount.withdrawal(amount);
				break;
			case "d": // a deposit case
				if(account.equalsIgnoreCase("c"))
					checkingAccount.deposit(amount);
				else
					savingAccount.deposit(amount);
				break;
			default:
				break;		
		}		
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Account application");
		System.out.println();
		
		// display the starting checking and saving balance
		System.out.println("Starting Balances");
		System.out.println(checkingAccount.getFormattedBalances());
		System.out.println(savingAccount.getFormattedBalances());
		System.out.println();
		
		System.out.println("Enter the transactions for the month");
		System.out.println();
		
		sc = new Scanner(System.in);
		String choiceOfContinue = "y";
		do {
			// ask a user to input w or d
			String choiceOfWithdrawalDeposit = Validator.getChoiceString(sc, "Withdrawal or deposit? (w/d): ", "w", "d");
			// ask a user to input c or s
			String choiceOfCheckingSavings = Validator.getChoiceString(sc, "Checking or savings? (c/s): ", "c", "s");
			
			BigDecimal amount = new BigDecimal(Double.toString(0.00));
			if(choiceOfWithdrawalDeposit.equalsIgnoreCase("w")) {	 // a withdrawal case		
				if(choiceOfCheckingSavings.equalsIgnoreCase("c"))
					amount = Validator.getBigDecimalWithinRange(sc, "Amount?: ", new BigDecimal(Double.toString(0.00)), checkingAccount.getBalance().subtract(new BigDecimal(Double.toString(1))));
				else
					amount = Validator.getBigDecimalWithinRange(sc, "Amount?: ", new BigDecimal(Double.toString(0.00)), savingAccount.getBalance());					
			} else { // a deposit case
				amount = Validator.getBigDecimal(sc, "Amount?: ");
			}
			
			// proceed the transaction
			transcate(choiceOfWithdrawalDeposit, choiceOfCheckingSavings, amount);
			System.out.println();
			
			// ask a user to input y or n
			choiceOfContinue = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
			System.out.println();
		}
		while(choiceOfContinue.equalsIgnoreCase("y"));
		
		// deduct fees for a checking account and add interests for a saving account at the end of transactions
		checkingAccount.deductFees();
		savingAccount.addInterest();
		
		// display the monthly deduct checking fees and savings interest payment
		System.out.println("Monthly Payments and Fees");
		System.out.println(checkingAccount.getFormattedFees());
		System.out.println(savingAccount.getFormattedInterestEarned());
		System.out.println();
		
		// display the final checking and saving balance
		System.out.println("Final Balances");
		System.out.println(checkingAccount.getFormattedBalances());
		System.out.println(savingAccount.getFormattedBalances());
	}

}
