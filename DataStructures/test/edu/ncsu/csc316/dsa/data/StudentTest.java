package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests Student.java.
 * 
 * @author Will Greene
 */
public class StudentTest {

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

	/**
	 * Initializes 5 Students.
	 */
	@Before
	public void setUp() {
		
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		
//		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
//		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
//		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
	}

	/**
	 * Tests Student.setFirst() & Student.getFirst().
	 */
	@Test
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}

	/**
	 * Tests Student.setLast() & Student.getLast().
	 */
	@Test
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}

	/**
	 * Tests Student.setId() & Student.getId().
	 */
	@Test
	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}

	/**
	 * Tests Student.setGpa() & Student.getGpa().
	 */
	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}
	
	/**
	 * Tests Student.setUnityID() & Student.getUnityID().
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}

	/**
	 * Tests Student.setCreditHours() & Student.getCreditHours().
	 */
	@Test
	public void testSetCreditHours() {
		sOne.setCreditHours(2);
		assertEquals(2, sOne.getCreditHours());
	}
	
	/**
	 * Tests Student.hashCode().
	 */
	@Test
	public void testHashCode() {
		Student sSix = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		assertEquals( sOne.hashCode(), sSix.hashCode() );
		assertNotEquals( sOne.hashCode(), sTwo.hashCode() );
	}
	
	/**
	 * Tests Student.equals().
	 */
	@Test
	public void testEquals() {
		
		Student sSix = sOne;
		assertTrue(sOne.equals(sSix));
		
		Student sNull = null;
		assertFalse(sOne.equals(sNull));
		
		Student sSeven = new Student("OneFirst", "OneLast", 1, 2, 2.0, "sevenUnityID");
		assertTrue(sOne.equals(sSeven));
	}
	
	/**
	 * Tests Student.toString.
	 */
	@Test
	public void testToString() {
		assertEquals("Student [first=OneFirst, last=OneLast, id=1, creditHours=1, "
				+ "gpa=1.0, unityID=oneUnityID]", sOne.toString());
	}

	/**
	 * Tests Student.compareTo().
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOne) == 0);
		assertTrue(sTwo.compareTo(sTwo) == 0);
		
		// added
		Student sOneOne = new Student("zOneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		assertTrue(sOne.compareTo(sOneOne) < 0);
		assertTrue(sOneOne.compareTo(sOne) > 0);
	}
}
