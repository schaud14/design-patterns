package genericDeser.util;

import genericDeser.util.Logger.DebugLevel;

/**
 * 
 * @author Saurabh Chaudhari
 *
 */
public class First {
	private int IntValue;
	private float FloatValue;
	private short ShortValue;
	private String StringValue;
	
	/**
	 * Empty Constructor
	 */
	public First() {
		Logger.writeMessage("Constructor: First", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * @return IntValue
	 */
	public int getIntValue() {
		return IntValue;
	}
	/**
	 * to set IntValue
	 * @param intValueIn
	 */
	public void setIntValue(int intValueIn) {
		IntValue = intValueIn;
	}
	/**
	 * @return FloatValue
	 */
	public float getFloatValue() {
		return FloatValue;
	}
	/**
	 * To set FloatValue
	 * @param floatValueIn
	 */
	public void setFloatValue(float floatValueIn) {
		FloatValue = floatValueIn;
	}
	/**
	 * @return ShortValue
	 */
	public short getShortValue() {
		return ShortValue;
	}
	/**
	 * To set ShortValue
	 * @param shortValueIn
	 */
	public void setShortValue(short shortValueIn) {
		ShortValue = shortValueIn;
	}
	/**
	 * @return StringValue
	 */
	public String getStringValue() {
		return StringValue;
	}
	/**
	 * To set StringValue
	 * @param stringValueIn
	 */
	public void setStringValue(String stringValueIn) {
		StringValue = stringValueIn;
	}
	/**
	 * Overridden hashCode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ShortValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
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
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}
}
