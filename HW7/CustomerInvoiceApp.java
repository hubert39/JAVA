import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Homework 7-1: Display Customer Invoices Report
 * @author Kuei-Lin Yang
 * Mar 13, 2018
 */
public class CustomerInvoiceApp {

	// get a database connection
	private static Connection getConnection() {
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
	
	// format invoiceTotal as US dollars
	private static String formattedCurrency(double invoiceTotal) {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
		return currency.format(invoiceTotal);
	}
	
	// format Date as US date
	private static String formattedDate(Date date) {
		DateFormat usDateFormat = DateFormat.getDateInstance(3, Locale.US);
		return usDateFormat.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Customer Invoices Report");
		System.out.println();
		
		String sql = "SELECT C.EMAILADDRESS, I.INVOICENUMBER, I.INVOICEDATE, I.INVOICETOTAL " + 
					"FROM CUSTOMERS C, INVOICES I " + 
					"WHERE C.CUSTOMERID = I.CUSTOMERID ORDER BY C.EMAILADDRESS";
		//System.out.println(sql);
		try(Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String emailAddress = rs.getString("EMAILADDRESS");
				String invoiceNumber = rs.getString("INVOICENUMBER");
				Date invoiceDate = rs.getDate("INVOICEDATE");
				double invoiceTotal = rs.getDouble("INVOICETOTAL");
				System.out.println(StringUtils.addSpaces(emailAddress, 30) + StringUtils.addSpaces(invoiceNumber, 9) + StringUtils.addSpaces(formattedDate(invoiceDate), 11) + formattedCurrency(invoiceTotal));
			}
			rs.close();
		} catch(SQLException e) {
			System.err.println(e);
		}
		System.out.println();
		/*
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection(); 
			
			DatabaseMetaData m = connection.getMetaData();
			ResultSet tables = m.getTables(null, null, "%", null);
			while(tables.next()) {
				System.out.println(tables.getString(3));
			}
			tables.close();
			
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM INVOICES");
			while(rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
				
		if(disconnect())
			System.out.println("Database disconnects successfully.");
		else
			System.out.println("Database disconnects failure.");

	}

}
