package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for RedBlackTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a red-black tree data structure 
 *
 * @author Dr. King
 *
 */
public class RedBlackTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a red-black tree-based map before each test case executes
     */  
    @Before
    public void setUp() {
        tree = new RedBlackTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());    
                
        tree.put(20, "twenty");
        assertEquals( 1, tree.size() );
        
        tree.put(10, "ten");
        tree.put(30, "thirty");
        assertEquals( 3, tree.size() );
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
    	
        tree.put(20, "twenty");
        assertEquals( "twenty", tree.get(20) );
        
        tree.put(10, "ten");
        tree.put(30, "thirty");
        assertEquals( "ten", tree.get(10) );
        assertEquals( "thirty", tree.get(30) );
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        tree.put(20, "twenty");
        tree.put(10, "ten");
        tree.put(30, "thirty");
        tree.put(5,  "five");
        tree.put(15, "fifteen");
        tree.put(25, "twenty five");
        tree.put(35, "thirty five");
        tree.put(40, "forty" );
        
        assertEquals( "five", tree.remove(5) );
        assertEquals( "fifteen", tree.remove(15) );
        assertEquals( "ten", tree.remove(10) );
        assertEquals( "thirty", tree.root().getElement().getValue() );
        assertEquals( "twenty five", tree.right(tree.left(tree.root())).getElement().getValue() );
        
        assertEquals( "twenty five", tree.remove(25) );
        assertEquals( "twenty", tree.remove(20) );
        assertEquals( "thirty five", tree.root().getElement().getValue() );
        assertEquals( "thirty", tree.left(tree.root()).getElement().getValue() );
        assertEquals( "forty", tree.right(tree.root()).getElement().getValue() );        
    }
}