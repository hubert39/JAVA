
/**
 * Homework 3-2: Roll the dice
 * @author Kuei-Lin Yang
 * Feb 4, 2018
 */
public class PairOfDice {
	// declare object variables
	private Die die1;
	private Die die2;
	private int value1;
	private int value2;
	private int sum;
	// declare and initialize a class variable
	private static int rollCount = 0;
	
	// constructor
	public PairOfDice() {
		die1 = new Die();
		die2 = new Die();
		value1 = 0;
		value2 = 0;
		sum = 0;
	}
	
	// constructor
	public PairOfDice(int sides) {
		die1 = new Die(sides);
		die2 = new Die(sides);
		value1 = 0;
		value2 = 0;
		sum = 0;
	}
	
	public void roll() {
		die1.roll();
		die2.roll();
		value1 = die1.getValue();
		value2 = die2.getValue();
		sum = value1 + value2;
		rollCount++;
	}
	
	public int getValue1() {
		return value1;
	}
	
	public int getValue2() {
		return value2;
	}
	
	public int getSum() {
		return sum;
	}
	
	public static int getRollCount() {
		return rollCount;
	}
}
