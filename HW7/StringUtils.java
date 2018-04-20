
/**
 * Homework 7-1: Display Customer Invoices Report
 * @author Kuei-Lin Yang
 * Mar 13, 2018
 */

public class StringUtils {
	// append spaces until length matched
	public static String addSpaces(String s, int length) {
		if(s.isEmpty())
			return null;
		
		StringBuilder sbSpace = new StringBuilder();
		for(int i=0; i<length-s.length(); i++) {
			sbSpace.append(" ");
		}
		
		return s + sbSpace;
	}
}
