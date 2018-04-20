import java.util.Scanner;

/**
 * @author Kuei-Lin Yang
 * Jan 22, 2018
 */

public class HW1 {	
	//1-1: Calculate a rectangle's area and perimeter
	public void calRect() {
		System.out.println("Welcome to the Area and Perimeter Calculator");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter length:\t");
			double length = sc.nextDouble();
			System.out.print("Enter width:\t");
			double width = sc.nextDouble();
			
			double area = length * width;
			double perimeter = 2 * (length + width);
			System.out.println("Area:\t\t" + area);
			System.out.println("Perimeter:\t" + perimeter);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		
	}
	
	//1-2: Convert number grades to letter grades
	public void convertNumToLetter() {
		System.out.println("Welcome to the Letter Grade Converter");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter numerical grade: ");
			int grade = sc.nextInt();
			String strGrade = "";
			if(grade >= 88 && grade <= 100)
				strGrade = "A";
			else if(grade >= 80 && grade <= 87)
				strGrade = "B";
			else if(grade >= 67 && grade <=79)
				strGrade = "C";
			else if(grade >= 60 && grade <=66)
				strGrade = "D";
			else if(grade < 60)
				strGrade = "F";
			else
				strGrade = "NONE";
			System.out.println("Letter grade: " + strGrade);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	
	//1-3: Convert temperature from Fahrenheit to Celsius
	public void convertTemperatureFtoC() {
		System.out.println("Welcome to the Temperature Converter");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter degrees in Fahrenheit: ");
			double f = sc.nextDouble();
			double c = (f-32) * 5/9;
			
			if(Math.ceil(c) == Math.floor(c))
				System.out.println("Degrees in Celsius: " + (int)c);
			else
				System.out.printf("Degrees in Celsius: %.2f\n", c);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	
	//1-4: Calculate travel time based on distance and speed
	public void calTravelTime() {
		System.out.println("Welcome to the Travel Time Calculator");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles:\t\t");
			double miles = sc.nextDouble();
			System.out.print("Enter miles per hour:\t");
			double speed = sc.nextDouble();
			
			int hours = (int) (miles / speed);
			int minutes = (int) ((miles % speed) * 60/speed);
			System.out.println();
			System.out.println("Estimated travel time");
			System.out.println("Hours:\t" + hours);
			System.out.println("Minutes:\t" + minutes);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	
	//1-5: Calculate coins for change
	public void calChange() {
		System.out.println("Welcome to the Change Calculator");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter number of cents (0-99): ");
			int cents = sc.nextInt();
			int quarters = cents / 25;
			int dimes = (cents - quarters * 25) / 10;
			int nickels = (cents - quarters * 25 - dimes * 10) / 5;
			int pennies = cents - quarters * 25 - dimes * 10 - nickels * 5;
			System.out.println("Quarters: " + quarters + "\n" +
							   "Dimes:    " + dimes + "\n" +
							   "Nickels:  " + nickels + "\n" +
							   "Pennies:  " + pennies + "\n");
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HW1 hw1 = new HW1();
		hw1.calRect();
		hw1.convertNumToLetter();
		hw1.convertTemperatureFtoC();
		hw1.calTravelTime();
		hw1.calChange();
	}

}
