//package binghamton.com.edu;
/**
 * 
 * @author saurabh chaudhari
 * Class for courses which contains 
 * total students assigned to the course
 */
public class Courses {
	int StudentCount;

	public int getStudentCount() {
		return StudentCount;
	}

	public void setStudentCount(int studentCount) {
		StudentCount = studentCount;
	}

	/**
	 * toString method for debugging.
	 */
	public String toString() {
		return "Courses [StudentCount=" + StudentCount + "]";
	}
	
}	
