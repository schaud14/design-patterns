package registrationScheduler.threadMgmt;

import java.util.ArrayList;
import java.util.List;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Students;
import registrationScheduler.util.Logger.DebugLevel;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.Schedular;

public class WorkerThread implements Runnable {
	private FileProcessor fp;
	private Results result;
	private List<Students> studentList;
	static Integer tcount = 0;
	/**
	 * Constructor
	 * @param fpIn
	 * @param resIn
	 * @param slistIn
	 * @param NUM_THREADS
	 */
	public WorkerThread(FileProcessor fpIn, Results resIn,List<Students> slistIn, Integer NUM_THREADS)
	{
		fp =fpIn;
		result = resIn;
		studentList = slistIn;
		Logger.writeMessage("Constructor of Createworkers is called", DebugLevel.CONSTRUCTOR);
	}
	
	public FileProcessor getFp() {
		return fp;
	}
	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}
	public Results getResult() {
		return result;
	}
	public void setResult(Results result) {
		this.result = result;
	}
	public List<Students> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Students> studentList) {
		this.studentList = studentList;
	}
	
	/**
	 * Run method of worker thread
	 */
	public void run()
	{
		try {
			Logger.writeMessage("Run Method of Thread is called.", DebugLevel.THREADSRUN);
			String line = null;
			int iterator = 1;
			while((line = this.getFp().readInputLine()) != null)
			{
				Students newStudent;
					do{
						newStudent = new Students();
						newStudent.processEntry(line);
						studentList.add(newStudent);
						result.addEntry(line);
					}while (newStudent == null);
			}
			Schedular schedulearObj = new Schedular(studentList);
			while(iterator < 8 )
			{
				schedulearObj.allocateChoice(iterator, ObjectPool.getInstance(), result);
				iterator+=1;
			}
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
}