
/**
 * Homework 3-2: Roll the dice
 * @author Kuei-Lin Yang
 * Feb 4, 2018
 */
public class Die {
	// declare object variables
	private int value;
	private int sides;
	
	// constructor
	public Die() {
		value = 0;
		sides = 6;
	}

	// constructor
	public Die(int sides) {
		value = 0;
		this.sides = sides;
	}
	
	public void roll() {
		value = (int) (Math.random() * sides + 1);
		//System.out.println("value:" + value);
	}
	
	public int getValue() {
		return value;
	}
}
