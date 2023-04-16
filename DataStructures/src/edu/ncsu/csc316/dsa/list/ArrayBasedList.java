package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 * 
 * @author Dr. King
 * @author Will Greene
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {

    /**
     * The initial capacity of the list if the client does not provide a capacity
     * when constructing an instance of the array-based list
     **/
    private final static int DEFAULT_CAPACITY = 0;

    /** The array in which elements will be stored **/
    private E[] data;

    /** The number of elements stored in the array-based list data structure **/
    private int size;

    /**
     * Constructs a new instance of an array-based list data structure with the
     * default initial capacity of the internal array
     */
    public ArrayBasedList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new instance of an array-based list data structure with the
     * provided initial capacity
     * 
     * @param capacity the initial capacity of the internal array used to store the
     *                 list elements
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedList(int capacity) {
        data = (E[]) (new Object[capacity]);
        size = 0;
    }
    
    /**
     * Adds a new element to the list at the specified index.
     * 
     * @param index   the index at which to add the new element to the list
     * @param element the new element to add to the list
     * @throws IndexOutOfBoundsException if the provided index is not a valid index
     *                                   based on the current state of the list
     */
    @Override
    public void add( int index, E element ) {
    	
    	checkIndexForAdd( index );
    	ensureCapacity( size() + 1 );
    	
    	for ( int i = size(); i > index; i-- )
    		data[ i ] = data[ i - 1 ];
    	
    	data[ index ] = element;
    	
    	size++;
    }
    
    /**
     * Returns an instance of ElementIterator.
     * @return an instance of ElementIterator
     */
    public Iterator<E> iterator() {
    	return new ElementIterator();
    }
    
	/**
	 * To ensure amortized O(1) cost for adding to the end of the array-based list,
	 * use the doubling strategy on each resize. Here, we add +1 after doubling to
	 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
	 * still produce a capacity of 0).
	 * 
	 * @param minCapacity the minimium capacity that must be supported by the
	 *                    internal array
	 */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = data.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 2) + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }
    
    /**
     * Returns the element at the specified index of the list
     * 
     * @param index the index at which to retrieve the element
     * @return the element at the specified index of the list
     * @throws IndexOutOfBoundsException if the specified index is not a valid index
     *                                   based on the current state of the list
     */
    @Override
    public E get( int index ) {
    	
    	if ( index < 0 || index >= size() )
    		throw new IndexOutOfBoundsException();
    	
    	return data[ index ];
    }
    
    /**
     * Removes and returns the element at the specified index of the list
     * 
     * @param index the index of the element to remove from the list
     * @return the element at the specified index of the list
     * @throws IndexOutOfBoundsException if the provided index is not a valid index
     *                                   based on the current state of the list
     */
    @Override
    public E remove( int index ) {
    	
    	checkIndex( index );
    	
    	E removed = data[ index ];
    	
    	for ( int i = index; i < size() - 1; i++ )
    		data[ i ] = data[ i + 1 ];
    	
    	data[ size() - 1 ] = null;
    	
    	size--;
    	
    	return removed;
    }
    
    /**
     * Updates the element at the specified index of the list
     * 
     * @param index   the index at which an existing element should be updated
     * @param element the new element to store are the provided index
     * @return the original element that was replaced by the updated element
     * @throws IndexOutOfBoundsException if the provided index is not a valid index
     *                                   based on the current state of the list
     */
    @Override
    public E set( int index, E element ) {
    	
    	checkIndex( index );
    	
    	E replaced = data[ index ];
    	
    	data[ index ] = element;
    	
    	return replaced;
    }
    
    /**
     * Returns the number of elements in the list
     * 
     * @return the number of elements in the list
     */
    public int size() {
    	return size;
    }
    
    /**
     * Inner class of ArrayBasedList that creates a specific type of iterator object.
     * 
     * @author Will Greene
     */
    private class ElementIterator implements Iterator<E> {
    	
    	/** position in list */
        private int position;
        /** ok to remove flag */
        private boolean removeOK;

        /**
         * Construct a new element iterator where the cursor is initialized 
         * to the beginning of the list.
         */
        public ElementIterator() {
            position = 0;
            removeOK = false;
        }

        /**
         * Returns whether there is an element after the current position.
         * @return true if there is, false if not
         */
        @Override
        public boolean hasNext() {
            return position < size();
        }

        /**
         * Moves the position to the next element in the list.
         * 
         * @return the element
         * @throws NoSuchElementException if at the end of the list
         */
        @Override
        public E next() {
        	
            if ( !hasNext() )
            	throw new NoSuchElementException();
                        
            position++;
            removeOK = true;
            
            return get( position - 1 );
        }
        
        /**
         * Removes the element that was last called by next().
         * 
         * @throws IllegalStateException if next() has not been called, or
         * 			if next() has not been called since the last remove() call
         */
        @Override
        public void remove() {
        	
        	if ( !removeOK )
            	throw new IllegalStateException();

        	ArrayBasedList.this.remove( position - 1 );
        	        	
            position--;
            removeOK = false;
        }
    }
}
