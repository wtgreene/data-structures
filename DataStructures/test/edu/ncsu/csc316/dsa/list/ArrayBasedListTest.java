package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for ArrayBasedList.
 * Checks the expected outputs of the List abstract data type behaviors when using
 * an array-based list data structure
 *
 * @author Dr. King
 *
 */
public class ArrayBasedListTest {

    private List<String> list;

    /**
     * Create a new instance of an array-based list before each test case executes
     */
    @Before
    public void setUp() {
        list = new ArrayBasedList<String>();
    }

    /**
     * Test the output of the add(index, e) behavior, including expected exceptions
     */
    @Test
    public void testAddIndex() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.add(0, "one");
        assertEquals(1, list.size());
        assertEquals("one", list.get(0));
        assertFalse(list.isEmpty());
        
        // Use the statements above to help guide your test cases
        // for data structures: Start with an empty data structure, then
        // add an element and check the accessor method return values.
        // Then add another element and check again. Continue to keep checking
        // for special cases. For example, for an array-based list, you should
        // continue adding until you trigger a resize operation to make sure
        // the resize operation worked as expected.
        
        try{
            list.add(15,  "fifteen");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }

    /**
     * Test the output of the addLast behavior
     */
    @Test
    public void testAddLast() {
            	
    	list.addLast( "a" );
    	assertEquals( "a", list.get( 0 ) );
    	
    	list.addLast( "b" );
    	assertEquals( "a", list.get( 0 ) );
    	assertEquals( "b", list.get( 1 ) );
    }

    /**
     * Test the output of the last() behavior, including expected exceptions
     */
    @Test
    public void testLast() {
    	    	
    	list.addLast( "a" );
    	assertEquals( "a", list.last() );
    	
    	list.addLast( "b" );
    	assertEquals( "b", list.last() );
    }

    /**
     * Test the output of the addFirst behavior
     */
    @Test
    public void testAddFirst() {
    	
    	list.addFirst( "b" );
    	assertEquals( "b", list.get( 0 ) );
    	
    	list.addFirst( "a" );
    	assertEquals( "a", list.get( 0 ) );
    	assertEquals( "b", list.get( 1 ) );
    }

    /**
     * Test the output of the first() behavior, including expected exceptions
     */
    @Test
    public void testFirst() {
    	
    	list.addLast( "b" );
    	assertEquals( "b", list.first() );
    	
    	list.addFirst( "a" );
    	assertEquals( "a", list.first() );
    }

    /**
     * Test the iterator behaviors, including expected exceptions
     */
    @Test
    public void testIterator() {
        // Start with an empty list
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        // Create an iterator for the empty list
        Iterator<String> it = list.iterator();
        
        // Try different operations to make sure they work
        // as expected for an empty list (at this point)
        try{
            it.remove();
            fail("An IllegalStateException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
        assertFalse(it.hasNext());

        // Now add an element
        list.addLast("one");
        
        // Use accessor methods to check that the list is correct
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals("one", list.get(0));
        
        // Create an iterator for the list that has 1 element
        it = list.iterator();
        
        // Try different iterator operations to make sure they work
        // as expected for a list that contains 1 element (at this point)
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertFalse(it.hasNext());
        try{
            it.next();
            fail("A NoSuchElementException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
        
        it.remove();
        assertTrue( list.isEmpty() );
    }

    /**
     * Test the output of the remove(index) behavior, including expected exceptions
     */
    @Test
    public void testRemoveIndex() {
    	    	
    	list.addLast( "a" );    	
    	list.addLast( "b" );
    	list.addLast( "c" );
    	list.addLast( "d" );
    	
    	// remove from out of bounds
    	assertThrows( IndexOutOfBoundsException.class, () -> list.remove( -1 ) );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.remove(  4 ) );

    	// remove from front
    	assertEquals( "a", list.remove( 0 ) );
    	assertEquals( "b", list.get( 0 ) );
    	assertEquals( "c", list.get( 1 ) );
    	assertEquals( "d", list.get( 2 ) );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.get( 3 ) );
    	
    	// remove from middle
    	list.remove( 1 );
    	assertEquals( "b", list.get( 0 ) );
    	assertEquals( "d", list.get( 1 ) );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.get( 2 ) );
    	
    	// remove from end
    	list.remove( 1 );
    	assertEquals( "b", list.get( 0 ) );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.get( 1 ) );
    	
    	// remove last remaining element
    	list.remove( 0 );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.get( 0 ) );
    	
    	// remove from empty
    	assertThrows( IndexOutOfBoundsException.class, () -> list.remove( 0 ) );
    	assertTrue( list.isEmpty() );
    }

    /**
     * Test the output of the removeFirst() behavior, including expected exceptions
     */
    @Test
    public void testRemoveFirst() {
    	    	
    	list.addLast( "a" );    	
    	list.addLast( "b" );
    	list.addLast( "c" );
    	list.addLast( "d" );
    	
    	list.removeFirst();
    	assertEquals( "b", list.get( 0 ) );
    	assertEquals( "c", list.get( 1 ) );
    	assertEquals( "d", list.get( 2 ) );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.get( 3 ) );
    	
    	list.removeFirst();
    	list.removeFirst();
    	list.removeFirst();

    	assertTrue( list.isEmpty() );
    }

    /**
     * Test the output of the removeLast() behavior, including expected exceptions
     */
    @Test
    public void testRemoveLast() {
    	    	
    	list.addLast( "a" );    	
    	list.addLast( "b" );
    	list.addLast( "c" );
    	list.addLast( "d" );
    	
    	list.removeLast();
    	assertEquals( "a", list.get( 0 ) );
    	assertEquals( "b", list.get( 1 ) );
    	assertEquals( "c", list.get( 2 ) );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.get( 3 ) );
    	
    	list.removeLast();
    	list.removeLast();
    	list.removeLast();

    	assertTrue( list.isEmpty() );
    }

    /**
     * Test the output of the set(index, e) behavior, including expected exceptions
     */
    @Test
    public void testSet() {
    	    	
    	list.addLast( "a" );    	
    	list.addLast( "b" );
    	list.addLast( "c" );
    	
    	assertEquals( "b", list.set( 1, "B" ) );
    	assertEquals( "B", list.get( 1 ) );
    	
    	assertThrows( IndexOutOfBoundsException.class, () -> list.set( -1, "no" ) );
    	assertThrows( IndexOutOfBoundsException.class, () -> list.set( 3, "d" ) );
    }
}
