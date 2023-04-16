package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator to compare students based on id number. // added a period + blank line
 * 
 * @author Dr. King
 * @author Will Greene
 */
public class StudentIDComparator implements Comparator<Student> {

	/**
	 * Compares students based on id number in ascending order. // added a period
	 * 
	 * @param one Student one
	 * @param two Student two
	 * @return negative if Student one belongs before Student two,
	 * 		   positive if Student one belongs after Student two
	 */
	@Override
	public int compare(Student one, Student two) {		
		return one.getId() - two.getId();
	}
}
