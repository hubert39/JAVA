import java.util.Scanner;

/**
 * A Validator class validates user's input text
 * 
 * @author Kuei-Lin Yang
 * Mar 23, 2018
 */
public class Validator
{
	/**
	 * Check if the input integer is valid
	 * @param sc		Scanner object
	 * @param prompt	prompt information
	 * @return int	a valid integer
	 */
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

	/**
	 * Check if the input integer is valid between min and max
	 * @param sc		Scanner object
	 * @param prompt	prompt information
	 * @param min	minimum value
	 * @param max	maximum value
	 * @return int	a valid integer
	 */
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

	/**
	 * Check if the input double is valid
	 * @param sc		Scanner object
	 * @param prompt	prompt information
	 * @return double	a valid double
	 */
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

	/**
	 * Check if the input double is valid between min and max
	 * @param sc		Scanner object
	 * @param prompt	prompt information
	 * @param min	minimum value
	 * @param max	maximum value
	 * @return double	a valid double
	 */
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
	

	/**
	 * Check if the input String is valid
	 * @param sc		Scanner object
	 * @param prompt	prompt information
	 * @return	String	a valid String
	 */
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
	
	/**
	 * Check if the input String is s1 or s2
	 * @param sc		Scanner object
	 * @param prompt	prompt information
	 * @param s1		s1 String
	 * @param s2		s2 String
	 * @return	String	a valid String
	 */
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