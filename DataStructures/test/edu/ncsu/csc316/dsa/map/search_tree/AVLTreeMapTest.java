package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for AVLTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an AVL tree data structure 
 *
 * @author Dr. King
 *
 */
public class AVLTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of an AVL tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new AVLTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        tree.put( 10, "ten" );

        assertEquals( 10, (int)tree.root().getElement().getKey() );
        assertEquals( "ten", tree.root().getElement().getValue() );
        
        // sentinel nodes
        assertNull( tree.left(tree.root()).getElement() );
        assertNull( tree.right(tree.root()).getElement() );
        
        // right-right imbalance
        tree.put( 20, "twenty" );
        tree.put( 30, "thirty" );
        
        assertEquals( 20, (int)tree.root().getElement().getKey() );
        assertEquals( 10, (int)tree.left(tree.root()).getElement().getKey() );
        assertEquals( 30, (int)tree.right(tree.root()).getElement().getKey() );
        
        // sentinels nodes
        assertNull( tree.left(tree.left(tree.root())).getElement() );
        assertNull( tree.right(tree.left(tree.root())).getElement() );
        assertNull( tree.left(tree.right(tree.root())).getElement() );
        assertNull( tree.right(tree.right(tree.root())).getElement() );

        // left-left imbalance
        tree.put( 5, "five" );
        tree.put( 3, "three" );
        
        assertEquals( 20, (int)tree.root().getElement().getKey() );
        assertEquals( 5, (int)tree.left(tree.root()).getElement().getKey() );
        assertEquals( 30, (int)tree.right(tree.root()).getElement().getKey() );
        assertEquals( 3, (int)tree.left(tree.left(tree.root())).getElement().getKey() );
        assertEquals( 10, (int)tree.right(tree.left(tree.root())).getElement().getKey() );
        
        // sentinel nodes
        
        
        // right-left imbalance
        tree.put( 40, "forty" );
        tree.put( 35, "thirty five" );
        
        assertEquals( 20, (int)tree.root().getElement().getKey() );
        assertEquals( 5, (int)tree.left(tree.root()).getElement().getKey() );
        assertEquals( 35, (int)tree.right(tree.root()).getElement().getKey() );
        assertEquals( 3, (int)tree.left(tree.left(tree.root())).getElement().getKey() );
        assertEquals( 10, (int)tree.right(tree.left(tree.root())).getElement().getKey() );
        assertEquals( 30, (int)tree.left(tree.right(tree.root())).getElement().getKey() );
        assertEquals( 40, (int)tree.right(tree.right(tree.root())).getElement().getKey() );
        
        // sentinel nodes
        
        
        // left-right imbalance
        tree.put( 1, "one" );
        tree.put( 2, "two" );
        
        assertEquals( 20, (int)tree.root().getElement().getKey() );
        assertEquals( 5, (int)tree.left(tree.root()).getElement().getKey() );
        assertEquals( 35, (int)tree.right(tree.root()).getElement().getKey() );
        assertEquals( 2, (int)tree.left(tree.left(tree.root())).getElement().getKey() );
        assertEquals( 10, (int)tree.right(tree.left(tree.root())).getElement().getKey() );
        assertEquals( 30, (int)tree.left(tree.right(tree.root())).getElement().getKey() );
        assertEquals( 40, (int)tree.right(tree.right(tree.root())).getElement().getKey() );
        assertEquals( 1, (int)tree.left(tree.left(tree.left(tree.root()))).getElement().getKey() );
        assertEquals( 3, (int)tree.right(tree.left(tree.left(tree.root()))).getElement().getKey() );

        
        // sentinel nodes
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(tree.isEmpty());
        
        tree.put(10, "ten");
        assertEquals( "ten", tree.get(10) );
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        
        tree.put( 10, "ten" );
        tree.put( 20, "twenty" );
        tree.put( 30, "thirty" );
        tree.put( 5, "five" );
        tree.put( 3, "three" );
        tree.put( 40, "forty" );
        tree.put( 35, "thirty five" );
        tree.put( 1, "one" );
        tree.put( 2, "two" );
        
        assertEquals( "ten", tree.remove(10) );
        assertEquals( "two", tree.left(tree.root()).getElement().getValue() );
        assertEquals( "one", tree.left(tree.left(tree.root())).getElement().getValue() );        
        assertEquals( "five", tree.right(tree.left(tree.root())).getElement().getValue() );        
        assertEquals( "three", tree.left(tree.right(tree.left(tree.root()))).getElement().getValue() );        
    }
}