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
			if (i <= min)
				System.out.println(
					"Error! Number must be greater than " + min);
			else if (i >= max)
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
			if (d <= min)
				System.out.println(
					"Error! Number must be greater than " + min);
			else if (d >= max)
				System.out.println(
					"Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return d;
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

	// check if the string is numeric
	public static boolean isNumeric(String str) {
		// deal with negative - problem, especially for -0 case
		if(String.valueOf(str.trim().charAt(0)).equals("-")) {
			//System.out.println(str);
			return false;
		}
		
		try {
			double d = Double.parseDouble(str);
			//System.out.println(d);
		}catch(NumberFormatException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// check the range between min and max
	public static String getRequiredStringWithRange(Scanner sc, String prompt, double min, double max) {
		String s = "";
		boolean isValid = false;
		while (isValid == false)
		{
			s = getRequiredString(sc, prompt);
			if(isNumeric(s.trim())) {
				double d = Double.parseDouble(s.trim());				
				if (d < min)
					System.out.println("Error! Number must be greater than " + min);
				else if (d > max)
					System.out.println("Error! Number must be less than " + max);
				else
					isValid = true;	
			} else {
				System.out.println("Error! Must be a positive number, instead of characters");
			}
		}
		return s;
	}
}