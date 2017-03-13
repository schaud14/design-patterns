package registrationScheduler.util;

import java.util.ArrayList;

import registrationScheduler.util.Logger.DebugLevel;

public class ObjectPool {
	private ArrayList<Courses> CoursesInUse = new ArrayList<Courses>();
	private ArrayList<Courses> CoursesIdle = new ArrayList<Courses>();
	private volatile static ObjectPool objectPool;
	/**
	 * Constructor to initialize object pool
	 */
	private ObjectPool()
	{
		Logger.writeMessage("Constructor of ObjectPool is called.", DebugLevel.CONSTRUCTOR);
		CoursesIdle.add(new Courses(1,0));
		CoursesIdle.add(new Courses(2,0));
		CoursesIdle.add(new Courses(3,0));
		CoursesIdle.add(new Courses(4,0));
		CoursesIdle.add(new Courses(5,0));
		CoursesIdle.add(new Courses(6,0));
		CoursesIdle.add(new Courses(7,0));
	}
	
	/**
	 * method to get singleton objectPool instance with double checked locking 
	 * @return
	 */
	public static synchronized ObjectPool getInstance()
	{
		if (objectPool == null)
		{
			synchronized(ObjectPool.class) 
			{
				if (objectPool == null)
				{
					objectPool = new ObjectPool();
				}
			}
		}
		return objectPool;
	}
		
	/**
	 * method to borrow object of courses
	 * @param courseIdIn
	 * @return
	 */
	public synchronized Courses borrowCourse(int courseIdIn)
	{
		if(!(CoursesIdle.isEmpty()))
		{
			for(Courses course: CoursesIdle)
			{
				if(course.getCourseID() == courseIdIn)
				{
					CoursesInUse.add(course);
					CoursesIdle.remove(course);
					return course;
				}
			}
		}
		return null;
	}
	/**
	 * Method to return borrowed object of courses
	 * @param courseIn
	 */
	public synchronized void returnCourse(Courses courseIn)
	{
		CoursesIdle.add(courseIn);
		CoursesInUse.remove(courseIn);
	}
	
}

	