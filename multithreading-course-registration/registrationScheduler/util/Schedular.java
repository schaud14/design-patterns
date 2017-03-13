package registrationScheduler.util;

import java.util.List;
import java.util.ConcurrentModificationException;

import registrationScheduler.store.Results;
import registrationScheduler.util.Logger.DebugLevel;

public class Schedular {
	private List<Students> studentList;
	/**
	 * Constructor
	 * @param studentListIn
	 */
	public Schedular(List<Students> studentListIn) {
		studentList = studentListIn;
		Logger.writeMessage("Constructor of schedular is called", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * allocated the courses. the algorithm to select courses to allocate.
	 * @param number
	 * @param objectPool
	 * @param result
	 * @return
	 */
	public synchronized Results allocateChoice(int number, ObjectPool objectPool, Results result) {
		try {
			int maxnumber = 6;
			Courses course = null;
			if(number<maxnumber)
			{
				synchronized(studentList)
				{
					for(Students student:studentList)
					{	
						if(student == null) {
							continue;
						}
						int prefCourse = student.getPreffredCourse(student.getChoice()+number);
						do
						{
							course = objectPool.borrowCourse(prefCourse);
						}while(course == null);
						
						if(course.getStudenCount() < 60 && student.getAssignCounter() < 5)
						{
							
							result.updateResult(studentList,student, course,student.getChoice() + number);
							student.setPreferenceCount(student.getPreferenceCount()+ number+student.getChoice());
						}
						else
						{
							
							if(number < maxnumber)
							{
								prefCourse = student.getPreffredCourse(student.getChoice()+number+1);
								if(course != null)
								{
									objectPool.returnCourse(course);
								}
								do
								{
									course = objectPool.borrowCourse(prefCourse);
								}while(course == null);
								
								if(course.getStudenCount() < 60 && student.getAssignCounter() < 5)
								{
									result.updateResult(studentList,student, course,student.getChoice() + number+1);
									student.setPreferenceCount(student.getPreferenceCount()+number+student.getChoice()+1);
									student.setChoice(student.getChoice()+1);
								}
							}
							else
							{
								if(course != null)
								{
									objectPool.returnCourse(course);
								}
								prefCourse = student.getPreffredCourse(number);
								do
								{
									course = objectPool.borrowCourse(prefCourse);
								}while(course == null);
								if(course.getStudenCount() < 60 && student.getAssignCounter() < 5)
								{
									result.updateResult(studentList,student, course,student.getChoice() + number);
									student.setPreferenceCount(student.getPreferenceCount()+number+student.getChoice());
									student.setChoice(student.getChoice()+1);
								}
							}
						}
						if(course != null)
						{
							objectPool.returnCourse(course);
						}			
					}
				}
			}
			else
			{
				synchronized(studentList)
				{
					for(Students student:studentList)
					{
						if(student == null) {
							continue;
						}
						int prefCourse = student.getPreffredCourse(number);
						if(course != null)
						{
							objectPool.returnCourse(course);
						}		
						do
						{
							course = objectPool.borrowCourse(prefCourse);
						}while(course == null);
						if(course.getStudenCount() < 60 && student.getAssignCounter() < 5)
						{
							result.updateResult(studentList,student, course,student.getChoice() + number);
							student.setPreferenceCount(student.getPreferenceCount()+number+student.getChoice());
							student.setChoice(student.getChoice()+1);
						}
						objectPool.returnCourse(course);
					}
				}
			}
		} 
		catch (NullPointerException e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch (ConcurrentModificationException e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
		return result;
	}
}
