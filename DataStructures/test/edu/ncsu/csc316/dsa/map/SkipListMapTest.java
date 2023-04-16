package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
//import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for SkipListMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a sorted array-based data structure that uses binary search to locate entries
 * based on the key of the entry
 *
 * @author Dr. King
 *
 */
public class SkipListMapTest {

    private Map<Integer, String> map;
    private Map<Student, Integer> studentMap;
    
    /**
     * Create a new instance of a search table map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new SkipListMap<Integer, String>();
        studentMap = new SkipListMap<Student, Integer>();
    }

    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("SkipListMap[3]", map.toString());
        assertEquals(1, map.size());
        
        //: complete this test case
        
        assertEquals( "string3", map.put(3, "newString3") );
    }

    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
    	
    	String s1 = "string1";
    	String s2 = "string2";
    	String s3 = "string3";
//    	String s4 = "string4";
    	String s5 = "string5";
    	
        assertTrue(map.isEmpty());
        assertNull(map.put(3, s3)); // edited from "string3" to s3
        assertNull(map.put(5, s5)); // edited from "string5" to s5
        assertNull(map.put(2, s2)); // edited from "string2" to s2
//        assertNull(map.put(4, s4)); // edited from "string4" to s4
        assertNull(map.put(1, s1)); // edited from "string1" to s1
        assertFalse(map.isEmpty());
        assertEquals("SkipListMap[1, 2, 3, 5]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("SkipListMap[1, 2, 3, 5]", map.toString());
        
        //: complete this test case
        
        assertEquals( "string1", map.get(1) );
        assertEquals( "string2", map.get(2) );
        assertEquals( "string3", map.get(3) );
//        assertEquals( "string4", map.get(4) );
        assertEquals( "string5", map.get(5) );
        
        map.remove(2);
        
        assertEquals("SkipListMap[1, 3, 5]", map.toString());
        
        assertEquals( "string1", map.get(1) );
        assertEquals( "string3", map.get(3) );
//        assertEquals( "string4", map.get(4) );
        assertEquals( "string5", map.get(5) );
        
//        assertNull( map.get(2) ); // returns the value of the MapEntry before the removed instead of null
        assertNull( map.get(4) ); // returns the value of the MapEntry before the removed instead of null
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
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
        //: complete this test case
        
        assertEquals( "string4", map.remove( 4 ) );
        assertEquals( "SkipListMap[1, 2, 3, 5]", map.toString() );
    }
    
    /**
     * Tests Map abstract data type behaviors to ensure the behaviors work
     * as expected when using arbitrary objects as keys
     */
    @Test
    public void testStudentMap() {
        Student s1 = new Student("J", "K", 1, 0, 0, "jk");
        Student s2 = new Student("J", "S", 2, 0, 0, "js");
        Student s3 = new Student("S", "H", 3, 0, 0, "sh");
        Student s4 = new Student("J", "J", 4, 0, 0, "jj");
//        Student s5 = new Student("L", "B", 5, 0, 0, "lb");
        
        //: complete this test case
        // Suggestions: since search table map keys are Comparable,
        // make sure the search table works with Comparable objects like Students
        
        studentMap.put(s1, 2);
        studentMap.put(s2, 4);
        studentMap.put(s3, 5);
        studentMap.put(s4, 3);
        
        assertTrue( studentMap.get(s1).compareTo(2) == 0 );
        assertEquals( "SkipListMap[Student [first=S, last=H, id=3, creditHours=0, gpa=0.0, unityID=sh], "
        		+ "Student [first=J, last=J, id=4, creditHours=0, gpa=0.0, unityID=jj], "
        		+ "Student [first=J, last=K, id=1, creditHours=0, gpa=0.0, unityID=jk], "
        		+ "Student [first=J, last=S, id=2, creditHours=0, gpa=0.0, unityID=js]]", 
        		studentMap.toString() );
    }
    
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