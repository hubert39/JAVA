import java.util.Scanner;

/**
 * Homework 5-4: Implement a stack calculator
 * @author Kuei-Lin Yang
 * Feb 27, 2018
 */
public class StackCalculatorApp {
	private static StackCalculator stackCalculator = new StackCalculator();
	
	private static void printStack() {
		double[] stackValue = stackCalculator.getValues();
		if(stackValue.length == 0) {
			System.out.println("empty");
		}else {
			for(int i=0; i<stackValue.length; i++) {
				System.out.println(stackValue[i]);
			}	
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Stack Calculator.");
		System.out.println();
		System.out.println("Commands: push n, pop, add/+, sub/-, mult/*, div//, sqrt, pow, clear, or quit");
		System.out.println();


		Scanner sc = new Scanner(System.in);
		String command = "";
		do {
			command = Validator.getRequiredString(sc, "? ").trim();
			if(command.contains("push ")) {
				String[] commandSplit = command.split(" ");
				stackCalculator.push(Double.parseDouble(commandSplit[1].trim()));
				printStack();	
			}else if(command.equalsIgnoreCase("pop")) {
				stackCalculator.pop();
				printStack();
			}else if(command.equalsIgnoreCase("add") || command.equals("+")) {
				stackCalculator.add();
				printStack();
			}else if(command.equalsIgnoreCase("sub") || command.equals("-")) {
				stackCalculator.subtract();
				printStack();
			}else if(command.equalsIgnoreCase("mult") || command.equals("*")) {
				stackCalculator.multiply();
				printStack();
			}else if(command.equalsIgnoreCase("div") || command.equals("/")) {
				stackCalculator.divide();
				printStack();
			}else if(command.equalsIgnoreCase("sqrt")) {
				stackCalculator.sqrt();;
				printStack();
			}else if(command.equalsIgnoreCase("pow")) {
				stackCalculator.pow();
				printStack();
			}else if(command.equalsIgnoreCase("clear")) {
				stackCalculator.clear();
				printStack();
			}else if(command.equalsIgnoreCase("quit")) {
				break;
			}else {
				System.out.println("Do not support this command!!!");
				continue;
			}
			System.out.println();
		} while(!command.equalsIgnoreCase("quit"));
		
		System.out.println();
		System.out.println("Thanks for using the Stack Calculator.");
	}

}
