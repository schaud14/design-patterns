package genericDeser.driver;

import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;
/**
 * 
 * @author Saurabh Chaudhari
 *	
 *	Driver class with Main Method
 */
public class Driver {
	public static void main(String[] args) throws ClassNotFoundException
	{
		/**
		 * Check for 2 input parameters
		 * <input_file> <Logger_value>
		 */
		boolean input_flag = validateInput(args);
		if(!input_flag)
		{
			System.out.println("Invalid input parameters!");
			System.exit(1);
		}
				
		String inputFileName = args[0];
		Integer debug_value = Integer.parseInt(args[1]);
		Logger.setDebugValue(debug_value);
		
		try
		{
			/**
			 * Creating object store objects
			 */
			PopulateObjects pobjects = new PopulateObjects(inputFileName);
			/**
			 * Processing input file and populating data structure with objects
			 */
			pobjects.populateDataStructure();
			/**
			 * Print analysis about objects of First class
			 */
			pobjects.printFirstOutput();
			/**
			 * Print analysis about objects of Second class
			 */
			pobjects.printSecondOutput();
		}
		catch (Exception e)
		{
			System.err.println("Exception Found!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Method to validate the length of input parameters array
	 * @param args
	 * @return boolean
	 */
	private static boolean validateInput(String[] args) {
		if(args.length == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
