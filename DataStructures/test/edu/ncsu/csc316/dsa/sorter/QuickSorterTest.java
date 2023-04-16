package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Tests QuickSorter.java.
 * 
 * @author Will Greene
 */
public class QuickSorterTest {

	/**
	 * Tests QuickSorter.sort() with a NaturalOrder Comparator.
	 */
	@Test
	public void testSortStudentGeneral() {
		
		Student s1 = new Student( "Kendrick", "Lamar", 1, 15, 4.0, "kdot" );
		Student s2 = new Student( "Schoolboy", "Q", 2, 15, 4.0, "q" );
		Student s3 = new Student( "Jay", "Rock", 3, 15, 4.0, "rock" );
		Student s4 = new Student( "Ab", "Soul", 4, 15, 4.0, "SOUL" );
		Student s5 = new Student( "Isaiah", "Rashad", 5, 15, 4.0, "zay" );
		Student s6 = new Student( "SZA", "None", 6, 15, 4.0, "sizz" );
		
		Student[] tdeAscending = { s1, s6, s2, s5, s3, s4 };
		Student[] tdeDescending = { s4, s3, s5, s2, s6, s1 };
		Student[] tdeRandom = { s1, s2, s3, s4, s5, s6 };
		
		QuickSorter<Student> studentSorter = new QuickSorter<Student>( QuickSorter.FIRST_ELEMENT_SELECTOR );
		
		studentSorter.sort( tdeAscending );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s6, tdeAscending[ 1 ] );
		assertEquals( s2, tdeAscending[ 2 ] );
		assertEquals( s5, tdeAscending[ 3 ] );
		assertEquals( s3, tdeAscending[ 4 ] );
		assertEquals( s4, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeDescending );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s6, tdeAscending[ 1 ] );
		assertEquals( s2, tdeAscending[ 2 ] );
		assertEquals( s5, tdeAscending[ 3 ] );
		assertEquals( s3, tdeAscending[ 4 ] );
		assertEquals( s4, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeRandom );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s6, tdeAscending[ 1 ] );
		assertEquals( s2, tdeAscending[ 2 ] );
		assertEquals( s5, tdeAscending[ 3 ] );
		assertEquals( s3, tdeAscending[ 4 ] );
		assertEquals( s4, tdeAscending[ 5 ] );
	}
	
	/**
	 * Tests QuickSorter.sort() with a StudentGPAComparator Comparator.
	 */
	@Test
	public void testSortStudentGPA() {
		
		Student s1 = new Student( "Kendrick", "Lamar", 1, 15, 3.9, "kdot" );
		Student s2 = new Student( "Schoolboy", "Q", 2, 15, 3.8, "q" );
		Student s3 = new Student( "Jay", "Rock", 3, 15, 4.0, "rock" );
		Student s4 = new Student( "Ab", "Soul", 4, 15, 3.6, "SOUL" );
		Student s5 = new Student( "Isaiah", "Rashad", 5, 15, 3.5, "zay" );
		Student s6 = new Student( "SZA", "None", 6, 15, 3.7, "sizz" );
		
		Student[] tdeAscending = { s5, s4, s6, s2, s1, s3 };
		Student[] tdeDescending = { s3, s1, s2, s6, s4, s5 };
		Student[] tdeRandom = { s1, s2, s3, s4, s5, s6 };
		
		StudentGPAComparator comparator = new StudentGPAComparator();
		QuickSorter<Student> studentSorter = new QuickSorter<Student>( comparator, QuickSorter.MIDDLE_ELEMENT_SELECTOR );
		
		studentSorter.sort( tdeAscending );
		
		assertEquals( s3, tdeAscending[ 0 ] );
		assertEquals( s1, tdeAscending[ 1 ] );
		assertEquals( s2, tdeAscending[ 2 ] );
		assertEquals( s6, tdeAscending[ 3 ] );
		assertEquals( s4, tdeAscending[ 4 ] );
		assertEquals( s5, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeDescending );
		
		assertEquals( s3, tdeAscending[ 0 ] );
		assertEquals( s1, tdeAscending[ 1 ] );
		assertEquals( s2, tdeAscending[ 2 ] );
		assertEquals( s6, tdeAscending[ 3 ] );
		assertEquals( s4, tdeAscending[ 4 ] );
		assertEquals( s5, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeRandom );
		
		assertEquals( s3, tdeAscending[ 0 ] );
		assertEquals( s1, tdeAscending[ 1 ] );
		assertEquals( s2, tdeAscending[ 2 ] );
		assertEquals( s6, tdeAscending[ 3 ] );
		assertEquals( s4, tdeAscending[ 4 ] );
		assertEquals( s5, tdeAscending[ 5 ] );
	}
	
	/**
	 * Tests QuickSorter.sort() with a StudentIDComparator Comparator.
	 */
	@Test
	public void testSortStudentID() {
		
		Student s1 = new Student( "Kendrick", "Lamar", 1, 15, 4.0, "kdot" );
		Student s2 = new Student( "Schoolboy", "Q", 2, 15, 4.0, "q" );
		Student s3 = new Student( "Jay", "Rock", 3, 15, 4.0, "rock" );
		Student s4 = new Student( "Ab", "Soul", 4, 15, 4.0, "SOUL" );
		Student s5 = new Student( "Isaiah", "Rashad", 5, 15, 4.0, "zay" );
		Student s6 = new Student( "SZA", "None", 6, 15, 4.0, "sizz" );
		
		Student[] tdeAscending = { s1, s2, s3, s4, s5, s6 };
		Student[] tdeDescending = { s6, s5, s4, s3, s2, s1 };
		Student[] tdeRandom = { s5, s4, s6, s2, s1, s3 };
		
		StudentIDComparator comparator = new StudentIDComparator();
		QuickSorter<Student> studentSorter = new QuickSorter<Student>( comparator, QuickSorter.LAST_ELEMENT_SELECTOR );
		
		studentSorter.sort( tdeAscending );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s2, tdeAscending[ 1 ] );
		assertEquals( s3, tdeAscending[ 2 ] );
		assertEquals( s4, tdeAscending[ 3 ] );
		assertEquals( s5, tdeAscending[ 4 ] );
		assertEquals( s6, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeDescending );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s2, tdeAscending[ 1 ] );
		assertEquals( s3, tdeAscending[ 2 ] );
		assertEquals( s4, tdeAscending[ 3 ] );
		assertEquals( s5, tdeAscending[ 4 ] );
		assertEquals( s6, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeRandom );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s2, tdeAscending[ 1 ] );
		assertEquals( s3, tdeAscending[ 2 ] );
		assertEquals( s4, tdeAscending[ 3 ] );
		assertEquals( s5, tdeAscending[ 4 ] );
		assertEquals( s6, tdeAscending[ 5 ] );
	}
	
	/**
	 * Tests QuickSorter.sort() with a StudentIDComparator Comparator and a RandomElementSelector.
	 */
	@Test
	public void testSortStudentID2() {
		
		Student s1 = new Student( "Kendrick", "Lamar", 1, 15, 4.0, "kdot" );
		Student s2 = new Student( "Schoolboy", "Q", 2, 15, 4.0, "q" );
		Student s3 = new Student( "Jay", "Rock", 3, 15, 4.0, "rock" );
		Student s4 = new Student( "Ab", "Soul", 4, 15, 4.0, "SOUL" );
		Student s5 = new Student( "Isaiah", "Rashad", 5, 15, 4.0, "zay" );
		Student s6 = new Student( "SZA", "None", 6, 15, 4.0, "sizz" );
		
		Student[] tdeAscending = { s1, s2, s3, s4, s5, s6 };
		Student[] tdeDescending = { s6, s5, s4, s3, s2, s1 };
		Student[] tdeRandom = { s5, s4, s6, s2, s1, s3 };
		
		StudentIDComparator comparator = new StudentIDComparator();
		QuickSorter<Student> studentSorter = new QuickSorter<Student>( comparator );
		
		studentSorter.sort( tdeAscending );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s2, tdeAscending[ 1 ] );
		assertEquals( s3, tdeAscending[ 2 ] );
		assertEquals( s4, tdeAscending[ 3 ] );
		assertEquals( s5, tdeAscending[ 4 ] );
		assertEquals( s6, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeDescending );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s2, tdeAscending[ 1 ] );
		assertEquals( s3, tdeAscending[ 2 ] );
		assertEquals( s4, tdeAscending[ 3 ] );
		assertEquals( s5, tdeAscending[ 4 ] );
		assertEquals( s6, tdeAscending[ 5 ] );
		
		studentSorter.sort( tdeRandom );
		
		assertEquals( s1, tdeAscending[ 0 ] );
		assertEquals( s2, tdeAscending[ 1 ] );
		assertEquals( s3, tdeAscending[ 2 ] );
		assertEquals( s4, tdeAscending[ 3 ] );
		assertEquals( s5, tdeAscending[ 4 ] );
		assertEquals( s6, tdeAscending[ 5 ] );
	}
}
