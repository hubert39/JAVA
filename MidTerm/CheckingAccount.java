import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Midterm Project: A Bank Transaction System For A Regional Bank
 * @author Kuei-Lin Yang
 * Feb 18, 2018
 */

public class CheckingAccount extends Account implements Operation{
	// declare instance variables
	private final double FEES = 1.0;
	private static int transCount = 0;
	
	// constructor
	public CheckingAccount() {
		super();
	}
	
	// a method to withdraw the amount from the checking balance
	@Override
	public void withdrawal(BigDecimal amount) {
		super.setBalance(super.getBalance().subtract(amount));
		transCount++;
	}
	
	// a method to deposit the amount to the checking balance
	@Override
	public void deposit(BigDecimal amount) {
		super.setBalance(super.getBalance().add(amount));
		transCount++;
	}
	
	// a method to return the formatted checking balance
	@Override
	public String getFormattedBalances() {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
		currency.setMaximumFractionDigits(2);
		String formattedBalances = "Checking: " + currency.format(super.getFormattedBigDecimalBalances());
		return formattedBalances;
	}

	// a method to return the formatted checking fees
	protected String getFormattedFees() {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
		currency.setMaximumFractionDigits(2);
		String formattedFees = "Checking fee:             " + currency.format(FEES);
		return formattedFees;
	}
	
	// a method to deduct fees at the end of transactions
	protected void deductFees() {
		if(transCount != 0)
			withdrawal(new BigDecimal(Double.toString(FEES)));
	}
}
