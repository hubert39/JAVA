import java.math.BigDecimal;

/**
 * Midterm Project: A Bank Transaction System For A Regional Bank
 * @author Kuei-Lin Yang
 * Feb 18, 2018
 */

// a interface for the CheckingAccount and SavingAccount
public interface Operation {
	void withdrawal(BigDecimal amount);
	void deposit(BigDecimal amount);
	String getFormattedBalances();
}
