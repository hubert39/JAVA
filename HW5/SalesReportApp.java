/**
 * Homework 5-2: Display Quarterly Sales Report
 * @author Kuei-Lin Yang
 * Feb 26, 2018
 */

public class SalesReportApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Sales Report Application.");
		System.out.println();
		
		SalesData salesData = new SalesData();
		// the first section of the report lists the sales by quarter for each region
		System.out.println(salesData.listSalesReport());
		
		// the second section summarizes the total annual sales by region
		System.out.println(salesData.listRegionTotal());
		
		// the third section summarizes the total annual sales by quarter for all regions
		System.out.println(salesData.listQuarterTotal());
		
		// the fourth section prints the total annual sales for all sales regions
		System.out.println(salesData.listAnnualTotal());
	}

}
