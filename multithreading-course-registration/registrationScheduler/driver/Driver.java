package registrationScheduler.driver;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Students;

public class Driver {
	public static int NUM_THREADS,DEBUG_VALUE,MAX_SEATS,MAX_COURSES;
	/**
	 * Initializes validates and processes the results.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception
	{
		FileProcessor fpinput = null;
		FileProcessor fpoutput = null;
		List<Students> studentList = Collections.synchronizedList(new ArrayList<Students>()); 
		String inputFile = null;
		String outputFile = null;
		try
		{
				if(registrationScheduler.util.InputValidator.validate(args) == 1)
				{
					inputFile = args[0];
					outputFile = args[1];
					NUM_THREADS = Integer.parseInt(args[2]);
					DEBUG_VALUE = Integer.parseInt(args[3]);
					Logger.setDebugValue(DEBUG_VALUE);
				}
				fpinput = new FileProcessor(inputFile,true);
				fpoutput = new FileProcessor(outputFile,false);
				Results result = new Results(fpoutput);
				CreateWorkers workers = new CreateWorkers(fpinput,result,studentList);
				workers.startWorkers(NUM_THREADS);
			
				result.writeSchedulesToScreen();
				result.writeSchedulesToFile();
		}
		catch(NullPointerException e)
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
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			fpinput.closeInFiles();
			fpoutput.closeOutFiles();
		}
	}
}
