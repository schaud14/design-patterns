//package binghamton.com.edu;
/**
 * @author saurabh chaudhari
 * Class for Student Data
 * Student Object contains all the info
 * required for the allocating the courses
 * Like preferences,courses assigned etc.
 * 
 */
import java.util.Arrays;

public class Students {
	int coursePref1;
	int coursePref2;
	int coursePref3;
	int coursePref4;
	int preferenceCount;
	int courseAssigned[];
	int assignCounter;
	int choice;
	
	/**
	 * Constructor for student class.
	 * 
	 */
	public Students() {
		this.courseAssigned = new int[3];
		this.assignCounter=0;
		this.choice = 0;
	}

	public int getChoice() {
		return this.choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	/**
	 * toString method for debugging
	 */
	public String toString() {
		return "Students [coursePref1=" + coursePref1 + ", coursePref2=" + coursePref2 + ", coursePref3=" + coursePref3
				+ ", coursePref4=" + coursePref4 + ", preferenceCount=" + preferenceCount + ", courseAssigned="
				+ Arrays.toString(courseAssigned) + ", assignCounter=" + assignCounter + "]";
	}

	public void setCoursePref1(int coursePref1) {
		this.coursePref1 = coursePref1;
	}
	
	public void setCoursePref2(int coursePref2) {
		this.coursePref2 = coursePref2;
	}
	
	public void setCoursePref3(int coursePref3) {
		this.coursePref3 = coursePref3;
	}
	
	public void setCoursePref4(int coursePref4) {
		this.coursePref4 = coursePref4;
	}
	
	

	public void setPreferenceCount(int preferenceCount) {
		this.preferenceCount = preferenceCount;
	}

	public void setCourseAssigned(int[] courseAssigned) {
		this.courseAssigned = courseAssigned;
	}

	public void setAssignCounter(int assignCounter) {
		this.assignCounter = assignCounter;
	}

	public int getCoursePref1() {
		return coursePref1;
	}

	public int getCoursePref2() {
		return coursePref2;
	}

	public int getCoursePref3() {
		return coursePref3;
	}

	public int getCoursePref4() {
		return coursePref4;
	}

	public int getPreferenceCount() {
		return this.preferenceCount;
	}

	public int[] getCourseAssigned() {
		return courseAssigned;
	}

	public int getAssignCounter() {
		return this.assignCounter;
	}

	/**
	 * 
	 * @param choice
	 * @return course selected by student for this preference.
	 */
	public int getCoursePref(int choice) {
		if(this.coursePref1==choice)
			return 1;
		if (this.coursePref2==choice)
			return 2;
		if (this.coursePref3==choice)
			return 3;
		if (this.coursePref4==choice)
			return 4;
		return 0;
		
	}
}

