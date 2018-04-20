import java.text.NumberFormat;
import java.util.Locale;

/**
 * Homework 5-2: Display Quarterly Sales Report
 * @author Kuei-Lin Yang
 * Feb 26, 2018
 */

public class SalesData {
	// first index+1: region; second index+1: quarter
	private double[][] salesOfRegionQuarter = {{1540.00, 2010.00, 2450.00, 1845.00},
											  {1130.00, 1168.00, 1847.00, 1491.00},
											  {1580.00, 2305.00, 2710.00, 1284.00},
											  {1105.00, 4102.00, 2391.00, 1576.00}};

	/*protected double[] getRegionSales(int quarter) {
		return salesOfRegionQuarter[quarter-1];
	}*/
	
	protected String getFormattedCurrency(double value) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
		numberFormat.setMaximumFractionDigits(2);
		return numberFormat.format(value);
	}
	
	protected String listSalesReport() {
		StringBuilder report = new StringBuilder("Region\tQ1\t\tQ2\t\tQ3\t\tQ4\n");
		for(int i=0; i<salesOfRegionQuarter.length; i++) {
			String row = "";
			for(int j=0; j<salesOfRegionQuarter[i].length; j++) {
				row = row + getFormattedCurrency(salesOfRegionQuarter[i][j]) + "\t";
			}
			report.append( i + 1 + "\t" + row + "\n");
		}
		return report.toString();
	}
	
	protected String listRegionTotal() {
		StringBuilder summary = new StringBuilder("Sales by region:\n");
		for(int i=0; i<salesOfRegionQuarter.length; i++) {
			double sum = 0;
			for(int j=0; j<salesOfRegionQuarter[i].length; j++) {
				sum = sum + salesOfRegionQuarter[i][j];
			}
			int count = i+1;
			summary.append("Region " + count + ": " + getFormattedCurrency(sum) + "\n");
		}
		return summary.toString();
	}
	
	protected String listQuarterTotal() {
		StringBuilder summary = new StringBuilder("Sales by quarter:\n");
		
		for(int i=0; i<salesOfRegionQuarter[0].length; i++) {
			double sum = 0;
			for(int j=0; j<salesOfRegionQuarter.length; j++) {
				sum = sum + salesOfRegionQuarter[j][i];
			}
			int count = i+1;
			summary.append("Q" + count + ": " + getFormattedCurrency(sum) + "\n");
		}
		return summary.toString();
	}

	protected String listAnnualTotal() {
		StringBuilder summary = new StringBuilder("Total annual sales, all regions: ");
		double sum = 0;
		for(int i=0; i<salesOfRegionQuarter.length; i++) {
			for(int j=0; j<salesOfRegionQuarter[i].length; j++) {
				sum = sum + salesOfRegionQuarter[i][j];
			}
		}
		summary.append(getFormattedCurrency(sum) + "\n");
		return summary.toString();
		
	}
}
