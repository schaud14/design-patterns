package registrationScheduler.util;

import java.util.LinkedHashMap;
import java.util.Map;
import registrationScheduler.util.Logger.DebugLevel;

public class Allocations {
	private String name;
	private Integer num;
	private Integer preferenceCount;
	public Map<Integer, Integer> givenCourses = new LinkedHashMap<Integer, Integer>(); 
	public int isUpdated = 0;
	
	/**
	 * Constructor
	 */
	public Allocations() {
		Logger.writeMessage("Constructor of Allocations is called", DebugLevel.CONSTRUCTOR);
		name = null;
		num = 0;
		preferenceCount = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String nameIn) {
		name = nameIn;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(int numIn) {
		num = numIn;
	}
	public Integer getPreferenceCount() {
		return preferenceCount;
	}
	public void setPreferenceCount(Integer preferenceCountIn) {
		preferenceCount = preferenceCountIn;
	}
	
	/**
	 * Synchronized method to update courses allocated to the student.
	 * @param courseID
	 * @param prefCountIn
	 * @return
	 */
	public synchronized Allocations updateEntry(int courseID,int prefCountIn){
		{
			isUpdated = 0;
			if(this.givenCourses.containsKey(courseID)) {
				isUpdated = 0;
			} else {
				this.givenCourses.put(courseID,prefCountIn);
				isUpdated = 1;
				setPreferenceCount(getPreferenceCount() + prefCountIn);
			}
		}
		return this;
	}
	
	/**
	 * Converts the key set of linked hashmap of allocated courses to String.
	 * @return
	 */
	public String displayMap()
	{
		String msg = null;
		char[] array = new char[10];
		int i =0;
			for(int index:givenCourses.keySet())
			{
				givenCourses.get(index);
				array[i] = (char)(index+64);
				array[i+1] = ' ';
				i+=2;
				msg = new String(array);
			}
			if(msg ==null)
			{
				return "";
			}
			msg = msg.concat(getPreferenceCount().toString());
			return msg;
			
	}	
}
