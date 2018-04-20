import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Homework 7-2: Maintain customer data
 * @author Kuei-Lin Yang
 * Mar 13, 2018
 */

public class CustomerDB {
	// get a database connection
	private static Connection connect() {
		Connection connection = null;
		try {
			String dbDirectory = "Resources";
			System.setProperty("derby.system.home", dbDirectory);
			String dbUrl = "jdbc:derby:BineetDB";
			String username = "";
			String password = "";
		
			connection = DriverManager.getConnection(dbUrl, username, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// shut down a database connection
	private static boolean disconnect() {
		try {
			String shutdownURL = "jdbc:derby:BineetDB;shutdown=true";
			DriverManager.getConnection(shutdownURL);
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			if(e.getMessage().equals("Database 'BineetDB' shutdown."))
				return true;
		}
		return false;
	}
	
	// return all customers
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customers = new ArrayList<>();
		String sql = "SELECT EMAILADDRESS, FIRSTNAME, LASTNAME " + 
				 	 "FROM CUSTOMERS ORDER BY EMAILADDRESS";
		//System.out.println(sql);
		try(Connection connection = connect();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String emailAddress = rs.getString("EMAILADDRESS");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				Customer customer = new Customer(emailAddress, firstName, lastName);
				customers.add(customer);
			}
			rs.close();
			return customers;
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
	
	// return a customer
	public Customer getProduct(String emailAddr) {
		String sql = "SELECT EMAILADDRESS, FIRSTNAME, LASTNAME " + 
				 	 "FROM CUSTOMERS " +
				 	 "WHERE EMAILADDRESS = ?";
		//System.out.println(sql);
		try(Connection connection = connect();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, emailAddr);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String emailAddress = rs.getString("EMAILADDRESS");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				Customer customer = new Customer(emailAddress, firstName, lastName);
				rs.close();
				return customer;
			}else
				return null;
		} catch (SQLException e) {
			//System.err.println(e);
			return null;
		} finally {
			disconnect();
		}
	}
	
	// add a customer
	public boolean addCustomer(Customer c) {
		String sql = "INSERT INTO CUSTOMERS (FIRSTNAME, LASTNAME, EMAILADDRESS) " +
                		"VALUES (?, ?, ?)";
		try(Connection connection = connect();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmailAddress());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			//System.err.println(e);
			return false;
		} finally {
			disconnect();
		}
	}
	
	// delete a customer
	public boolean deleteCustomer(Customer c) {
		String sql = "DELETE FROM CUSTOMERS " +
					 "WHERE EMAILADDRESS = ?";
		try(Connection connection = connect();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, c.getEmailAddress());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			//System.err.println(e);
			return false;
		} finally {
			disconnect();
		}
	}
}
