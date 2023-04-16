package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests StudentIDComparator.java.
 * 
 * @author Will Greene
 */
public class StudentIDComparatorTest {

	/** Student 1 */
	private Student sOne;
	
	/** Student 2 */
	private Student sTwo;
	
	/** Student 3 */
//	private Student sThree;
	
	/** Student 4 */
//	private Student sFour;
	
	/** Student 5 */
//	private Student sFive;
	
	/** comparator instance */
	private StudentIDComparator comparator;

	@Before
	public void setUp() {
		
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		
//		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
//		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
//		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		comparator = new StudentIDComparator();
	}

	/**
	 * Tests StudentIDComparator.compare().
	 */
	@Test
	public void testCompare() {
		assertTrue(comparator.compare(sOne, sTwo) < 0);
		assertFalse(comparator.compare(sTwo, sOne) < 0);
	}
}
