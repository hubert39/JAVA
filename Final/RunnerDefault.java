import java.util.ArrayList;

/**
 * A RunnerDefault class implements RunnerDAO interface
 * It provides two default runners' information in an array list
 * 
 * @author Kuei-Lin Yang
 * Mar 23, 2018
 */
public final class RunnerDefault implements RunnerDAO{
	/**
	 * Declare instance variables
	 */
	private ArrayList<Runner> runners;
	
	/**
	 * Constructor
	 */
	public RunnerDefault() {
		runners = null;
	}
	
	/** 
	 * Define getRunners function
	 * @return ArrayList	runners in an array list
	 */
	public ArrayList<Runner> getRunners(){
		runners = new ArrayList<>();
		Runner runner1 = new Runner("Tortoise", 10, 0);
		Runner runner2 = new Runner("Hare", 100, 90);
		
		runners.add(runner1);
		runners.add(runner2);
		
		return runners;
	}
}
