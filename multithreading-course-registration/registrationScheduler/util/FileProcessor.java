package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import registrationScheduler.util.Logger.DebugLevel;

public class FileProcessor {
	private FileInputStream input_stream;
	private BufferedReader input_reader;
	private BufferedWriter output_writer;
	/**
	 * Constructor
	 * @param filename
	 * @param mode
	 */
	public FileProcessor(String filename,boolean mode) 
	{
		Logger.writeMessage("Constructor of File Processor is called", DebugLevel.CONSTRUCTOR);

		if(mode)
		{
			try 
			{
				input_stream = new FileInputStream(filename);
				input_reader = new BufferedReader(new InputStreamReader(input_stream));
			}
			catch(NullPointerException e)
			{
				System.out.println("Exception Caught");
				e.printStackTrace();
				System.exit(1);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Exception Caught");
				e.printStackTrace();
				System.exit(1);
			}
			catch(Exception e)
			{
				System.out.println("Exception Caught");
				e.printStackTrace();
				System.exit(1);
			}
			finally {
				
			}
		}
		else
		{
			try
			{
				File file = new File(filename);
				if(!file.exists())
				{
					file.createNewFile();
				} 
				
					output_writer = new BufferedWriter(new FileWriter(file));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Exception Caught");
				e.printStackTrace();
				System.exit(1);
			}
			catch(NullPointerException e)
			{
				System.out.println("Exception Caught");
				e.printStackTrace();
				System.exit(1);
			}
			catch(Exception e)
			{
				System.out.println("Exception Caught");
				e.printStackTrace();
				System.exit(1);
			}
			finally {
				
			}
		}
	}
	
	/**
	 * Reads next input Line
	 * @return
	 */
	public synchronized String readInputLine()
	{
		try
		{
			String line = input_reader.readLine();
			return line;
		}
		catch(NullPointerException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
		return "Exception Found";
		
	}

	public synchronized void writetofile(String line)
	{
		try 
		{
			output_writer.write(line);
			output_writer.write("\r\n");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch(NullPointerException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally {
			
		}
		
	}
	/**
	 * Close the input file
	 */
	public void closeInFiles()
	{
		try {
			input_reader.close();
		} 
		catch(NullPointerException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);		
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
	}
	/**
	 * close the output file
	 */
	public void closeOutFiles()
	{
		try {
			output_writer.close();
		} 
		catch(NullPointerException e)
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e) 
		{
			System.out.println("Exception Caught");
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
		
	}

}
