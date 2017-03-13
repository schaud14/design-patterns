//package binghamton.com.edu;
/**
 * @author Saurabh Chaudhari
 * Driver Class of the code containing Main method,
 * which includes file processing.
 * Course allocation is done by separate methods.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver 
{
	/**
	 * @param args <inputFile> <outputFile>
	 * 
	 */
	public static void main(String args []) 
	{
		try
		{
			String inputFile = args[0];
			String outputFile = args[1];
			if(args.length != 2)
			{
				System.out.println("Please Enter correct arguments to the Program");
				System.exit(1);
			}
			String inputLine = null;
			int count = 0;
			Students[] studentList = new Students[12];
			Courses[] courseList = new Courses[4];
			for (int i=0; i<4;i++)
			{
				courseList[i] = new Courses();
			}
			BufferedReader inputfromFile = new BufferedReader(new FileReader(inputFile));
			while((inputLine = inputfromFile.readLine())!= null)
			{
				studentList[count] = new Students();
				String[] SplitInputLine = inputLine.split(" ");
				studentList[count].setCoursePref1(Integer.parseInt(SplitInputLine[1]));
				studentList[count].setCoursePref2(Integer.parseInt(SplitInputLine[2]));
				studentList[count].setCoursePref3(Integer.parseInt(SplitInputLine[3]));
				studentList[count].setCoursePref4(Integer.parseInt(SplitInputLine[4]));
				count++;
			}
			inputfromFile.close();
			allocateFirstChoice(studentList, courseList);
			allocateSecondChoice(studentList, courseList);
			allocateThirdChoice(studentList, courseList);
			allocateFourthChoice(studentList, courseList);
			printOutput(studentList,outputFile);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please Enter the arguments");
			e.printStackTrace();
			System.exit(1);
		}
		catch(NullPointerException e)
		{
			System.out.println("input File not correct");
			e.printStackTrace();
			System.exit(1);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Input File Not found : Program Exited");
			e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println("Exception Occurred");
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	/**
	 * Method for allcocating the first preference for all students
	 * @param studentList
	 * @param CourseList
	 */
	public static void allocateFirstChoice(Students[] studentList,Courses[] CourseList)
	{
		for(Students student:studentList)
		{
			int pref = student.getCoursePref(student.getChoice()+1);
			if(CourseList[pref-1].getStudentCount() < 10 && student.getAssignCounter() < 3)
			{
				student.courseAssigned[student.assignCounter]=pref;
				CourseList[pref-1].setStudentCount(CourseList[pref-1].getStudentCount() + 1);
				student.setAssignCounter(student.getAssignCounter() + 1);
				student.setPreferenceCount(student.getPreferenceCount() + student.getChoice() + 1);
			}
			/**
			 * If first preference is full then next preference is considered in same iteration.
			 */
			else
			{
				pref = student.getCoursePref(student.getChoice()+2);
				if(CourseList[pref-1].getStudentCount() < 10 && student.getAssignCounter() < 3)
				{
					student.courseAssigned[student.assignCounter]=pref;
					CourseList[pref-1].setStudentCount(CourseList[pref-1].getStudentCount() + 1);
					student.setAssignCounter(student.getAssignCounter() + 1);
					student.setPreferenceCount(student.getPreferenceCount() + student.getChoice() + 2);
					student.setChoice(student.getChoice()+1);
				}
			}
		}
	}
	/**
	 * Method for allcocating the second preference for all students
	 * @param studentList
	 * @param CourseList
	 */
	public static void allocateSecondChoice(Students[] studentList,Courses[] CourseList)
	{
		for(Students student:studentList)
		{
			int pref = student.getCoursePref(student.getChoice()+2);
			if(CourseList[pref-1].StudentCount < 10 && student.assignCounter < 3)
			{
				student.courseAssigned[student.assignCounter]=pref;
				CourseList[pref-1].setStudentCount(CourseList[pref-1].getStudentCount() + 1);
				student.setAssignCounter(student.getAssignCounter() + 1);
				student.setPreferenceCount(student.getPreferenceCount() + student.getChoice() + 2);
			}
			/**
			 * If second preference is full then next preference is considered in same iteration.
			 */
			else
			{
				pref = student.getCoursePref(student.getChoice()+3);
				if(CourseList[pref-1].StudentCount < 10 && student.assignCounter < 3)
				{
					student.courseAssigned[student.assignCounter]=pref;
					CourseList[pref-1].setStudentCount(CourseList[pref-1].getStudentCount() + 1);
					student.setAssignCounter(student.getAssignCounter() + 1);
					student.setPreferenceCount(student.getPreferenceCount() + student.getChoice() + 3);
					student.setChoice(student.getChoice()+1);
				}
			}
		}
	}
	/**
	 * Method for allcocating the Third preference for all students
	 * @param studentList
	 * @param CourseList
	 */
	public static void allocateThirdChoice(Students[] studentList,Courses[] CourseList)
	{
		for(Students student:studentList)
		{
			int pref = student.getCoursePref(student.getChoice()+3);
			if(CourseList[pref-1].StudentCount < 10 && student.assignCounter < 3)
			{
				student.courseAssigned[student.assignCounter]=pref;
				CourseList[pref-1].setStudentCount(CourseList[pref-1].getStudentCount() + 1);
				student.setAssignCounter(student.getAssignCounter() + 1);
				student.setPreferenceCount(student.getPreferenceCount() + student.getChoice() + 3);
			}
			/**
			 * If third preference is full then next preference is considered in same iteration.
			 */
			else
			{
				if(student.getChoice() < 4)
				{
					pref = student.getCoursePref(4);
					if(CourseList[pref-1].StudentCount < 10 && student.assignCounter < 3)
					{
						student.courseAssigned[student.assignCounter]=pref;
						CourseList[pref-1].setStudentCount(CourseList[pref-1].getStudentCount() + 1);
						student.setAssignCounter(student.getAssignCounter() + 1);
						student.setPreferenceCount(student.getPreferenceCount() + 4);
					}
				}
		
			}
	
		}
	}
		
	/**
	 * Method for allcocating the fourth preference for all students(if required)
	 * @param studentList
	 * @param CourseList
	 */
	public static void allocateFourthChoice(Students[] studentList,Courses[] CourseList)
	{
		for(Students student:studentList)
		{
			if(student.getChoice() < 4)
			{
				int pref = student.getCoursePref(4);
				if(CourseList[pref-1].StudentCount < 10 && student.assignCounter < 3)
				{
					student.courseAssigned[student.assignCounter]=pref;
					CourseList[pref-1].setStudentCount(CourseList[pref-1].getStudentCount() + 1);
					student.setAssignCounter(student.getAssignCounter() + 1);
					student.setPreferenceCount(student.getPreferenceCount() + 4);
				}
			}
		}
	}
	/**
	 * 
	 * Method prints the output to the output file
	 * @param studentList
	 */
	public static void printOutput(Students [] studentList, String outputFile)
	{
			try 
			{
				/**
				 * Filewriter for the saving output to external file
				 */
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
				Integer avgPref=0;
				for (int i = 0; i<studentList.length; i++)
				{
					bufferedWriter.write("Student_" + (i+1) + " " + (char)((studentList[i].courseAssigned[0])+64)+" "+(char)((studentList[i].courseAssigned[1])+64)+" "+(char)((studentList[i].courseAssigned[2])+64) +" " + studentList[i].getPreferenceCount() +"\n");
					avgPref = avgPref + studentList[i].preferenceCount;
				}
				Double avgPref1 =  ((double)(avgPref)/(studentList.length));
				bufferedWriter.write("Average preference_score is: " + avgPref1.toString());
				bufferedWriter.close();

			}
			catch(NullPointerException e)
			{
				System.out.println("Null pointer Exception Occured: program exited");
				e.printStackTrace();
				System.exit(1);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File Not Found Exception: program exited");
				e.printStackTrace();
				System.exit(1);
			}
			catch (IOException e) 
			{
				System.out.println("Exception Occured:Program exited.");
				e.printStackTrace();
			}
	}
}

