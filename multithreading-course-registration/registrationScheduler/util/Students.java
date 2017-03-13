package registrationScheduler.util;

import registrationScheduler.util.Logger.DebugLevel;

public class Students {
	private int number;
	private String name;
	private int pref1;
	private int pref2;
	private int pref3;
	private int pref4;
	private int pref5;
	private int pref6;
	private int pref7;
	private int assignCounter;
	private int preferenceCount;
	private int choice;
	
	@Override
	public String toString() {
		return   this.name + "-"+ this.pref1 + this.pref2 + this.pref3 + this.pref4 + this.pref5 + this.pref6 + this.pref7;
	}
	public int getPref1() {
		return pref1;
	}
	public void setPref1(int pref1) {
		this.pref1 = pref1;
	}
	public int getPref2() {
		return pref2;
	}
	public void setPref2(int pref2) {
		this.pref2 = pref2;
	}
	public int getPref3() {
		return pref3;
	}
	public void setPref3(int pref3) {
		this.pref3 = pref3;
	}
	public int getPref4() {
		return pref4;
	}
	public void setPref4(int pref4) {
		this.pref4 = pref4;
	}
	public int getPref5() {
		return pref5;
	}
	public void setPref5(int pref5) {
		this.pref5 = pref5;
	}
	public int getPref6() {
		return pref6;
	}
	public void setPref6(int pref6) {
		this.pref6 = pref6;
	}
	public int getPref7() {
		return pref7;
	}
	public void setPref7(int pref7) {
		this.pref7 = pref7;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getAssignCounter() {
		return assignCounter;
	}
	public void setAssignCounter(int assignCounter) {
		this.assignCounter = assignCounter;
	}
	public int getPreferenceCount() {
		return preferenceCount;
	}
	public void setPreferenceCount(int preferenceCount) {
		this.preferenceCount = preferenceCount;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(String name) {
		String[] split_name = name.split("_");
		this.number = Integer.parseInt(split_name[1]);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Method to process line got from the input file.
	 * @param line
	 */
	public synchronized void processEntry(String line)
	{
		try {
			String[] lineSplit = line.split(" ");
			String[] lineSplit1 = lineSplit[0].split("_");
			this.setName(lineSplit[0]);
			this.setNumber(Integer.parseInt(lineSplit1[1]));
			this.setPref1(Integer.parseInt(lineSplit[1]));
			this.setPref2(Integer.parseInt(lineSplit[2]));
			this.setPref3(Integer.parseInt(lineSplit[3]));
			this.setPref4(Integer.parseInt(lineSplit[4]));
			this.setPref5(Integer.parseInt(lineSplit[5]));
			this.setPref6(Integer.parseInt(lineSplit[6]));
			this.setPref7(Integer.parseInt(lineSplit[7]));
		} 
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
		}
		finally {
			
		}
	}
	/**
	 * Constructor
	 */
	public Students() {
		this.pref1 = 0;
		this.pref2 = 0;
		this.pref3 = 0;
		this.pref4 = 0;
		this.pref5 = 0;
		this.pref6 = 0;
		this.pref7 = 0;
		this.assignCounter = 0;
		this.preferenceCount = 0;
		this.choice = 0;
		this.number = 0;
		this.name = null;
		Logger.writeMessage("Constructor of Students is called", DebugLevel.CONSTRUCTOR);

	}

	/**
	 * method to get course of selected choice
	 * @param choice
	 * @return
	 */
	public int getPreffredCourse(int choice) {
		if(this.pref1==choice)
			return 1;
		if (this.pref2==choice)
			return 2;
		if (this.pref3==choice)
			return 3;
		if (this.pref4==choice)
			return 4;
		if (this.pref5==choice)
			return 5;
		if (this.pref6==choice)
			return 6;
		if (this.pref7==choice)
			return 7;
		return 0;	
	}
}
