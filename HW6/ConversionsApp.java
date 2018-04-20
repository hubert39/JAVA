import java.util.ArrayList;
import java.util.Scanner;

/**
 * Homework 6-2: Maintain a conversions table
 * @author Kuei-Lin Yang
 * Mar 6, 2018
 */
public class ConversionsApp {

	private static void displayMenu() {
		String menuItems = "1 - Convert a length\n" +
							"2 - Add a type of conversion\n" +
							"3 - Delete a type of conversion\n" +
							"4 - Exit\n";
		System.out.println(menuItems);
	}
	
	private static void displayConversions(ArrayList<Conversion> conversionsArray) {
		/*int itemNumber = 0;
		for(Conversion conversion : conversionsArray) {
			itemNumber++;
			System.out.println(itemNumber + " - " + conversion.formattedConversoin());
		}*/
		
		for(int i=0; i<conversionsArray.size(); i++) {
			System.out.println(i+1 + " - " + conversionsArray.get(i).formattedConversoin());
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Length Converter");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		ConversionsTextFile conversionsTextFile = new ConversionsTextFile();
		ArrayList<Conversion> conversionsArray = null;
		int selectedNumber = 0;
		do {
			displayMenu();
			selectedNumber = Validator.getIntWithinRange(sc, "Enter menu number: ", 1, 4);
			System.out.println();
			
			// deal with item actions 1.Convert/2.Add/3.Delete/4.Exit
			if(selectedNumber == 1) {
				conversionsArray = conversionsTextFile.getConversions();
				if(conversionsArray == null)
				{
					System.out.println("NULL");
				}else if(conversionsArray.isEmpty()) {
					System.out.println("There is no conversion items. Please add one first.");
				}else {
					displayConversions(conversionsArray);
					int conversionNumber = Validator.getIntWithinRange(sc, "Enter conversion number: ", 1, conversionsArray.size());
					System.out.println();
					
					String fromUnit = conversionsArray.get(conversionNumber-1).getFromUnit();
					String toUnit = conversionsArray.get(conversionNumber-1).getToUnit();
					double value = Validator.getDouble(sc, "Enter " + fromUnit + ": ");
					String calculatedValue = conversionsArray.get(conversionNumber-1).calculate(value);
					System.out.println(value + " " + fromUnit + " = " + calculatedValue + " " + toUnit);
				}
			}else if(selectedNumber == 2) {
				String fromUnit = Validator.getRequiredString(sc, "Enter 'From' unit: ");
				String toUnit = Validator.getRequiredString(sc, "Enter 'To' unit: ");
				double conversionRatio = Validator.getDouble(sc, "Enter the conversion ratio: ");
				
				Conversion conversion = new Conversion(fromUnit, toUnit, conversionRatio);
				conversionsArray = conversionsTextFile.getConversions();
				conversionsArray.add(conversion);
				System.out.println();
				if(conversionsTextFile.saveConversions(conversionsArray)) {
					System.out.println("This entry has been saved.");
				}else {
					System.out.println("Save Unsuccessfully! Try again!");
				}
			}else if(selectedNumber == 3) {
				conversionsArray = conversionsTextFile.getConversions();
				if(conversionsArray == null)
				{
					System.out.println("NULL");
				}else if(conversionsArray.isEmpty()) {
					System.out.println("There is no conversion items. Please add one first.");
				}else {
					displayConversions(conversionsArray);
					int deletedNumber = Validator.getIntWithinRange(sc, "Enter conversion number: ", 1, conversionsArray.size());
					System.out.println();
					if(conversionsTextFile.deleteConversion(conversionsArray.get(deletedNumber-1))) {
						System.out.println("This entry has been deleted.");
					}else {
						System.out.println("Remove Unsuccessfully! Try again!");
					}
				}
			}else if(selectedNumber == 4) {
				System.out.println("Goodbye.");
			}
			System.out.println();
		}while(selectedNumber != 4);

	}

}
