/**
 * A ThreadRunner class implements Runnable interface
 * It counts each runner's running distance.
 *  
 * @author Kuei-Lin Yang
 * Mar 21, 2018
 */
public class ThreadRunner implements Runnable{
	/**
	 * Declare instance variables 
	 */
	private final int DISTANCE = 1000;
	private String name;
	private int speed;
	private int restPercentage;
	private MarathonRaceApp marathonRaceApp;
	
	
	/**
	 * Constructor
	 */
	public ThreadRunner() {
		name = null;
		speed = 0;
		restPercentage = 0;
		marathonRaceApp = null;
	}

	/**
	 * Constructor with three parameters
	 * @param name			a runner's name
	 * @param speed			a runner's speed
	 * @param restPecentage	a runner's percentage of rest
	 * @param marathonRaceApp MarathonRaceApp object
	 */
	public ThreadRunner(String name, int speed, int restPecentage, MarathonRaceApp marathonRaceApp) {
		this.name = name;
		this.speed = speed;
		this.restPercentage = restPecentage;
		this.marathonRaceApp = marathonRaceApp;
	}
	
	/**
	 * Produce random integer number from 1 to 100
	 * @return int random integer between 1 and 100
	 */
	private int getRandNumber() {
		double randNumber = Math.random() * 100;
		return (int)randNumber + 1;
	}
	
	/**
	 * Override run function
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread ct = Thread.currentThread();
		int sum = 0;
		if (!ct.isInterrupted())
        {
			try {
				while(sum < DISTANCE) {
					int randNumber = getRandNumber();
					//System.out.println("randNumber=" + randNumber + "; restPercentage=" + restPercentage);
					if(randNumber <= restPercentage) {
						//System.out.println(ct.getName() + " yield!!!");
						ct.yield();
					}else {
						sum = sum + speed;
						System.out.println(ct.getName() + " : " + sum);
					}
					ct.sleep(100);
				}
				
				if(marathonRaceApp.isFirst()) {
					System.out.println(ct.getName() + " : I finished!\n");					
					System.out.println("The race is over! The " + ct.getName() + " is the winner.\n");
					marathonRaceApp.finished(name);
				}
				
			}catch (InterruptedException e) {
				System.out.println(ct.getName() + ": You beat me fair and square.");
				//System.out.println(e.getStackTrace());
			}
        }
		
	}

}
