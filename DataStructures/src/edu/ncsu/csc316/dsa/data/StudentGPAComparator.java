package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA. // added a period + blank line
 * 
 * @author Dr. King
 * @author Will Greene
 */
public class StudentGPAComparator implements Comparator<Student> {

	/**
	 * Compares students based on GPA in descending order.
	 * 
	 * @param one Student one
	 * @param two Student two
	 * @return negative if Student one belongs before Student two,
	 * 		   positive if Student one belongs after Student two
	 */
	@Override
	public int compare(Student one, Student two) {
						
		if ( one.getGpa() - two.getGpa() > 0 )
			return -1;
		
		else if ( one.getGpa() - two.getGpa() < 0 )
			return 1;
		
		return one.compareTo(two);
	}
}
