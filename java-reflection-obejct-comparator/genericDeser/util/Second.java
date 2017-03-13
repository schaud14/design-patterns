package genericDeser.util;

import genericDeser.util.Logger.DebugLevel;

/**
 * 
 * @author Saurabh Chaudhari
 *
 */
public class Second {
	
	private int IntValue;
	private double DoubleValue;
	private boolean BooleanValue;
	/**
	 * Empty Constructor
	 */
	public Second() {
		Logger.writeMessage("Constructor: Second", DebugLevel.CONSTRUCTOR);
	}
	/**
	 * 
	 * @return IntValue
	 */
	public int getIntValue() {
		return IntValue;
	}
	/**
	 * To set IntValue
	 * @param intValueIn
	 */
	public void setIntValue(int intValueIn) {
		IntValue = intValueIn;
	}
	/**
	 * 
	 * @return DoubleValue
	 */
	public double getDoubleValue() {
		return DoubleValue;
	}
	/**
	 * To set DoubleValue
	 * @param doubleValueIn
	 */
	public void setDoubleValue(double doubleValueIn) {
		DoubleValue = doubleValueIn;
	}
	/**
	 * 
	 * @return BooleanValue
	 */
	public boolean isBooleanValue() {
		return BooleanValue;
	}
	/**
	 * To set BooleanValue
	 * @param booleanValueIn
	 */
	public void setBooleanValue(boolean booleanValueIn) {
		BooleanValue = booleanValueIn;
	}
	
	/**
	 * Overridden hashCode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
	}

	/**
	 * Overridden equals() method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (BooleanValue != other.BooleanValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	}
}
