package wordCount.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import wordCount.util.Logger.DebugLevel;

public class FileProcessor {
	private static FileInputStream input_stream;
	private static BufferedReader input_reader;
	private static BufferedWriter output_writer;
	public FileProcessor(String filename,boolean mode) 
	{
		if(mode)
		{
			try
			{
				input_stream = new FileInputStream(filename);
			}
			catch(FileNotFoundException e)
			{
				System.err.println(e.toString());
				System.exit(1);
			}
			catch (Exception e) {
				System.err.println(e.toString());
				System.exit(1);
			}
			try 
			{
				input_reader = new BufferedReader(new InputStreamReader(input_stream));
			}
			catch(Exception e)
			{
				System.err.println(e.toString());
				System.exit(1);
			}
		}
		else
		{
			File yourFile = new File(filename);
			if(!yourFile.exists()) {
			    try {
					yourFile.createNewFile();
				} 
			    catch (IOException e) 
			    {
					
					System.out.println(e.toString());
					System.exit(1);
				}
			} 
			try 
			{
				output_writer = new BufferedWriter(new FileWriter(yourFile));
			}
			catch(FileNotFoundException e)
			{
				System.err.println(e.toString());
				System.exit(1);
			}
			catch(Exception e)
			{
				System.err.println(e.toString());
				System.exit(1);
			}
		}
		Logger.writeMessage("Inside FileProcessor Contructor", DebugLevel.CONSTRUCTOR);
	}
	public String readInputLine()
	{
		String line = "";
		try
		{
			line = input_reader.readLine();
			return line;
		}
		catch(Exception e)
		{
			System.err.println(e.toString());
			System.exit(1);
		}
		return line;
		
	}
    public void writeToFile(String line) {
		try {
			output_writer.write(line);
			output_writer.write("\r\n");
			} 
		catch (Exception e) 
		{
			System.out.println(e.toString());
			System.exit(1);
		}
	}
    public void closeFile() 
	{
		try 
		{
			input_reader.close();
			output_writer.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e.toString());
		}
	}
}
