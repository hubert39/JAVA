import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A RunnerDBFile class implements RunnerDAO interface
 * It connects a derby database and retrieve related runners' information in an array list
 * 
 * @author Kuei-Lin Yang
 * Mar 23, 2018
 */
public final class RunnerDBFile implements RunnerDAO {
	/**
	 * Declare instance variables
	 */
	private ArrayList<Runner> runners;
	private String fileName;
	
	/**
	 * Constructor with one String parameter
	 * @param fileName	database filename
	 */
	public RunnerDBFile(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Get a database connection
	 * @return Connection
	 */
	private Connection connect() {
		Connection connection = null;
		try {
			String dbDirectory = "Resources";
			System.setProperty("derby.system.home", dbDirectory);
			String dbUrl = "jdbc:derby:" + fileName;
			String username = "";
			String password = "";
		
			connection = DriverManager.getConnection(dbUrl, username, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Shut down a database connection
	 * @return boolean
	 */
	private boolean disconnect() {
		try {
			String shutdownURL = "jdbc:derby:" + fileName + ";shutdown=true";
			DriverManager.getConnection(shutdownURL);
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			if(e.getMessage().equals("Database '" + fileName + "' shutdown."))
				return true;
		}
		return false;
	}
	
	
	/**
	 * Define getRunners function
	 * @return ArrayList	runners in an array list
	 */
	public ArrayList<Runner> getRunners(){
		runners = new ArrayList<>();
		String sql = "SELECT NAME, RUNNERSSPEED, RESTPERCENTAGE " + 
				 	 "FROM RUNNERSSTATS";
		//System.out.println(sql);
		try(Connection connection = connect();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("NAME");
				int speed = (int)rs.getDouble("RUNNERSSPEED");
				int restPercentage = (int)rs.getDouble("RESTPERCENTAGE");
				Runner runner = new Runner(name, speed, restPercentage);
				runners.add(runner);
			}
			rs.close();
			return runners;
		} catch (SQLException e) {
			//System.err.println(e);
			return null;
		} finally {
			disconnect();
			/*if(disconnect()) {
				System.out.println("Database disconnects successfully.");
			}*/
		}
	}

}
