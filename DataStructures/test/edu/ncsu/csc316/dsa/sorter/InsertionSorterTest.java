package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Tests InsertionSorter.java.
 * 
 * @author Will Greene
 */
public class InsertionSorterTest /* <E extends Comparable<E>> */ {

	/** array of ascending Integers */
	private Integer[] /* int */ dataAscending = { 1, 2, 3, 4, 5 };
	
	/** array of descending Integers */
	private Integer[] /* int */ dataDescending = { 5, 4, 3, 2, 1 };
	
	/** array of random Integers */
	private Integer[] /* int */ dataRandom = { 4, 1, 5, 3, 2 };
	
	/** InsertionSorter instance */
	private InsertionSorter <Integer> /* <E> */ integerSorter;

	/**
	 * Initializes an InsertionSorter instance.
	 */
	@Before
	public void setUp() {
		integerSorter = new InsertionSorter <Integer> /* <E> */ ();
	}

	/**
	 * Tests InsertionSorter.sort() for Integer classes.
	 */
	@Test
	public void testSortIntegers() {
		integerSorter.sort(dataAscending);
//		assertEquals(1, dataAscending[0]);
//		assertEquals(2, dataAscending[1]);
//		assertEquals(3, dataAscending[2]);
//		assertEquals(4, dataAscending[3]);
//		assertEquals(5, dataAscending[4]);
		
		assertTrue( dataAscending[ 0 ].equals( 1 ) );
		assertTrue( dataAscending[ 1 ].equals( 2 ) );
		assertTrue( dataAscending[ 2 ].equals( 3 ) );
		assertTrue( dataAscending[ 3 ].equals( 4 ) );
		assertTrue( dataAscending[ 4 ].equals( 5 ) );

		integerSorter.sort(dataDescending);
//		assertEquals(1, dataDescending[0]);		
//		assertEquals(2, dataDescending[1]);
//		assertEquals(3, dataDescending[2]);
//		assertEquals(4, dataDescending[3]);
//		assertEquals(5, dataDescending[4]);
		
		assertTrue( dataDescending[ 0 ].equals( 1 ) );
		assertTrue( dataDescending[ 1 ].equals( 2 ) );
		assertTrue( dataDescending[ 2 ].equals( 3 ) );
		assertTrue( dataDescending[ 3 ].equals( 4 ) );
		assertTrue( dataDescending[ 4 ].equals( 5 ) );
		
		integerSorter.sort(dataRandom);
//		assertEquals(1, dataRandom[0]);
//		assertEquals(2, dataRandom[1]);
//		assertEquals(3, dataRandom[2]);
//		assertEquals(4, dataRandom[3]);
//		assertEquals(5, dataRandom[4]);
		
		assertTrue( dataRandom[ 0 ].equals( 1 ) );
		assertTrue( dataRandom[ 1 ].equals( 2 ) );
		assertTrue( dataRandom[ 2 ].equals( 3 ) );
		assertTrue( dataRandom[ 3 ].equals( 4 ) );
		assertTrue( dataRandom[ 4 ].equals( 5 ) );
	}
	
	/**
	 * Tests InsertionSorter.sort() for Student classes using a NaturalOrder Comparator.
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
		
		InsertionSorter<Student> studentSorter = new InsertionSorter<Student>();
		
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
	 * Tests InsertionSorter.sort() for Student classes using a StudentGPAComparator comparator.
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
		InsertionSorter<Student> studentSorter = new InsertionSorter<Student>( comparator );
		
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
	 * Tests InsertionSorter.sort() for Student classes using a StudentIDComparator.
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
		InsertionSorter<Student> studentSorter = new InsertionSorter<Student>( comparator );
		
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
