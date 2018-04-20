/**
 * A Runner class save a runner's name, speed, and percentage of rest
 * It provides necessary setters and getters.
 * 
 * @author Kuei-Lin Yang
 * Mar 23, 2018
 */
public class Runner {
	/**
	 * Declare instance variables
	 */
	private String name;
	private int speed;
	private int restPercentage;
	
	/**
	 * Constructor
	 */
	public Runner() {
		name = null;
		speed = 0;
		restPercentage = 0;
	}
	
	/**
	 * Constructor with three parameters
	 * @param name			a runner's name
	 * @param speed			a runner's speed
	 * @param restPercentage	a runner's percentage of rest
	 */
	public Runner(String name, int speed, int restPercentage) {
		this.name = name;
		this.speed = speed;
		this.restPercentage = restPercentage;
	}
	
	/**
	 * Setter for name
	 * @param name	a runner's name
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Setter for speed
	 * @param speed	a runner's speed
	 */
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Setter for the percentage of rest
	 * @param restPercentage	a runner's percentage of rest
	 */
	protected void setRestPercentage(int restPercentage) {
		this.restPercentage = restPercentage;
	}
	
	/**
	 * Getter for name
	 * @return String	a runner's name
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Getter for speed
	 * @return int	a runner's speed
	 */
	protected int getSpeed() {
		return speed;
	}
	
	/**
	 * Getter for the percentage of rest
	 * @return int	a runner's percentage of rest
	 */
	protected int getRestPercentage(){
		return restPercentage;
	}
	
	/**
	 * Override toString function
	 * @return String	a runner's information
	 */
	@Override
	public String toString() {
		return name + " " + speed + " " + restPercentage;
	}
}
