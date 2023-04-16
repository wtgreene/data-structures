package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for LinearProbingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a linear probing hash map data structure 
 *
 * @author Dr. King
 *
 */
public class LinearProbingHashMapTest {

    private Map<Integer, String> map;

    /**
     * Create a new instance of a linear probing hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are testing.
        // Remember that (when testing) alpha = 1, beta = 1, and prime = 7
        // based on our AbstractHashMap constructor.
        // That means you can draw the hash table by hand
        // if you use integer keys, since Integer.hashCode() = the integer value, itself
        // Finally, apply compression. For example:
        // for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
        // for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
        // for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
        // for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
        // for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
        // for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
        // etc.
        map = new LinearProbingHashMap<Integer, String>(7, true);
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
                
        map.put(1, "one");
        assertEquals(1, map.size() );
        
        map.put(2, "two");
        map.put(3, "three");
        assertEquals(3, map.size() );
        
        Map<Integer, String> map2 = new LinearProbingHashMap<Integer, String>();
        
        map2.put(1, "one");
        assertEquals(1, map2.size() );
        
        Map<Integer, String> map3 = new LinearProbingHashMap<Integer, String>(7);
        
        map3.put(1, "one");
        assertEquals(1, map3.size() );
        
        Map<Integer, String> map4 = new LinearProbingHashMap<Integer, String>(true);
        
        map4.put(1, "one");
        assertEquals(1, map4.size() );
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        
        map.put(1, "one");
        assertEquals( "one", map.get(1) );
        
        map.put(2, "two");
        assertEquals( "one", map.get(1) );
        assertEquals( "two", map.get(2) );
    }
    
    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        
        map.put(1, "one");
        assertEquals( "one", map.remove(1) );
        assertTrue( map.isEmpty() );
        
        map.put(1, "one");
        map.put(2, "two");
        assertEquals( "one", map.remove(1) );
        assertEquals( 1, map.size() );
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
    	
    	map.put(1, "one");
    	map.put(2, "two");
    	map.put(3, "three");
        
        Iterator<Integer> it = map.iterator();
        
        assertTrue( it.hasNext() );
        assertTrue( 1 == it.next() );
        assertTrue( it.hasNext() );
        assertTrue( 2 == it.next() );
        assertTrue( it.hasNext() );
        assertTrue( 3 == it.next() );
        assertFalse( it.hasNext() );
        assertThrows( NoSuchElementException.class, () -> it.next() );
    }
    
    /**
     * Test the output of the entrySet() behavior
     */     
    @Test
    public void testEntrySet() {
    	
    	map.put(1, "one");
    	map.put(2, "two");
    	map.put(3, "three");
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();     
        
        assertTrue( it.hasNext() );
        it.next();
        assertTrue( it.hasNext() );
        it.next();
        assertTrue( it.hasNext() );
        it.next();
        assertFalse( it.hasNext() );
        assertThrows( NoSuchElementException.class, () -> it.next() );
    }
    
    /**
     * Test the output of the values() behavior
     */  
    @Test
    public void testValues() {
    	
    	map.put(1, "one");
    	map.put(2, "two");
    	map.put(3, "three");
        
        Iterator<String> it = map.values().iterator();
        
        assertTrue( it.hasNext() );
        assertEquals( "one", it.next() );
        assertTrue( it.hasNext() );
        assertEquals( "two", it.next() );
        assertTrue( it.hasNext() );
        assertEquals( "three", it.next() );
        assertFalse( it.hasNext() );
        assertThrows( NoSuchElementException.class, () -> it.next() );
    }
}