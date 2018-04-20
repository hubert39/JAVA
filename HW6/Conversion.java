import java.text.DecimalFormat;

/**
 * @author Kuei-Lin Yang
 * Mar 6, 2018
 */

public class Conversion {
	private String fromUnit = null;
	private String toUnit = null;
	private double fromValue = 0.0;
	private double toValue = 0.0;
	private double conversionRatio = 0.0;
	
	// constructor
	public Conversion() {
		
	}
	
	public Conversion(String fromUnit, String toUnit, double conversionRatio) {
		this.fromUnit = fromUnit;
		this.toUnit = toUnit;
		this.conversionRatio = conversionRatio;
	}
	
	protected String calculate(double value) {
		DecimalFormat decimalFormat = new DecimalFormat("#.#####");
		return decimalFormat.format(value * conversionRatio);
	}
	
	protected String formattedConversoin() {
		String formattedConversion = fromUnit + " to " + toUnit + ": " + conversionRatio;
		return formattedConversion;
	}
	
	protected String getFromUnit() {
		return fromUnit;
	}
	
	protected String getToUnit() {
		return toUnit;
	}

	protected double getConversionRatio() {
		return conversionRatio;
	}

	/*
	private void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}
	
	private void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}
	
	private void setConversionRatio(double conversionRatio) {
		this.conversionRatio = conversionRatio;
	}*/

}
