package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for SeparateChainingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a separate chaining hash map data structure 
 *
 * @author Dr. King
 *
 */
public class SeparateChainingHashMapTest {

    private Map<Integer, String> map;
    
    /**
     * Create a new instance of a separate chaining hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are TESTING.
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
        // Remember that our secondary map (an AVL tree) is a search
        // tree, which means the entries should be sorted in order within
        // that tree
        map = new SeparateChainingHashMap<Integer, String>(7, true);
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));

        // Since our entrySet method returns the entries in the table
        // from left to right, we can use the entrySet to check
        // that our values are in the correct order in the hash table.
        // Alternatively, you could implement a toString() method if you
        // want to check that the exact index/map of each bucket is correct
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        
        
        assertNull(map.put(4, "string4"));
        assertEquals(2, map.size());
        assertFalse(map.isEmpty());
        it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5
        
        Map<Integer, String> map2 = new SeparateChainingHashMap<Integer, String>();
        
        map2.put(1, "one");
        assertEquals(1, map2.size() );
        
        Map<Integer, String> map3 = new SeparateChainingHashMap<Integer, String>(7);
        
        map3.put(1, "one");
        assertEquals(1, map3.size() );
        
        Map<Integer, String> map4 = new SeparateChainingHashMap<Integer, String>(true);
        
        map4.put(1, "one");
        assertEquals(1, map4.size() );
        
        // You should create some collisions to check that entries
        // are placed in the correct buckets
        
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        
    	map.put(1, "one");
    	map.put(2, "two");
    	map.put(3, "three");
    	
    	assertEquals( "one", map.get(1) );
    	assertEquals( "two", map.get(2) );
    	assertEquals( "three", map.get(3) );
    	assertNull( map.get(4) );
    	
    	Map<Integer, String> map2 = new SeparateChainingHashMap<Integer, String>(2, true);
    	
    	map2.put(1, "one");
    	map2.put(2, "two");
    	map2.put(3, "three");
    	
    	assertEquals( "one", map2.get(1) );
    	assertEquals( "two", map2.get(2) );
    	assertEquals( "three", map2.get(3) );
    	assertNull( map2.get(4) );
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        
    	map.put(1, "one");
    	map.put(2, "two");
    	map.put(3, "three");
    	
    	assertEquals( 3, map.size() );
    	assertEquals( "two", map.remove(2) );
    	assertEquals( 2, map.size() );
    	assertEquals( "one", map.remove(1) );
    	assertEquals( "three", map.remove(3) );
    	assertEquals( 0, map.size() );
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
        it.next();
        assertTrue( it.hasNext() );
        it.next();
        assertTrue( it.hasNext() );
        it.next();
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
        it.next();
        assertTrue( it.hasNext() );
        it.next();
        assertTrue( it.hasNext() );
        it.next();
        assertFalse( it.hasNext() );
        assertThrows( NoSuchElementException.class, () -> it.next() );
    }
}