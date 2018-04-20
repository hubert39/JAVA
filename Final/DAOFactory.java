/**
 * DAOFactory class provides a factory method by a static getRunnerDAO function
 * 
 * @author Kuei-Lin Yang
 * Mar 23, 2018
 */
public class DAOFactory {
	/**
	 * With regard to the parameters of a choice and a filename, return relative RunnerDAO
	 * @param choice		a user inputs a number from 1 to 5
	 * @param fileName	a user inputs a file name
	 * @return RunnerDAO	a interface extends RunnerReader
	 */
	public static RunnerDAO getRunnerDAO(int choice, String fileName) {
		RunnerDAO runnerDAO = null;
		
		switch(choice) {
		case 1:
			if(fileName.equalsIgnoreCase("RunnersDB")) {
				runnerDAO = new RunnerDBFile(fileName);
			}
			break;
		case 2:
			if(fileName.toLowerCase().endsWith(".xml")) {
				runnerDAO = new RunnerXmlFile(fileName);
			}
			break;
		case 3:
			if(fileName.toLowerCase().endsWith(".txt")) {
				runnerDAO = new RunnerTextFile(fileName);
			}
			break;
		case 4:
			if(fileName.equals("Default")) {
				runnerDAO = new RunnerDefault();
			}
			break;
		default:
			break;
		}
		return runnerDAO;
	}

}
