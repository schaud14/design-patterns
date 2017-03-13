package wordCount.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import wordCount.dsForStrings.BinarySearchTree;
import wordCount.dsForStrings.TreeInterface;
import wordCount.util.FileProcessor;
import wordCount.visitors.BackupCreatingVisitor;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.PrintVisitor;
import wordCount.visitors.UpdateVisitor;
import wordCount.visitors.WordCountVisitor;

/**
 * <p>
 * This class contains the main method.
 * </p>
 * @author Saurabh Chaudhari
 */

public class Driver {
	/**
	 * This is main method.
	 * @param args
	 * 			Command line arguments
	 */
	public static void main(String args [])
	{
		try
		{
			if(!(validateArgumnts(args)))
			{	
				System.exit(1);
			}
				String input_file = args[0];
				String output_file = args[1];
				int iterations = Integer.parseInt(args[2]);
				TreeInterface originalBst = null;
				long startTime = System.currentTimeMillis();
				for(int i=0;i<iterations;i++)
				{
					/**
					 * Loop for performance Testing.
					 */
					FileProcessor fpInput = new FileProcessor(input_file, true);
					originalBst = new BinarySearchTree();
					/**
					 * populating the original tree
					 */
					DSProcessingVisitorI pVisitor = new PopulateVisitor(fpInput);
					originalBst.accept(pVisitor);
					
					/**
					 * traversing the original tree to get word count.
					 */
					FileProcessor fpOutput = new FileProcessor(output_file, false);
					DSProcessingVisitorI wcVisitor = new WordCountVisitor(fpOutput);
					originalBst.accept(wcVisitor);
					fpOutput.closeFile();
				}
				long finishTime = System.currentTimeMillis();
				long total_time  = (finishTime-startTime)/iterations;
				System.out.println("TIME: "+ total_time);
				/**
				 * Creating a Backup tree
				 */
				TreeInterface backupBst = new BinarySearchTree();
				DSProcessingVisitorI bcVisitor = new BackupCreatingVisitor(originalBst);
				backupBst.accept(bcVisitor);
				/**
				 * Updating original tree
				 * 			Update count of each node by 1
				 */
				DSProcessingVisitorI uVisitor = new UpdateVisitor();
				originalBst.accept(uVisitor);
				/**
				 * Writing updated data of original tree to file
				 */
				FileProcessor fpOrg = new FileProcessor("original_tree_updated.txt", false);
				DSProcessingVisitorI prVisitorOrg = new PrintVisitor(fpOrg);
				originalBst.accept(prVisitorOrg);
				fpOrg.closeFile();
				/**
				 * Writing updated data of backup tree to file
				 */
				FileProcessor fpBkp = new FileProcessor("backup_tree_updated.txt", false);
				DSProcessingVisitorI prVisitorBK = new PrintVisitor(fpBkp);
				backupBst.accept(prVisitorBK);
				fpBkp.closeFile();
		}
		catch (Exception e) 
		{
			
		}
	}
	/**
	 * 
	 * This method validates the command line arguments. It performs following
	 * validations:
	 * 1. Checks if number of arguments provided is valid.</li>
	 * 2. checks whether the given filename is valid i.e. if a stream can be
	 * 	  created of the file with given filename.</li>
	 * 3. Verifies if an output file can be created.</li>
	 * 4. Validates if 'Number of Iterations' is of type integer.</li>
	 * 
	 * @param args
	 *            command line arguments.
	 * @return true if all arguments are valid otherwise throws an error to
	 *         standard output and exits the application.
	 */
	private static boolean validateArgumnts(String[] args) {
		//return lengthCheck(args,3);
		return lengthCheck(args, 3) && validateFileName(args[0]) && validateFileExists(args[1]) && formatCheck(args[2]);
	}
	/**
	 * <p>
	 * This method validates if a given argument can be casted to an Integer
	 * Value.
	 * </p>
	 * 
	 * @param numIterations
	 *            argument to be validated.
	 * @return true if the input argument is in valid format, otherwise exits
	 *         the application.
	 */
	private static boolean formatCheck(String numIterations) {
		try {
			Integer.parseInt(numIterations);
		} catch (NumberFormatException exception) {
			System.err.println("Please enter an argument in valid format." + exception);
			exception.printStackTrace();
			System.exit(1);
		}
		return true;
	}

	/**
	 * <p>
	 * This method validates if an argument is a valid file name.
	 * </p>
	 * 
	 * @param fileName
	 *            argument to be validated.
	 * @return true if the input argument is in valid, otherwise exits the
	 *         application.
	 */
	private static boolean validateFileName(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.canRead()) {
			try {
				new FileInputStream(file);
			} catch (IOException exception) {
				System.err.println("File Stream could not be created. ");
				exception.printStackTrace();
				System.exit(1);
			}
		} else {
			System.err.println("Please provide a valid file.");
			System.exit(1);
		}
		return true;
	}

	/**
	 * <p>
	 * This method validates if the value of an argument has expected length.
	 * </p>
	 * 
	 * @param arg
	 *            argument to be checked for range.
	 * @param expected
	 *            expected length.
	 * @return true if the input argument lies within the specified range,
	 *         otherwise exists the application.
	 */
	private static boolean lengthCheck(String[] args, int expected) {
		if (args.length != expected) {
			System.err.println("Please enter valid number of arguments.");
			System.exit(1);
		}
		return true;
	}

	/**
	 * <p>
	 * This method validates if a file already exists. If file already exists,
	 * this method will delete the existing file and create a new one.
	 * </p>
	 * 
	 * @param fileName
	 *            name of the file to validate.
	 * @returns true if no error occurs while deleting or creating a new
	 *          file,otherwise exists the application.
	 */
	private static boolean validateFileExists(String fileName) {
		File file = new File(fileName);
		try {
			if (file.delete()) {
				file.createNewFile();
			}
		} catch (IOException exception) {
			System.err.println("Error While creating an output file " + exception);
			exception.printStackTrace();
			System.exit(1);
		}
		return true;
	}
}

