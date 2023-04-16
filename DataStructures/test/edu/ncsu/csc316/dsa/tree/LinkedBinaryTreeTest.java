package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for LinkedBinaryTree
 * Checks the expected outputs of the BinaryTree abstract data type behaviors when using
 * a linked data structure to store elements
 *
 * @author Dr. King
 *
 */
public class LinkedBinaryTreeTest {

    private LinkedBinaryTree<String> tree;
    private Position<String> one;
    private Position<String> two;
    private Position<String> three;
    private Position<String> four;
    private Position<String> five;
    private Position<String> six;
    private Position<String> seven;
    private Position<String> eight;
    private Position<String> nine;
    private Position<String> ten;
    
    private Position<String> eleven;
    private Position<String> twelve;
    
//    /**
//     * Helper class to create an invalid position to help test validate(p)
//     */
//    private class InvalidPosition<E> implements Position<E> {
//
//        @Override
//        public E getElement() {
//            return null;
//        }
//        
//    }

    /**
     * Create a new instance of a linked binary tree before each test case executes
     */       
    @Before
    public void setUp() {
        tree = new LinkedBinaryTree<String>(); 
    }
    
    /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */  
    private void createTree() {
        one = tree.addRoot("one");
        two = tree.addLeft(one, "two");
        three = tree.addRight(one, "three");
        six = tree.addLeft(two, "six");
        ten = tree.addRight(two, "ten");
        four = tree.addLeft(three, "four");
        seven = tree.addLeft(ten, "seven");
        five = tree.addRight(ten, "five");
        eight = tree.addLeft(four, "eight");
        nine = tree.addRight(four, "nine");
    }
    
    /**
     * Test the output of the set(p,e) behavior
     */     
    @Test
    public void testSet() {
        createTree();
        
        tree.set( two, "too" );
        assertEquals( "too", two.getElement() );
    }
    
    /**
     * Test the output of the size() behavior
     */     
    @Test
    public void testSize() {
        assertTrue(tree.isEmpty());
        createTree();
        
        assertEquals( 10, tree.size() );
    }
    
    /**
     * Test the output of the numChildren(p) behavior
     */     
    @Test
    public void testNumChildren() {
        createTree();
        
        assertEquals( 2, tree.numChildren(one) );
        assertEquals( 1, tree.numChildren(three) ); // workshop 7 - changed "1" to "2"
        assertEquals( 0, tree.numChildren(seven) ); // workshop 7 - changed "0" to "2"
    }

    /**
     * Test the output of the parent(p) behavior
     */   
    @Test
    public void testParent() {
        createTree();
        
        assertEquals( null, tree.parent(one) );
        assertEquals( one, tree.parent(two) );
        assertEquals( one, tree.parent(three) );
    }

    /**
     * Test the output of the sibling behavior
     */     
    @Test
    public void testSibling() {
        createTree();
        
        assertEquals( two, tree.sibling(three) );
        assertEquals( three, tree.sibling(two) );
    }

    /**
     * Test the output of the isInternal behavior
     */     
    @Test
    public void testIsInternal() {
        createTree();
        
        assertTrue( tree.isInternal(one) );
        assertTrue( tree.isInternal(two) );
        assertFalse( tree.isInternal(eight) ); // workshop 7 - changed from false to true
    }

    /**
     * Test the output of the isLeaf behavior
     */     
    @Test
    public void isLeaf() {
        createTree();
        
        assertTrue( tree.isLeaf(eight) ); // workshop 7 - changed from true to false
        assertTrue( tree.isLeaf(nine) ); // workshop 7 - changed from true to false
        assertFalse( tree.isLeaf(one) );
    }

    /**
     * Test the output of the isRoot(p)
     */     
    @Test
    public void isRoot() {
        createTree();
        
        assertTrue( tree.isRoot(one) );
        assertFalse( tree.isRoot(two) );
        
        eleven = tree.addRight(nine, "eleven");
        tree.setRoot(eleven);
        assertTrue( tree.isRoot(eleven) );
    }
    
    /**
     * Test the output of the preOrder traversal behavior
     */     
    @Test
    public void testPreOrder() {
        createTree();
        
        Iterable<Position<String>> list = tree.preOrder();
        Iterator<Position<String>> it = list.iterator();
        assertEquals( one, it.next() );
        assertEquals( two, it.next() );
        assertEquals( six, it.next() );
        assertEquals( ten, it.next() );
        assertEquals( seven, it.next() );
        assertEquals( five, it.next() );
        assertEquals( three, it.next() );
        assertEquals( four, it.next() );
        assertEquals( eight, it.next() );
        assertEquals( nine, it.next() );
    }

    /**
     * Test the output of the postOrder traversal behavior
     */     
    @Test
    public void testPostOrder() {
        createTree();
        
        Iterable<Position<String>> list = tree.postOrder();
        Iterator<Position<String>> it = list.iterator();
        assertEquals( "six", it.next().getElement() );
        assertEquals( seven, it.next() );
        assertEquals( five, it.next() );
        assertEquals( ten, it.next() );
        assertEquals( two, it.next() );
        assertEquals( eight, it.next() );
        assertEquals( nine, it.next() );
        assertEquals( four, it.next() );
        assertEquals( three, it.next() );
        assertEquals( one, it.next() );
    }
    
    /**
     * Test the output of the inOrder traversal behavior
     */     
    @Test
    public void testInOrder() {
        createTree();
        
        Iterable<Position<String>> list = tree.inOrder();
        Iterator<Position<String>> it = list.iterator();
        assertEquals( six, it.next() );
        assertEquals( two, it.next() );
        assertEquals( seven, it.next() );
        assertEquals( ten, it.next() );
        assertEquals( five, it.next() );
        assertEquals( one, it.next() );
        assertEquals( eight, it.next() );
        assertEquals( four, it.next() );
        assertEquals( nine, it.next() );
        assertEquals( three, it.next() );
    }

    /**
     * Test the output of the Binary Tree ADT behaviors on an empty tree
     */     
    @Test
    public void testEmptyTree() {    	
        tree = new LinkedBinaryTree<String>();
        assertTrue( tree.isEmpty() );
        
        one = tree.addRoot("one");
        assertFalse( tree.isEmpty() );
    }
    
    @Test
    public void testLevelOrder() {
        createTree();
        
        Iterable<Position<String>> list = tree.levelOrder();
        Iterator<Position<String>> it = list.iterator();
        assertEquals( one, it.next() );
        assertEquals( two, it.next() );
        assertEquals( three, it.next() );
        assertEquals( six, it.next() );
        assertEquals( ten, it.next() );
        assertEquals( four, it.next() );
        assertEquals( seven, it.next() );
        assertEquals( five, it.next() );
        assertEquals( eight, it.next() );
        assertEquals( nine, it.next() );
    }

    /**
     * Test the output of the addLeft(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddLeft() {
        one = tree.addRoot("one");
    	two = tree.addLeft( one, "two" );
    	assertEquals( "two", tree.left(one).getElement() );
    }
    
    /**
     * Test the output of the addRight(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddRight() {
        one = tree.addRoot("one");
    	two = tree.addRight( one, "two" );
    	assertEquals( "two", tree.right(one).getElement() );
    }   
    
    /**
     * Test the output of the remove(p) behavior, including expected exceptions
     */         
    @Test
    public void testRemove() {
        createTree();
        
        assertThrows( IllegalArgumentException.class, () -> tree.remove(one) );
        
//        *                    one
//        *                /        \
//        *             two          three
//        *            /   \            /
//        *         six   ten          four
//        *              /   \        /     \
//        *            seven  five  eight nine    
        
        // 0 left
        tree.remove( six );
        assertEquals( null, tree.left(two) );
        assertEquals( ten, tree.right(two) );
        
        // 0 right
        tree.remove( five );
        assertEquals( seven, tree.left(ten) );
        assertEquals( null, tree.right(ten) );
        
        // 1 right left
        tree.remove( three );
        assertEquals( one, tree.parent(four) );
        assertEquals( four, tree.right(one) );
        
        // 1 right right
        eleven = tree.addRight( nine, "eleven" );
        tree.remove( nine );
        assertEquals( four, tree.parent(eleven) );
        assertEquals( eleven, tree.right(four) );
        
        // 1 left left
        twelve = tree.addLeft( seven, "twelve" );
        tree.remove( seven );
        assertEquals( ten, tree.parent(twelve) );
        assertEquals( twelve, tree.left(ten) );
        
        // 1 left right
        tree.remove( two );
        assertEquals( one, tree.parent(ten) );
        assertEquals( ten, tree.left(one) );
        
        LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<String>();
        Position<String> uno;
        uno = tree2.addRoot("one");
        assertEquals( "one", tree2.remove(uno) );
        assertEquals( 0, tree2.size() );
    }
    
    /**
     * Tests toString().
     */
    @Test
    public void testString() {
        one = tree.addRoot("one");
    	two = tree.addRight( one, "two" );
    	
    	assertEquals( "LinkedBinaryTree[\n" +
    				  "one\n" +
    				  " two\n" +
    				  "]", 
    				  tree.toString() );
    }
}
