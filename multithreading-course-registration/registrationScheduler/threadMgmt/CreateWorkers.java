package registrationScheduler.threadMgmt;

import java.util.ArrayList;
import java.util.List;

import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Students;
import registrationScheduler.util.Logger.DebugLevel;
public class CreateWorkers {
	private FileProcessor fp;
	private Results result;
	private List<Students> studentList;
	
	/**
	 * Constructor
	 * @param fpIn
	 * @param resIn
	 * @param slistIn
	 */
	public CreateWorkers(FileProcessor fpIn,Results resIn,List<Students> slistIn)
	{
		fp = fpIn;
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
	 * Creates the workers threads.
	 * @param NUM_THREADS
	 */
	public void startWorkers(int NUM_THREADS)
	{
		try
		{
			Thread[] workers = new Thread[NUM_THREADS];
			for(int i =0; i<NUM_THREADS ;i++)
			{
				WorkerThread wt = new WorkerThread(this.getFp(),this.getResult(), this.getStudentList(),NUM_THREADS);
				Thread t = new Thread(wt);
				workers[i] = t;
				t.start();
			}
			
			for(int i = 0; i<NUM_THREADS; i++)
			{
				workers[i].join();
			}
		}
		catch(InterruptedException e)
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

