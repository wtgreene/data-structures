package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

    /** A reference to the dummy/sentinel node at the front of the list **/
    private LinkedListNode<E> front;
    
    /** A reference to the last/final node in the list **/
    private LinkedListNode<E> tail;
    
    /** The number of elements stored in the list **/
    private int size;
        
    /**
     * Constructs an empty singly-linked list
     */     
    public SinglyLinkedList() {
        front = new LinkedListNode<E>(null);
        tail = null;
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
    public void add( int index, E element ) {
    	
    	checkIndexForAdd( index );
    		
    	LinkedListNode<E> current = front;
    		
    	for ( int i = 0; i < index; i++ )
    		current = current.getNext();
    		
    	current.next = new LinkedListNode<E>( element, current.getNext() );
    	
    	if ( index == size() )
    		tail = current.getNext();
    	
    	size++;
    }
    
    /**
     * Removes and returns the element at the specified index of the list
     * 
     * @param index the index of the element to remove from the list
     * @return the element at the specified index of the list
     * @throws IndexOutOfBoundsException if the provided index is not a valid index
     *                                   based on the current state of the list
     */
    public E remove( int index ) {
    	
    	checkIndex( index );
    	
    	LinkedListNode<E> removed;
    	LinkedListNode<E> current = front;
    	
    	for ( int i = 0; i < index; i++ )
    		current = current.getNext();
    	
    	removed = current.getNext();
    	
    	current.next = current.getNext().getNext();
    	
    	size--;
    	
    	return removed.getElement();
    }
    
    /**
     * Returns the element at the end of the list (index n)
     * 
     * @return the element at the end of the list
     * @throws IndexOutOfBoundsException if the list is empty
     */
    @Override
    public E last() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return tail.getElement();
    }

    /**
     * Adds a new element to the end of the list (index n)
     * 
     * @param element the new element to add to the end of the list
     */  
    @Override
    public void addLast(E element) {
    	
    	if ( size() == 0 ) {
    		
    		front.next = new LinkedListNode<E>( element, null );
    		tail = front.getNext();
    	}
    	
    	else {
    		
    		tail.next = new LinkedListNode<E>( element, null );
        	tail = tail.getNext();
    	}
    	
    	size++;
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
    public E set( int index, E element ) {
    	
    	checkIndex( index );
    	
    	E replaced;
    	
    	LinkedListNode<E> current = front;
    	
    	for ( int i = 0; i < index; i++ )
    		current = current.getNext();
    	
    	replaced = current.getNext().getElement();
    	
    	current.getNext().setElement( element );
    	
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
     * Returns the element at the specified index of the list
     * 
     * @param index the index at which to retrieve the element
     * @return the element at the specified index of the list
     * @throws IndexOutOfBoundsException if the specified index is not a valid index
     *                                   based on the current state of the list
     */
    public E get( int index ) {
    	
    	checkIndex( index );
    	
    	LinkedListNode<E> current = front;
    	
    	for ( int i = 0; i < index; i++ )
    		current = current.getNext();
    	
    	return current.getNext().getElement();
    }
    
    /**
     * Returns an instance of ElementIterator.
     * @return an instance of ElementIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
    
    /**
     * Represents a singular node in a linked list.
     * 
     * @author Will Greene
     *
     * @param <E> element in a node
     */
    private static class LinkedListNode<E> {
        
    	/** element in node */
        private E data;
        /** next node in list */
        private LinkedListNode<E> next;
        
        /**
         * Constructs a LinkedListNode object - no next node.
         * 
         * @param element element in node
         */
        public LinkedListNode( E element ) {
        	this( element, null );
        }
        
        /**
         * Constructs a LinkedListNode object - with a next node.
         * 
         * @param element element in node
         * @param node next node in list
         */
        public LinkedListNode( E element, LinkedListNode<E> node ) {
        	setElement( element );
        	setNext( node );
        }
        
        /**
         * Returns the next node in the list.
         * @return the next node in the list
         */
        public LinkedListNode<E> getNext() {
        	return next;
        }
        
        /**
         * Returns the element in this node.
         * @return the element in this node
         */
        public E getElement() {
        	return data;
        }
        
        /**
         * Sets the next node in the list.
         * 
         * @param node next node in list
         */
        public void setNext( LinkedListNode<E> node ) {
        	next = node;
        }
        
        /**
         * Sets the element in this node.
         * 
         * @param element element to set
         */
        public void setElement( E element ) {
        	data = element;
        }
    }  
    
    /**
     * Inner class of ArrayBasedList that creates a specific type of iterator object.
     * 
     * @author Will Greene
     */
    private class ElementIterator implements Iterator<E> {
        /**
         * Keep track of the next node that will be processed
         */
        private LinkedListNode<E> current;
        
        /** 
         * Keep track of the node that was processed on the last call to 'next'
         */
        private LinkedListNode<E> previous;
        
        /**
         * Keep track of whether it's ok to remove an element (based on whether
         * next() has been called immediately before remove())
         */
//        private boolean removeOK;

        /**
         * Construct a new element iterator where the cursor is initialized 
         * to the beginning of the list.
         */
        public ElementIterator() {
        	
        	previous = front;
        	current = front.next;
        	
//            removeOK = false;
        }

        /**
         * Returns whether there is an element after the current position.
         * @return true if there is, false if not
         */
        @Override
        public boolean hasNext() {        	
        	return current != null;
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
        	
        	previous = previous.next;
        	current = current.next;
//        	removeOK = true;
        	return previous.getElement();
        }
         
        /**
         * Removes the element that was last called by next().
         * 
         * @throws UnsupportedOperationException because remove() is not supported
         */
        @Override    
        public void remove() {
            throw new UnsupportedOperationException(
                "This SinglyLinkedList implementation does not currently support removal of elements when using the iterator.");
        }
    }
}