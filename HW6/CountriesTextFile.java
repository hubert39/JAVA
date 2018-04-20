import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Homework 6-1: Maintain a list of countries
 * @author Kuei-Lin Yang
 * Mar 6, 2018
 */
public class CountriesTextFile {
	// declare instance variables
	private ArrayList<String> countries = null;
	private String filename = "countries.txt";
	private Path countryPath = null;
	private File countryFile = null;
	
	// constructor
	public CountriesTextFile() {
		countryPath = Paths.get(filename);
		countryFile = countryPath.toFile();
		countries = getCountries();
	}
	
	// get the list of countries
	protected ArrayList<String> getCountries() {
		// if the countries file has already been read, don't read it again
		//if(countries != null)
		//	return countries;
		countries = new ArrayList<>();
		
		if(Files.exists(countryPath)) {
			try(BufferedReader in = new BufferedReader (
									new FileReader(countryFile)))
			{
				String line = in.readLine();
				while(line != null) {
					countries.add(line);
					line = in.readLine();
				}
			}catch(IOException e) 
			{
				System.out.println(e);
				return null;
			}
		}else {
			//System.out.println(countryPath.toAbsolutePath() + " doesn't exist");
			// create a file, if not exist
			try {
				Files.createFile(countryPath);
			}catch(FileAlreadyExistsException e) {
				System.out.println(e);
			}catch(IOException e) {
				System.out.println(e);
			}
		}
		return countries;
	}
	
	// store the list of countries
	protected boolean saveCountries(ArrayList<String> countries) {
		try(PrintWriter out = new PrintWriter(
							new BufferedWriter(
							new FileWriter(countryFile))))
		{
			for(String country: countries) {
				out.println(country);
			}
			
		}catch(IOException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	protected boolean deleteCountry(String country) {
		if(countries.contains(country)) {
			countries.remove(country);
			return this.saveCountries(countries);
		}else {
			return false;
		}
	}
}
