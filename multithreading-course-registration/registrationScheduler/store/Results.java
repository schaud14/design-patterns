package registrationScheduler.store;

import registrationScheduler.util.Courses;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Students;
import registrationScheduler.util.Logger.DebugLevel;
import java.util.ArrayList;
import registrationScheduler.util.Allocations;
import registrationScheduler.util.FileProcessor;
import java.util.List;


public class Results implements StdoutDisplayInterface,FileDisplayInterface {
	private  ArrayList<Allocations> finalResult;
	private FileProcessor fp;

	/**
	 * Constructor
	 * @param fpIn
	 */
	public Results(FileProcessor fpIn){
		Logger.writeMessage("Constructor of Result Class is called", DebugLevel.CONSTRUCTOR);
		this.finalResult = new ArrayList<Allocations>();
		for (int i = 0; i < 80; i++) {
			Allocations temp = new Allocations();
  			finalResult.add(temp);
		}
		fp = fpIn;
	}
	
	/**
	 * updates allocated courses to the result data structure
	 * @param studentList
	 * @param student
	 * @param course
	 * @param prefCount
	 */
	public synchronized void updateResult(List<Students> studentList,Students student, Courses course, int prefCount)
	{
		try {
			
			ArrayList<Allocations> tempResult = getFinalResult();
			Allocations temp = finalResult.get(student.getNumber()-1);
			temp.setName(student.getName());
			temp.setNum(student.getNumber());
			temp = temp.updateEntry(course.getCourseID(),prefCount);
			if(temp.isUpdated > 0) {
				course.setStudenCount(course.getStudenCount()+1);
				student.setAssignCounter(student.getAssignCounter() + 1);
			}
			tempResult.remove(student.getNumber()-1);
			tempResult.add(student.getNumber()-1, temp);
			this.setFinalResult(tempResult);
			Logger.writeMessage("Entry Added to Result Data structure", DebugLevel.ENTRYINRESULTS);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			
		}
	}
	
	public ArrayList<Allocations> getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(ArrayList<Allocations> finalResultIn) {
		finalResult = finalResultIn;
	}
	
	/**
	 * implemented interface for writing output to file.
	 */
	@Override
	public void writeSchedulesToFile() {
		try
		{
			Double avg_prefCount = new Double(0);
			//for(Allocations allocation: finalResult)
			for(int i=0; i<80; i++)
			{
				String message = null;
				Allocations allocation = finalResult.get(i);
				message = "Student_".concat(allocation.getNum().toString().concat(" ").concat(allocation.displayMap()));
				fp.writetofile(message);
				avg_prefCount = avg_prefCount.doubleValue() + allocation.getPreferenceCount();
			}
			avg_prefCount = avg_prefCount/80;
			String msg2 = "Average preference_score is: ".concat((avg_prefCount).toString());
			fp.writetofile(msg2);
		}
		catch(NullPointerException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			
		}
	}
	
	/**
	 * implemented interface for writing output to screen.
	 */
	@Override
	public void writeSchedulesToScreen() {
		Double avg_prefCount = new Double(0);
		String message =  null;
		//for(Allocations allocation: finalResult)
		for(int i=0; i<80; i++)
		{
			Allocations allocation = finalResult.get(i);
			message = "Student_".concat(allocation.getNum().toString().concat(" ").concat(allocation.displayMap()));
			Logger.writeMessage(message, DebugLevel.STOREDS);
			avg_prefCount = avg_prefCount.doubleValue() + allocation.getPreferenceCount();
		}
		avg_prefCount = avg_prefCount/80;
		String msg2 = "Average preference_score is: ".concat((avg_prefCount).toString());
		Logger.writeMessage(msg2, DebugLevel.STOREDS);
		Logger.writeMessage(msg2, DebugLevel.PRINTNOTHING);
	}
	
	/**
	 * add the student entry to the result data structure
	 * @param line
	 */
	public synchronized void addEntry(java.lang.String line) {
		try 
		{
			String [] lineSplit = line.split(" ");
			String [] lineSplit1 = lineSplit[0].split("_");
			Allocations obj = new Allocations();
			obj.setName(lineSplit[0]);
			obj.setNum(Integer.parseInt(lineSplit1[1]));
			finalResult.add(Integer.parseInt(lineSplit1[1])-1,obj);
		} 
		catch (NumberFormatException e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch(NullPointerException e)
		{
			System.out.println("Exception Caught");
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Exception Caught");
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch(Exception e)
		{
			System.out.println("Exception Caught");
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
	}
	

}
