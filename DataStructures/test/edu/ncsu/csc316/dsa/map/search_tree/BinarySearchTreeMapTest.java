package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinarySearchTreeMap
 * Checks the expected outputs of the Map and Tree abstract data type behaviors when using
 * an linked binary tree data structure 
 *
 * @author Dr. King
 *
 */
public class BinarySearchTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a binary search tree map before each test case executes
     */
    @Before
    public void setUp() {
        tree = new BinarySearchTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        tree.put(1, "one");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(1, (int)tree.root().getElement().getKey());
                
        tree.put(1, "uno");
        tree.put(0, "zero");
        assertEquals( 2, tree.size() );
        assertEquals( 0, (int)tree.left(tree.root()).getElement().getKey() );
        assertEquals( "zero", tree.left(tree.root()).getElement().getValue() );
        
        tree.entrySet(); // work out later
        tree.toString(); // work out later
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
                
        assertEquals( "one", tree.get(1) );
        assertNull( tree.get(2) );
    }

    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        assertEquals(1, (int)tree.root().getElement().getKey() );
        assertNull( tree.left(tree.root()).getElement() );
        assertNull( tree.right(tree.root()).getElement() );
        assertNull( tree.parent(tree.root()) );
                
        assertNull(tree.remove(10));
        assertEquals(1, tree.size());
        
        // remove root
        assertEquals("one", tree.remove(1));
        assertEquals(0, tree.size());
        
        tree.put(1, "one");
        assertEquals(1, tree.size());
        assertEquals(1, (int)tree.root().getElement().getKey() );
        assertNull( tree.left(tree.root()).getElement() );
        assertNull( tree.right(tree.root()).getElement() );
        assertNull( tree.parent(tree.root()) );
        
        tree.put(4, "four");
        tree.put(3, "three");
        tree.put(5, "five");
        tree.put(2, "two");
        tree.put(6, "six");
        
        assertEquals( 6, tree.size() );
        
        // remove node that has one left child
        assertEquals( "three", tree.remove(3) );
        assertEquals( 5, tree.size() );
                
        // remove node that has one left child
        assertEquals( "five", tree.remove(5) );
        assertEquals( 4, tree.size() );
        
        // remove node that has both children
        assertEquals( "four", tree.remove(4) );
        assertEquals( 3, tree.size() );
        
        assertEquals( "six", tree.right(tree.root()).getElement().getValue() );
        assertEquals( "two", tree.left(tree.right(tree.root())).getElement().getValue() );
    }
}