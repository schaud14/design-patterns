package genericDeser.util;
/**
 * 
 * @author Saurabh Chaudhari
 *
 */
public class Logger {
	
	 public static enum DebugLevel {
		 	CONSTRUCTOR,
	    	ENTRYINMAP,
	    	PRINTOUTPUT
	    };

	    private static DebugLevel debugLevel;


	    public static void setDebugValue (int levelIn) {
		switch (levelIn) 
		{
			case 2: debugLevel = DebugLevel.ENTRYINMAP; break;
			case 1: debugLevel = DebugLevel.CONSTRUCTOR; break;
			case 0: debugLevel = DebugLevel.PRINTOUTPUT; break;
		}
	    }
	    public static void setDebugValue (DebugLevel levelIn) {
	    	debugLevel = levelIn;
	        }
	    public static void writeMessage (String message, DebugLevel levelIn ) {
	    	if (levelIn == debugLevel)
	    		System.out.println(message);
	    	}

		public String toString() {
		return "Debug Level is " + debugLevel;
		}
	
}
