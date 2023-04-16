package edu.ncsu.csc316.dsa.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import edu.ncsu.csc316.dsa.data.Student;

/**
 * StudentReader processes input CSV files that contain
 * student information.
 * 
 * Input CSV files should be in the following format:
 * 
 *    FIRST_NAME,LAST_NAME,UNITY_ID,STUDENT_ID,GPA,CREDIT_HOURS
 * 
 * @author Dr. King
 *
 */
public class StudentReader {

	/**
	 * Returns the input CSV file as an array of Student objects. // added a period + blank line
	 * 
	 * @param filePath - the path to the input CSV file
	 * @return an array of Student objects
	 */
	public static Student[] readInputAsArray(String filePath)
	{
		Student[] list = new Student[10];
		try(Scanner scan = new Scanner(new FileInputStream(filePath), "UTF8"))
		{
			scan.nextLine(); // SKIP HEADER LINE
			int index = 0;
			while(scan.hasNextLine())
			{
				if(index >= list.length)
				{
					list = Arrays.copyOf(list, list.length * 2 + 1);
				}
				list[index] = processLine(scan.nextLine());
				index++;
			}
			list = Arrays.copyOf(list, index);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found: " + e.getMessage());
		}
		return list;
	}

	/**
	 * Processes a single line from the input file to construct a Student. // added a blank line
	 * 
	 * @param line - the input line from the input file
	 * @return a Student representation of the input line
	 */
	private static Student processLine(String line) {
				
		Scanner s = new Scanner( line );
		s.useDelimiter( "," );
		
		String first = s.next();
		String last = s.next();
		String unityID = s.next();
		int id = s.nextInt();
		double gpa = s.nextDouble();
		int creditHours = s.nextInt();
		
		s.close();
		
		return new Student( first, last, id, creditHours, gpa, unityID );
	}
}
