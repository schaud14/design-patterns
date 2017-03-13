package registrationScheduler.util;

public class Logger {
	
	 public static enum DebugLevel {
	    	CONSTRUCTOR,
	    	THREADSRUN,
	    	ENTRYINRESULTS,
	    	STOREDS,
	    	PRINTNOTHING
	    };

	    private static DebugLevel debugLevel;
	    /**
	     * Sets the debug Value
	     * @param levelIn
	     */
	    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
		  case 3: debugLevel = DebugLevel.THREADSRUN; break;
		  case 2: debugLevel = DebugLevel.ENTRYINRESULTS; break;
		  case 1: debugLevel = DebugLevel.STOREDS; break;
		  case 0: debugLevel = DebugLevel.PRINTNOTHING; break;
		}
	    }
	    public static void setDebugValue (DebugLevel levelIn) {
	    	debugLevel = levelIn;
	        }
	    
	    /**
	     * writes line to screen
	     * @param message
	     * @param levelIn
	     */
	    public static void writeMessage (String message, DebugLevel levelIn ) {
	    	if (levelIn == debugLevel)
	    		System.out.println(message);
	    	}

		public String toString() {
		return "Debug Level is " + debugLevel;
		}
	
}
