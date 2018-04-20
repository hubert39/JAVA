import java.util.Scanner;

/**
 * Homework 3-2: Roll the dice
 * @author Kuei-Lin Yang
 * Feb 4, 2018
 */
public class DiceRollerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Paradise Roller application");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			choice = Validator.getChoiceString(sc, "Roll the dice? (y/n): ", "y", "n");
			System.out.println();
			
			if(choice.equalsIgnoreCase("y")) {
				PairOfDice pairOfDice = new PairOfDice();
				pairOfDice.roll();
				System.out.println("Roll " + PairOfDice.getRollCount() + ":");
				System.out.println(pairOfDice.getValue1());
				System.out.println(pairOfDice.getValue2());
				
				// mapping the rule and output
				if(pairOfDice.getSum() == 7)
					System.out.println("Craps!");
				else if(pairOfDice.getValue1() == 1 && pairOfDice.getValue2() == 1)
					System.out.println("Snake eyes!");
				else if(pairOfDice.getValue1() == 6 && pairOfDice.getValue2() == 6)
					System.out.println("Box cars!");
				
				System.out.println();
			}
		
		}
		
	}

}
