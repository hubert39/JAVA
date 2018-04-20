import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Midterm Project: A Bank Transaction System For A Regional Bank
 * @author Kuei-Lin Yang
 * Feb 18, 2018
 */

public abstract class Account{
	// declare a instance variable
	private BigDecimal balance;
	
	// constructor
	public Account() {
		balance = new BigDecimal(Double.toString(1000.00));
	}
	
	// a method to set the balance
	protected void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	// a method to get the balance
	protected BigDecimal getBalance() {
		return balance;
	}
	
	protected BigDecimal getFormattedBigDecimalBalances() {
		return balance.setScale(2, RoundingMode.HALF_UP);
	}
}
