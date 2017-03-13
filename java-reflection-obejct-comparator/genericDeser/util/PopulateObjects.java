package genericDeser.util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.Logger.DebugLevel;

/**
 * 
 * @author Saurabh Chaudhari
 *
 */
public class PopulateObjects {
	private FileProcessor fp;
	private Map firstObjects;
	private Map secondObjects;
	
	/**
	 * Constructor
	 * @param fileName
	 */
	public PopulateObjects(String fileName) 
	{
		Logger.writeMessage("Constructor: PopulateObjects", DebugLevel.CONSTRUCTOR);
		fp = new FileProcessor(fileName, true);
		firstObjects = new HashMap<First,Integer>();
		secondObjects = new HashMap<Second,Integer>();
	}
	/**
	 * Method to process objects from input file.
	 */
	public void populateDataStructure()
	{
		Class<?> javaClass = null;
		Object newObject = null;
		String line = null;
		while((line =fp.readInputLine())!= null)
		{
			/**
			 * If line contains FQN then create a new object.
			 */
			if(line.contains("fqn:"))
			{
				String className = line.split(":")[1];
				try 
				{
					if(newObject != null)
					{
						mapEntry(newObject);
						Logger.writeMessage("Entry added in Map", DebugLevel.ENTRYINMAP);
					}
					javaClass = Class.forName(className);
					
				} 
				catch (ClassNotFoundException e) 
				{
					System.err.println("Class Not Found Exception!");
					e.printStackTrace();
					System.exit(1);
				}
				try 
				{
					newObject = javaClass.newInstance();
				} 
				catch (InstantiationException | IllegalAccessException e) 
				{
					System.err.println("Exception in Object Creation!");
					e.printStackTrace();
					System.exit(1);
				}	
			}
			/**
			 * If a Line is parameter then add it to the existing object currently working on.
			 */
			else
			{
				Object[] paramObjects = new Object[1];
			    Class<?>[] signature = new Class<?>[1];
				String[] parameter = line.split(",");
				String type = parameter[0].replaceFirst("type=", "").trim();
				String var = parameter[1].replaceFirst("var=", "").trim();
				String value = parameter[2].replaceFirst("value=", "").trim();
				
				switch(type)
				{
					case "int":
					{
						signature[0] = Integer.TYPE;
						paramObjects[0] = new Integer(value);
						break;
					}
					case "float":
					{
						signature[0] = Float.TYPE;
						paramObjects[0] = new Float(value);
						break;
					}
					case "short":
					{
						signature[0] = Short.TYPE;
						paramObjects[0] = new Short(value);
						break;
					}
					case "String":
					{
						signature[0] = String.class;
						paramObjects[0] = new String(value);
						break;
					}
					case "double":
					{
						signature[0] = Double.TYPE;
						paramObjects[0] = new Double(value);
						break;
					}
					case "boolean":
					{
						signature[0] = Boolean.TYPE;
						paramObjects[0] = new Boolean(value);
						break;
					}
				}
				String methodName = "set" + var;
				Method method = null;
				try 
				{
					method = javaClass.getMethod(methodName, signature);
				} 
				catch (NoSuchMethodException | SecurityException e) 
				{
					System.err.println("No Such Method Exception!");
					e.printStackTrace();
					System.exit(1);
				}
				try 
				{
					Object result = method.invoke(newObject, paramObjects);
				} 
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
				{
					System.err.println("Exception in Method Invocation!");
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
		/**
		 * handle Last object
		 */
		mapEntry(newObject);
		Logger.writeMessage("Entry added in Map", DebugLevel.ENTRYINMAP);
	}
	
	/**
	 * Add Object to the respective map
	 * @param newObject
	 */
	private void mapEntry(Object newObject) {
		if(newObject instanceof First)
		{
			if(firstObjects.containsKey(newObject))
			{
				Integer count = (Integer) firstObjects.get(newObject);
				count++;
				firstObjects.put(newObject, count);
			}
			else
			{
				firstObjects.put(newObject, 1);
			}
		}
		else if(newObject instanceof Second)
		{
			if(secondObjects.containsKey(newObject))
			{
				Integer count = (Integer) secondObjects.get(newObject);
				count++;
				secondObjects.put(newObject, count);
			}
			else
			{
				secondObjects.put(newObject, 1);
			}
		}
	}
	
	/**
	 * Print result analysis for First objects
	 */
	public void printFirstOutput()
	{
		Integer uniqueObjects = 0;
		Integer totalObjects = 0;
		uniqueObjects = firstObjects.size();
		Iterator it = firstObjects.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			totalObjects += (Integer) pair.getValue();
		}
		Logger.writeMessage("Number of unique First objects: " + uniqueObjects, DebugLevel.PRINTOUTPUT);
		Logger.writeMessage("Total Number of First objects: "+ totalObjects, DebugLevel.PRINTOUTPUT);
	}
	/**
	 * Print result analysis for Second objects
	 */
	public void printSecondOutput()
	{
		Integer uniqueObjects = 0;
		Integer totalObjects = 0;
		uniqueObjects = secondObjects.size();
		Iterator it = secondObjects.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			totalObjects += (Integer) pair.getValue();
		}
		Logger.writeMessage("Number of unique Second objects: " + uniqueObjects, DebugLevel.PRINTOUTPUT);
		Logger.writeMessage("Total Number of Second objects: "+ totalObjects, DebugLevel.PRINTOUTPUT);
	}
}
