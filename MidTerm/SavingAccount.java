import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Midterm Project: A Bank Transaction System For A Regional Bank
 * @author Kuei-Lin Yang
 * Feb 18, 2018
 */

public class SavingAccount extends Account implements Operation{
	// declare instance variables
	private final double INTEREST_RATE = 0.01;
	private BigDecimal interest;
	
	// constructor
	public SavingAccount() {
		super();
		interest = new BigDecimal(Double.toString(0.00));
	}
	
	// a method to withdraw the amount from the saving balance
	@Override
	public void withdrawal(BigDecimal amount) {
		super.setBalance(super.getBalance().subtract(amount));
	}
	
	// a method to deposit the amount to the saving balance
	@Override
	public void deposit(BigDecimal amount) {
		super.setBalance(super.getBalance().add(amount));
	}
	
	// a method to return the formatted saving balance
	@Override
	public String getFormattedBalances() {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
		currency.setMaximumFractionDigits(2);
		String formattedBalances = "Savings:  " + currency.format(super.getFormattedBigDecimalBalances());
		return formattedBalances;
	}
	
	// a method to return the formatted saving interest payment
	protected String getFormattedInterestEarned() {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
		currency.setMaximumFractionDigits(2);
		String formattedInterestEarned = "Savings interest payment: " + currency.format(interest);
		return formattedInterestEarned;
	}
	
	// a method to check if the is any interest
	private boolean isInterestEarned() {
		if(!super.getBalance().equals(0)) {
			interest = super.getBalance().multiply(new BigDecimal(Double.toString(INTEREST_RATE)));
			return true;
		}
		else
			return false;
	}
	
	// a method to add interests to the saving balance
	protected void addInterest() {
		if(isInterestEarned())
			super.setBalance(super.getBalance().add(interest));
	}
	
}
