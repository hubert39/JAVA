import java.util.Scanner;

/**
 * Homework 3-1: Calculation a circle's circumference and area
 * @author Kuei-Lin Yang
 * Feb 4, 2018
 */
public class CircleApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Circle Tester");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while( choice.equalsIgnoreCase("y") ) {
			double radius = Validator.getDouble(sc, "Enter radius:\t");
			Circle circle = new Circle(radius);
			System.out.println("Circumference:\t" + circle.getFormattedCircumference());
			System.out.println("Area:\t\t" + circle.getFormattedArea());
			System.out.println();
			
			choice = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
			System.out.println();
		}
		System.out.println("Goodbye. You created " + Circle.getObjectCount() + " Circle object(s).");
	}

}
