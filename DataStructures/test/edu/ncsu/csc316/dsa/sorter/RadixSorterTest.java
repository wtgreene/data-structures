package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Tests RadixSorter.java.
 * 
 * @author Will Greene
 */
public class RadixSorterTest {

	/** Student 1 */
	private Student sOne;
	
	/** Student 2 */
	private Student sTwo;
	
	/** Student 3 */
	private Student sThree;
	
	/** Student 4 */
	private Student sFour;
	
	/** Student 5 */
	private Student sFive;
	
	/** RadixSorter instance */
	private RadixSorter<Student> sorter;

	/**
	 * Initializes 5 Students and a RadixSorter instance.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
		
		sorter = new RadixSorter<Student>();
	}
	
	/**
	 * Tests RadixSorter.sort().
	 */
	@Test
	public void testSortStudent() {
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}
}
