package registrationScheduler.util;

import registrationScheduler.util.Logger.DebugLevel;

public class Courses {
	
	private int CourseID;
	private int studenCount;
	
	/**
	 * Constructor
	 * @param cidIn
	 * @param sCountIn
	 */
	public Courses(int cidIn, int sCountIn) {
		CourseID = cidIn;
		studenCount = sCountIn;
		Logger.writeMessage("Constructor of courses is called", DebugLevel.CONSTRUCTOR);

	}
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseIDIn) {
		CourseID = courseIDIn;
	}
	public int getStudenCount() {
		return studenCount;
	}
	public void setStudenCount(int studenCountIn) {
		studenCount = studenCountIn;
	}	
}
