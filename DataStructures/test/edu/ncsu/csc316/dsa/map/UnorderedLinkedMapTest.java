package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.AbstractMap.MapEntry;

/**
 * Test class for UnorderedLinkedMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an unordered link-based list data structure that uses the move-to-front heuristic for
 * self-organizing entries based on access frequency
 *
 * @author Dr. King
 *
 */
public class UnorderedLinkedMapTest {

    private Map<Integer, String> map;
    
    /**
     * Create a new instance of an unordered link-based map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new UnorderedLinkedMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("UnorderedLinkedMap[3]", map.toString());
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
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        //: complete this test case
        
        MapEntry<Integer, Integer> entry1 = new MapEntry<Integer, Integer>(1, 2);
        MapEntry<Integer, Integer> entry2 = new MapEntry<Integer, Integer>(3, 4);
        assertTrue( entry1.compareTo( entry2 ) != 0 );
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
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        //: complete this test case
    }

    /**
     * Test the output of the iterator behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
//        assertNull(map.put(3, "string3"));
//        assertNull(map.put(5, "string5"));
//        assertNull(map.put(2, "string2"));
//        assertNull(map.put(4, "string4"));
//        assertNull(map.put(1, "string1"));
        
        // Start with an empty list
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        
        // Create an iterator for the empty list
        Iterator<Integer> it = map.iterator();
        
        // Try different operations to make sure they work
        // as expected for an empty list (at this point)
        try{
            it.remove();
            fail("An UnsupportedOperationException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
        assertFalse(it.hasNext());

        // Now add an element
        assertNull(map.put(3, "string3"));
        
        // Use accessor methods to check that the list is correct
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
//        assertEquals("one", list.first().getElement() ); // changed from list.get( 0 ) to list.first()
        
        // Create an iterator for the list that has 1 element
        it = map.iterator();
        
        // Try different iterator operations to make sure they work
        // as expected for a list that contains 1 element (at this point)
        assertTrue(it.hasNext());
        assertTrue( it.next().compareTo(3) == 0 );
        assertFalse(it.hasNext());
        try{
            it.next();
            fail("A NoSuchElementException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
        
//        it.remove();
//        assertTrue( list.isEmpty() );
    }
    
    /**
     * Test the output of the iterator behavior, including expected exceptions
     */     
    @Test
    public void testValueIterator() {
//        assertNull(map.put(3, "string3"));
//        assertNull(map.put(5, "string5"));
//        assertNull(map.put(2, "string2"));
//        assertNull(map.put(4, "string4"));
//        assertNull(map.put(1, "string1"));
        
        // Start with an empty list
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        
        // Create an iterator for the empty list
		Iterable<String> it = map.values();
        
        // Try different operations to make sure they work
        // as expected for an empty list (at this point)
        try{
            it.iterator().remove();
            fail("An UnsupportedOperationException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
        assertFalse(it.iterator().hasNext());

        // Now add an element
        assertNull(map.put(3, "string3"));
        
        // Use accessor methods to check that the list is correct
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
//        assertEquals("one", list.first().getElement() ); // changed from list.get( 0 ) to list.first()
        
        // Create an iterator for the list that has 1 element
        it = map.values();
        
        // Try different iterator operations to make sure they work
        // as expected for a list that contains 1 element (at this point)
        assertTrue(it.iterator().hasNext());
        assertTrue( it.iterator().next().compareTo("string3") == 0 );
//        assertFalse(it.iterator().hasNext());
//        try{
//            it.iterator().next();
//            fail("A NoSuchElementException should have been thrown");           
//        } catch(Exception e) {
//            assertTrue(e instanceof NoSuchElementException);
//        }
        
//        it.remove();
//        assertTrue( list.isEmpty() );
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
        
        //: complete this test case
    }
}
