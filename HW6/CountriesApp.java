import java.util.ArrayList;
import java.util.Scanner;

/**
 * Homework 6-1: Maintain a list of countries
 * @author Kuei-Lin Yang
 * Mar 6, 2018
 */
public class CountriesApp {

	// display menu
	private static void displayMenu() {
		String menuItems = "1 - List countries\n" +
						   "2 - Add a country\n" +
						   "3 - Delete a country\n" +
						   "4 - Exit\n";
		System.out.println(menuItems);
	}
	
	// display countries
	private static void displayCountries(ArrayList<String> countries) {
		for(String country : countries) {
			System.out.println(country);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Countries Maintenance application");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		CountriesTextFile countriesTextFile = new CountriesTextFile();
		ArrayList<String> countries = null;
		int selectedNumber = 0;
		do {
			displayMenu();
			selectedNumber = Validator.getIntWithinRange(sc, "Enter menu number: ", 1, 4);
			System.out.println();
			
			// deal with item actions 1.list/2.Add/3.Delete/4.Exit
			if(selectedNumber == 1) {
				countries = countriesTextFile.getCountries();
				if(countries == null)
				{
					System.out.println("NULL");
				}else if(countries.isEmpty()) {
					System.out.println("There is no country items. Please add one first.");
				}else {
					displayCountries(countries);
				}
			}else if(selectedNumber == 2) {
				String country = Validator.getRequiredString(sc, "Enter country: ");
				countries = countriesTextFile.getCountries();
				countries.add(country);
				System.out.println();
				if(countriesTextFile.saveCountries(countries)) {
					System.out.println("This country has been saved.");
				}else {
					System.out.println("Save Unsuccessfully! Try again!");
				}
			}else if(selectedNumber == 3) {
				countries = countriesTextFile.getCountries();
				if(countries == null)
				{
					System.out.println("NULL");
				}else if(countries.isEmpty()) {
					System.out.println("There is no country items. Please add one first.");
				}else {
					displayCountries(countries);
					System.out.println();
					String removedCountry = Validator.getRequiredString(sc, "Type the country to remove: ");
					System.out.println();
					if(countriesTextFile.deleteCountry(removedCountry)) {
						System.out.println("This country has been deleted.");
					}else {
						System.out.println("Remove Unsuccessfully! Try again!");
					}
				}
			}else if(selectedNumber == 4) {
				System.out.println("Goodbye.");
			}
			System.out.println();
		}while(selectedNumber !=4 );
		
	}
}
