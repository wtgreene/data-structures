package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests StudentGPAComparator.java.
 * 
 * @author Will Greene
 */
public class StudentGPAComparatorTest {

	/** student 1 */
	private Student sOne;
	
	/** student 2 */
	private Student sTwo;
	
	/** student 3 */
	private Student sThree;
	
	/** student 4 */
//	private Student sFour;
	
	/** student 5 */
//	private Student sFive;

	/** comparator instance */
//	private StudentGPAComparator comparator;
	private Comparator<Student> comparator1;

	/**
	 * Initializes 5 Students and a StudentGPAComparator.
	 */
	@Before
	public void setUp() {
		
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		
//		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
//		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
//		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		comparator1 = new StudentGPAComparator();
	}

	/**
	 * Tests StudentGPAComparator.compare().
	 */
	@Test
	public void testCompare() {
		
		assertTrue(comparator1.compare(sTwo, sOne) < 0);
		assertFalse(comparator1.compare(sOne, sTwo) < 0);
		
		sThree = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");

		assertTrue(comparator1.compare(sOne, sThree) == 0);
	}
}
