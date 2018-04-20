import java.text.DecimalFormat;

/**
 * Homework 3-1: Calculation a circle's circumference and area
 * @author Kuei-Lin Yang
 * Feb 4, 2018
 */
public class Circle {
	// declare object variables
	private double radius;
	private double circumference;
	private double area;
	// declare and initialize a class variable
	private static int objectCount = 0;
	
	// constructor
	public Circle(double radius) {
		this.radius = radius;
		this.circumference = 2 * Math.PI * radius;
		this.area = Math.PI * Math.pow(radius, 2);
		objectCount++;
	}
	
	public double getCircumference() {
		return circumference;
	}
	
	public String getFormattedCircumference() {
		return formatNumber(circumference);
	}
	
	public double getArea() {
		return area;
	}
	
	public String getFormattedArea() {
		return formatNumber(area);		
	}
	
	private String formatNumber(double x) {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(x);
	}
	
	public static int getObjectCount() {
		return objectCount;
	}

}
