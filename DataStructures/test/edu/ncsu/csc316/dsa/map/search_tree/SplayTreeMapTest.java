package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
//import edu.ncsu.csc316.dsa.map.search_tree.*;

/**
 * Test class for SplayTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a splay tree data structure 
 *
 * @author Dr. King
 *
 */
public class SplayTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a splay tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new SplayTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());      
        
        tree.put(10, "ten");
        assertEquals( "ten", tree.root().getElement().getValue() );
        
        tree.put(20, "twenty");
        assertEquals( "twenty", tree.root().getElement().getValue() );
        assertEquals( "ten", tree.left(tree.root()).getElement().getValue() );
        
        tree.put(30, "thirty");
        assertEquals( "thirty", tree.root().getElement().getValue() );
        assertEquals( "twenty", tree.left(tree.root()).getElement().getValue() );
        assertEquals( "ten", tree.left(tree.left(tree.root())).getElement().getValue() );
        
        tree.put(25, "twenty five");
        assertEquals( "twenty five", tree.root().getElement().getValue() );
        assertEquals( "twenty", tree.left(tree.root()).getElement().getValue() );
        assertEquals( "ten", tree.left(tree.left(tree.root())).getElement().getValue() );
        assertEquals( "thirty", tree.right(tree.root()).getElement().getValue() );
    }
    
    /**
     * Test the output of the get(k) behavior
     */ 
    @Test
    public void testGet() {
    	
        tree.put(10, "ten");
        tree.put(20, "twenty");
        tree.put(30, "thirty");
        tree.put(25, "twenty five");
        
        tree.get(30);
        assertEquals( "thirty", tree.root().getElement().getValue() );
        assertEquals( "twenty five", tree.left(tree.root()).getElement().getValue() );
        assertEquals( "twenty", tree.left(tree.left(tree.root())).getElement().getValue() );
        assertEquals( "ten", tree.left(tree.left(tree.left(tree.root()))).getElement().getValue() );
        
        tree.get(10);
        assertEquals( "ten", tree.root().getElement().getValue() );
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {

        tree.put(10, "ten");
        tree.put(20, "twenty");
        tree.put(30, "thirty");
        tree.put(25, "twenty five");
        
        assertEquals( "ten", tree.remove(10) );
        assertEquals( "twenty", tree.root().getElement().getValue() );
        assertEquals( "twenty five", tree.right(tree.root()).getElement().getValue() );
        assertEquals( "thirty", tree.right(tree.right(tree.root())).getElement().getValue() );
    }
}