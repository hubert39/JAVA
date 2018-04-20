import java.math.BigDecimal;
import java.util.Scanner;

public class Validator
{
	public static int getInt(Scanner sc, String prompt)
	{
		int i = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			System.out.print(prompt);
			if (sc.hasNextInt())
			{
				i = sc.nextInt();
				isValid = true;
			}
			else
			{
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();  // discard any other data entered on the line
		}
		return i;
	}

	public static int getIntWithinRange(Scanner sc, String prompt,
	int min, int max)
	{
		int i = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println(
					"Error! Number must be greater than " + min);
			else if (i > max)
				System.out.println(
					"Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt)
	{
		double d = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			System.out.print(prompt);
			if (sc.hasNextDouble())
			{
				d = sc.nextDouble();
				isValid = true;
			}
			else
			{
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine();  // discard any other data entered on the line
		}
		return d;
	}

	public static double getDoubleWithinRange(Scanner sc, String prompt,
	double min, double max)
	{
		double d = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println(
					"Error! Number must be greater than " + min);
			else if (d > max)
				System.out.println(
					"Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return d;
	}
	
	public static BigDecimal getBigDecimal(Scanner sc, String prompt)
	{
		BigDecimal bigDecimal = new BigDecimal(Double.toString(0.00));
		boolean isValid = false;
		while (isValid == false)
		{
			System.out.print(prompt);
			if (sc.hasNextBigDecimal())
			{
				bigDecimal = sc.nextBigDecimal();
				isValid = true;
			}
			else
			{
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine();  // discard any other data entered on the line
		}
		return bigDecimal;
	}

	public static BigDecimal getBigDecimalWithinRange(Scanner sc, String prompt, BigDecimal min, BigDecimal max)
	{
		BigDecimal bigDecimal = new BigDecimal(Double.toString(0.00));
		boolean isValid = false;
		while (isValid == false)
		{
			bigDecimal = getBigDecimal(sc, prompt);
			if (bigDecimal.compareTo(min) < 0)
				System.out.println(
					"Error! Number must be greater than " + min);
			else if (bigDecimal.compareTo(max) > 0)
				System.out.println(
					"Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return bigDecimal;
	}
	
	// add a new method that forces the user to enter a string
	public static String getRequiredString(Scanner sc, String prompt) {
		String s = "";
		boolean isValid = false;
		while(isValid == false) {
			System.out.print(prompt);
			s = sc.nextLine();
			if(s.trim().isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			}else
				isValid = true;
		}
		return s;
	}
	
	// add another new method that forces the user to enter one of two strings
	public static String getChoiceString(Scanner sc, String prompt, String s1, String s2) {
		String s = "";
		boolean isValid = false;
		while(isValid == false) {
			s = getRequiredString(sc, prompt);
			if( !s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
				System.out.println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			}else
				isValid = true;
		}
		return s;
	}
}