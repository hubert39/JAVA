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
 * Homework 6-2: Maintain a conversions table
 * @author Kuei-Lin Yang
 * Mar 6, 2018
 */
public class ConversionsTextFile {
	private ArrayList<Conversion> conversions = null;
	private String filename = "conversion_types.txt";
	private Path conversionsPath = null;
	private File conversionsFile = null;
	private final String FIELD_SEP = "\t";
	
	public ConversionsTextFile() {
		conversionsPath = Paths.get(filename);
		conversionsFile = conversionsPath.toFile();
		conversions = getConversions();
	}
	
	protected ArrayList<Conversion> getConversions(){
		conversions = new ArrayList<>();
		
		if(Files.exists(conversionsPath)) {
			try(BufferedReader in = new BufferedReader (
									new FileReader(conversionsFile)))
			{
				String line = in.readLine();
				while(line != null) {
					String[] columns = line.split(FIELD_SEP);
					String fromUnit = columns[0]; 
					String toUnit = columns[1];
					String conversionRatio = columns[2];
					
					Conversion conversion = new Conversion(fromUnit, toUnit, Double.parseDouble(conversionRatio));
					conversions.add(conversion);
					
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
				Files.createFile(conversionsPath);
			}catch(FileAlreadyExistsException e) {
				System.out.println(e);
			}catch(IOException e) {
				System.out.println(e);
			}
		}
		return conversions;
	}
	
	protected boolean saveConversions(ArrayList<Conversion> typeList) {
		try(PrintWriter out = new PrintWriter(
				new BufferedWriter(
				new FileWriter(conversionsFile))))
		{
			for(Conversion conversion: typeList) {
				out.print(conversion.getFromUnit() + FIELD_SEP);
				out.print(conversion.getToUnit() + FIELD_SEP);
				out.println(conversion.getConversionRatio());
			}
		} catch(IOException e) 
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	protected boolean deleteConversion(Conversion conversion) {
		if(conversions.contains(conversion)) {
			conversions.remove(conversion);
			return this.saveConversions(conversions);
		}else
			return false;
	}
}
