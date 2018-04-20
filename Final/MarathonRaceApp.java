import java.util.ArrayList;
import java.util.Scanner;

/**
 * A MarathonRace App class is an application for the race 
 * 
 * @author Kuei-Lin Yang
 * Mar 21, 2018
 */
public class MarathonRaceApp {
	/**
	 * Declare instance variables
	 */
	private ArrayList<Thread> arrayListOfThread = null;
	private ArrayList<Runner> runners = null;
	private boolean isFirst = false;
	
	
	/**
	 * Display items for a user to choose
	 */
	private static void displayMenu() {
		String menu = "Select your data source:\n\n" +
					"1. Derby database\n" +
					"2. XML file\n" +
					"3. Text file\n" +
					"4. Default two runners\n" +
					"5. Exit\n";
		System.out.println(menu);
	}
	
	/**
	 * Create runners with related to the parameter in an array list
	 * @param runners	runners from chosen RunnerDAO
	 */
	private void createRunners(ArrayList<Runner> runners) {
		arrayListOfThread = new ArrayList<>();
		for(Runner runner: runners) {
			String name = runner.getName();
			int speed = runner.getSpeed();
			int restPercentage = runner.getRestPercentage();
			//System.out.println("Runners: name=" + name + "; speed=" + speed + "; restPercentange="+ restPercentage);
			
			Thread thread = new Thread(new ThreadRunner(name, speed, restPercentage, this), name);
			thread.start();
			arrayListOfThread.add(thread);
		}
		
		for(int i = 0; i < arrayListOfThread.size(); i++) {
			try {
				arrayListOfThread.get(i).join();				
			}catch(InterruptedException e) {
				System.out.println(e.getStackTrace());
			}
		}
		
		System.out.println();
		System.out.println("Press enter key to continue ...\n");
		Scanner sc = new Scanner(System.in);
		String s = "start";
        // wait for the user to press Enter
        while (!s.equals(""))
            s = sc.nextLine();
	}
	
	/**
	 * Check the RunnerDAO is valid with regard to choice and filename
	 * @param choice		a user's choice
	 * @param fileName	a user's input
	 * @return	boolean
	 */
	private boolean createRunners(int choice, String fileName) {
		RunnerDAO runnerDAO = DAOFactory.getRunnerDAO(choice, fileName);
		if(runnerDAO == null) {
			System.out.println("Invalid filename. Try again!\n");
			return false;
		}else
			runners = runnerDAO.getRunners();
		
		if(runners == null) {
			System.out.println("Invalid filename. Try again!\n");
			return false;
		}else {
			if(choice == 4)
				System.out.println("Get set...Go!");
			this.createRunners(runners);
			return true;
		}
	}
	
	/**
	 * Let isFirst become false
	 */
	private void reset() {
		isFirst = false;
	}
	
	/**
	 * Set isFirst to true while the first finished 
	 * @return boolean
	 */
	protected synchronized boolean isFirst() {
		if(isFirst == false) {
			isFirst = true;
			return true;
		}else
			return false;
	}
	
	/**
	 * Finish the race, and interrupt remaining runners
	 * @param name	a runner's name
	 */
	protected void finished(String name) {
		for(int i=0; i<arrayListOfThread.size(); i++) {
			if(!name.equals(arrayListOfThread.get(i).getName())) {
				arrayListOfThread.get(i).interrupt();
			}	
		}
	}
	
	/**
	 * Main function of MarathonRaceApp
	 * @param args	arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MarathonRaceApp marathonRaceApp = new MarathonRaceApp();
		int choice = 0;
		do{
			marathonRaceApp.reset();
			System.out.println("Welcome to the Marathon Race Runner Program\n");
			displayMenu();
			
			choice = Validator.getIntWithinRange(sc, "Enter you choice: ", 1, 5);
			
			switch(choice){
			case 1:
				String dbFilename = Validator.getRequiredString(sc, "Enter Database file name: ");
				if( !marathonRaceApp.createRunners(choice, dbFilename) )
					continue;
				break;
			case 2:
				String xmlFilename = Validator.getRequiredString(sc, "Enter XML file name: ");
				if( !marathonRaceApp.createRunners(choice, xmlFilename) )
					continue;
				break;
			case 3:
				String textFilename = Validator.getRequiredString(sc, "Enter Text file name: ");
				if( !marathonRaceApp.createRunners(choice, textFilename) )
					continue;
				break;
			case 4:
				String defaultFilename = "Default";
				if( !marathonRaceApp.createRunners(choice, defaultFilename) )
					continue;
				break;
			case 5:
				System.out.println("Thank you for using my Marathon Race Program");
				break;
			}
		}while (choice != 5);
	}

}
