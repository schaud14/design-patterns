package wordCount.util;


import wordCount.util.Logger.DebugLevel;

public class Logger {
	
	 public static enum DebugLevel {
	    	CONSTRUCTOR,
	    	THREADSRUN,
	    	ENTRYINRESULTS,
	    	STOREDS,
	    	PRINTNOTHING
	    };

	    private static DebugLevel debugLevel;


	    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		  case 3: debugLevel = DebugLevel.CONSTRUCTOR; break;
		  case 2: debugLevel = DebugLevel.ENTRYINRESULTS; break;
		  case 1: debugLevel = DebugLevel.STOREDS; break;
		  case 0: debugLevel = DebugLevel.PRINTNOTHING; break;
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
