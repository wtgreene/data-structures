package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
//import edu.ncsu.csc316.dsa.data.Student;
//import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for SearchTableMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a sorted array-based data structure that uses binary search to locate entries
 * based on the key of the entry
 *
 * @author Dr. King
 *
 */
public class SearchTableMapTest {

    private Map<Integer, String> map;
//    private Map<Student, Integer> studentMap;
    
    /**
     * Create a new instance of a search table map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new SearchTableMap<Integer, String>();
//        studentMap = new SearchTableMap<Student, Integer>();
    }

    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("SearchTableMap[3]", map.toString());
        assertEquals(1, map.size());
        
        //: complete this test case
    }

    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());
        
        //: complete this test case
    }

    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());
        
        //: complete this test case
    }
    
//    /**
//     * Tests Map abstract data type behaviors to ensure the behaviors work
//     * as expected when using arbitrary objects as keys
//     */
//    @Test
//    public void testStudentMap() {
//        Student s1 = new Student("J","K", 1, 0, 0, "jk");
//        Student s2 = new Student("J","S", 2, 0, 0, "js");
//        Student s3 = new Student("S","H", 3, 0, 0, "sh");
//        Student s4 = new Student("J","J", 4, 0, 0, "jj");
//        Student s5 = new Student("L","B", 5, 0, 0, "lb");
//        
//        //: complete this test case
//        // Suggestions: since search table map keys are Comparable,
//        // make sure the search table works with Comparable objects like Students
//    }
    
    /**
     * Test the output of the iterator behavior, including expected exceptions
     */ 
    @Test
    public void testIterator() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        //: complete this test case
    }

    /**
     * Test the output of the entrySet() behavior, including expected exceptions
     */     
    @Test
    public void testEntrySet() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertTrue(it.hasNext());
        Map.Entry<Integer, String> entry = it.next();
        assertEquals(1, (int)(entry.getKey()));
        assertEquals("string1", (String)(entry.getValue()));

        //: complete this test case
    }

    /**
     * Test the output of the values() behavior, including expected exceptions
     */  
    @Test
    public void testValues() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<String> it = map.values().iterator();
        assertTrue(it.hasNext());
        
        //: complete this test case
    }
}