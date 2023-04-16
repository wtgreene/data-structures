package edu.ncsu.csc316.dsa.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Tests StudentReader.java.
 * 
 * @author Will Greene
 */
public class StudentReaderTest {
	
	/**
	 * Tests StudentReader.readInputAsArray() & StudentReader.processLine() for ascending file.
	 */
	@Test
	public void testReadFile() {
		Student[] contents = StudentReader.readInputAsArray("input/student_ascendingID.csv");
		assertEquals("Amber", contents[0].getFirst());
		assertEquals("Ara", contents[1].getFirst());
		assertEquals("Lacie", contents[2].getFirst());
		assertEquals("Idalia", contents[3].getFirst());
		assertEquals("Evelin", contents[4].getFirst());
		assertEquals("Lewis", contents[5].getFirst());
		assertEquals("Alicia", contents[6].getFirst());
		assertEquals("Tyree", contents[7].getFirst());
		assertEquals("Loise", contents[8].getFirst());
		assertEquals("Roxann", contents[9].getFirst());
		assertEquals("Nichole", contents[10].getFirst());
		assertEquals("Charlene", contents[11].getFirst());
		assertEquals("Shanti", contents[12].getFirst());
		assertEquals("Cristine", contents[13].getFirst());
		assertEquals("Tanner", contents[14].getFirst());
		assertEquals("Dante", contents[15].getFirst());
	}
	
	/**
	 * Tests StudentReader.readInputAsArray() & StudentReader.processLine() for descending file.
	 */
	@Test
	public void testReadFileDescending() {
		Student[] contents2 = StudentReader.readInputAsArray("input/student_descendingID.csv");
		assertEquals("Dante", contents2[0].getFirst());
		assertEquals("Tanner", contents2[1].getFirst());
		assertEquals("Cristine", contents2[2].getFirst());
		assertEquals("Shanti", contents2[3].getFirst());
		assertEquals("Charlene", contents2[4].getFirst());
		assertEquals("Nichole", contents2[5].getFirst());
		assertEquals("Roxann", contents2[6].getFirst());
		assertEquals("Loise", contents2[7].getFirst());
		assertEquals("Tyree", contents2[8].getFirst());
		assertEquals("Alicia", contents2[9].getFirst());
		assertEquals("Lewis", contents2[10].getFirst());
		assertEquals("Evelin", contents2[11].getFirst());
		assertEquals("Idalia", contents2[12].getFirst());
		assertEquals("Lacie", contents2[13].getFirst());
		assertEquals("Ara", contents2[14].getFirst());
		assertEquals("Amber", contents2[15].getFirst());
	}
	
	/**
	 * Tests StudentReader.readInputAsArray() & StudentReader.processLine() for random file.
	 */
	@Test
	public void testReadFileRandom() {
		Student[] contents3 = StudentReader.readInputAsArray("input/student_randomOrder.csv");
		assertEquals("Lacie", contents3[0].getFirst());
		assertEquals("Tyree", contents3[1].getFirst());
		assertEquals("Loise", contents3[2].getFirst());
		assertEquals("Idalia", contents3[3].getFirst());
		assertEquals("Shanti", contents3[4].getFirst());
		assertEquals("Roxann", contents3[5].getFirst());
		assertEquals("Evelin", contents3[6].getFirst());
		assertEquals("Alicia", contents3[7].getFirst());
		assertEquals("Charlene", contents3[8].getFirst());
		assertEquals("Nichole", contents3[9].getFirst());
		assertEquals("Ara", contents3[10].getFirst());
		assertEquals("Dante", contents3[11].getFirst());
		assertEquals("Tanner", contents3[12].getFirst());
		assertEquals("Cristine", contents3[13].getFirst());
		assertEquals("Amber", contents3[14].getFirst());
		assertEquals("Lewis", contents3[15].getFirst());
	}
	
	/**
	 * Tests StudentReader.readInputAsArray() for an invalid filename.
	 */
	@Test
	public void testFileNotFound() {
		assertThrows(IllegalArgumentException.class, () -> StudentReader.readInputAsArray("not_a_file.csv"));
	}
}
