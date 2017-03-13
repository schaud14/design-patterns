package registrationScheduler.util;

public class InputValidator {
	/**
	 * validated the input arguments as per the program requirement
	 * @param args
	 * @return
	 */
	public static int validate(String[] args)
	{	
		try
		{
			if(args.length == 4)
			{
				int numOfThreads = Integer.parseInt(args[2]); 
				int debugval = Integer.parseInt(args[3]);
				if (numOfThreads > 0 && numOfThreads < 4)
				{
					if (debugval >= 0 && debugval < 5)
					{
						return 1;
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch (NullPointerException e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
		return 0;
		
	}
	
}
