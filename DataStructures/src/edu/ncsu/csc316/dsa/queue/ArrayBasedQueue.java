package edu.ncsu.csc316.dsa.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * The Array-based Queue is implemented as a circular array-based data structure
 * to support efficient, O(1) worst-case Queue abstract data type behaviors. The
 * internal array dynamically resizes using the doubling strategy to ensure O(1)
 * amortized cost for adding to the queue.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the queue
 */
public class ArrayBasedQueue<E> extends AbstractQueue<E> {

    /**
     * Internal array to store the data within the queue
     */
    private E[] data;

    /**
     * A reference to the index of the first element in the queue
     */
    private int front;

    /**
     * A reference to the index immediately after the last element in the queue
     */
    private int rear;

    /**
     * The number of elements stored in the queue
     */
    private int size;

    /**
     * The initial default capacity of the internal array that stores the data
     */
    private static final int DEFAULT_CAPACITY = 0;

    /**
     * Constructs a new array-based queue with the given initialCapcity for the
     * array
     * 
     * @param initialCapacity the initial capacity to use when creating the initial
     *                        array
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedQueue(int initialCapacity) {
        data = (E[]) (new Object[initialCapacity]);
        size = 0;
    }

    /**
     * Constructs a new array-based queue with the default initial capacity for the
     * array
     */
    public ArrayBasedQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * To ensure amortized O(1) cost for adding to the array-based queue, use the
     * doubling strategy on each resize. Here, we add +1 after doubling to handle
     * the special case where the initial capacity is 0 (otherwise, 0*2 would still
     * produce a capacity of 0).
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
            @SuppressWarnings("unchecked")
            E[] newData = (E[]) (new Object[newCapacity]);
            
            boolean firstPass = true;
            
            for ( int i = 0; i < data.length; i++ ) {
            	
            	if ( front != rear || firstPass )
            		newData[ i ] = data[ front++ ];
            	
            	if ( front >= size() )
            		front = 0;
            	
            	firstPass = false;
            }
            
            data = Arrays.copyOf( data, newCapacity );
            
            for ( int i = 0; i < oldCapacity; i++ )
            	data[ i ] = newData[ i ];
            
            front = 0;
            rear = size();
        }
    }

	/**
	 * Adds a new element to the back of the queue
	 * 
	 * @param element the new element to add to the queue
	 */
	public void enqueue(E element) {
		
		ensureCapacity( size() + 1 );
		
//		if ( size() == 0 ) {
//			front = 0;
//			rear = 0;
//		}
		
		data[ rear++ ] = element;
		
		size++;
		
		if ( rear >= data.length )
			rear = 0;		
	}

	/**
	 * Removes and returns the front/first element in the queue
	 * 
	 * @return the front/first element in the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public E dequeue() {
		
		if ( isEmpty() )
			throw new NoSuchElementException();
		
		E ret = data[ front++ ];
		
		size--;
		
		if ( front >= data.length )
			front = 0;
		
		return ret;
	}

	/**
	 * Returns (but does not remove) the front/first element in the queue
	 * 
	 * @return the front/first element in the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public E front() {
		
		if ( isEmpty() )
			throw new NoSuchElementException();
		
		return data[ front ];
	}

	/**
	 * Returns the number of elements stored in the queue
	 * 
	 * @return the number of elements stored in the queue
	 */
	public int size() {
		return size;
	}
}   