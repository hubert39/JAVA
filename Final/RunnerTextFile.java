import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * A RunnerTextFile class implements RunnerDAO interface
 * It read a text file and retrieve related runners' information in an array list
 * 
 * @author Kuei-Lin Yang
 * Mar 23, 2018
 */
public final class RunnerTextFile implements RunnerDAO{
	/**
	 * Declare instance variables
	 */
	private ArrayList<Runner> runners;
	private String fileName;
	private File runnersFile;
	private final String FIELD_SEP = "\t+";
	
	/**
	 * Constructor with one String parameter
	 * @param fileName	test filename
	 */
	public RunnerTextFile(String fileName) {
		runners = null;
		this.fileName = fileName;
		runnersFile = null;
	}
	
	/** 
	 * Define getRunners function
	 * @return ArrayList	runners in an array list
	 */
	public ArrayList<Runner> getRunners(){
		ClassLoader classLoader = getClass().getClassLoader();
		if(classLoader.getResource(fileName) == null) {
			return null;
		}
		else
			runnersFile = new File(classLoader.getResource(fileName).getFile());
		
		runners = new ArrayList<>();
        if (runnersFile.exists())  // prevent the FileNotFoundException
        {
            try (BufferedReader in = 
                     new BufferedReader(
                     new FileReader(runnersFile)))
            {
                // read all runners stored in the file
                // into the array list
                String line = in.readLine();
                while(line != null) {
                		StringTokenizer tokens = new StringTokenizer(line, FIELD_SEP);
                		String name = tokens.nextToken();
                		String speed = tokens.nextToken();
                		String restPercentage = tokens.nextToken();
                		
                		Runner r = new Runner(name, Integer.parseInt(speed), Integer.parseInt(restPercentage));
                		runners.add(r);
                		line = in.readLine();
                }
            }
            catch(IOException e)
            {
            		System.out.println(e);
            		return null;
            }
        }
        return runners;  
	}
}
