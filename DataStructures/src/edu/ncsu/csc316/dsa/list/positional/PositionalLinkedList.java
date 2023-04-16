package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

    /** A dummy/sentinel node representing at the front of the list **/
    private PositionalNode<E> front;

    /** A dummy/sentinel node representing at the end/tail of the list **/
    private PositionalNode<E> tail;

    /** The number of elements in the list **/
    private int size;

    /**
     * Constructs an empty positional linked list
     */
    public PositionalLinkedList() {
        front = new PositionalNode<E>(null);
        tail = new PositionalNode<E>(null, null, front);
        front.setNext(tail);
        size = 0;
    }    
    
    /**
     * Adds an element between two nodes.
     * 
     * @param element element to add
     * @param next node after
     * @param prev node before
     * @return node / position of element
     */
    private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {
		
	    PositionalNode<E> node = new PositionalNode<E>( element, next, prev );
	    
	    next.previous = node;
	    prev.next = node;
	    
	    size++;
	    
	    return node;
	}
    
	/**
	 * The number of elements in the list
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {
		return size;
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
	 * Returns a new Iterable collection of list Positions
	 * 
	 * @return a new Iterable collection of list positions
	 */
	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/**
	 * Add a new element into a new position that should be added immediately after
	 * the specified position, p
	 * 
	 * @param p       the position that should be located before the new position
	 *                that will be created
	 * @param element the element to be added to the list
	 * @return a reference to the Position that was created to store the new element
	 * @throws IllegalArgumentException if the provided position, p, is not a valid
	 *                                  position
	 */
	public Position<E> addAfter( Position<E> p, E element ) {
		
		PositionalNode<E> node = validate( p );
		
		return addBetween( element, node.getNext(), node );
	}

	/**
	 * Add a new element into a new position that should be added immediately before
	 * the specified position, p
	 * 
	 * @param p       the position that should be located after the new position
	 *                that will be created
	 * @param element the element to be added to the list
	 * @return a reference to the Position that was created to store the new element
	 * @throws IllegalArgumentException if the provided position, p, is not a valid
	 *                                  position
	 */
	public Position<E> addBefore( Position<E> p, E element ) {
    	
    	PositionalNode<E> node = validate( p );
    	
    	return addBetween( element, node, node.getPrevious() );
    }
    
	/**
	 * Add a new element into a new position at the front of the list
	 * 
	 * @param element the element to be added to the front of the list
	 * @return a reference to the Position that was created at the front of the list
	 *         to store the new element
	 */
    public Position<E> addFirst( E element ) {
    	return addBetween( element, front.getNext(), front );
    }
    
	/**
	 * Add a new element into a new position at the end of the list
	 * 
	 * @param element the element to be added to the end of the list
	 * @return a reference to the Position that was created at the end of the list
	 *         to store the new element
	 */
    public Position<E> addLast( E element ) {
    	return addBetween( element, tail, tail.getPrevious() );
    }
    
	/**
	 * Returns a reference to the Position that is located in the list immediately
	 * after the given position, p. Return null if p is at the end of the list.
	 * 
	 * @param p the position for which to retrieve the position located after
	 * @return a reference to the Position that is located in the list immediately
	 *         after the given position, p
	 * @throws IllegalArgumentException if the provided position, p, is not a valid
	 *                                  position
	 */
    public Position<E> after( Position<E> p ) {
    	
    	if ( validate( p ).getNext().getElement() == null )
    		return null;
    	
    	return validate( p ).getNext();
    }
    
	/**
	 * Returns a reference to the Position that is located in the list immediately
	 * before the given position, p. Return null if p is at the front of the list.
	 * 
	 * @param p the position for which to retrieve the position located before
	 * @return a reference to the Position that is located in the list immediately
	 *         before the given position, p
	 * @throws IllegalArgumentException if the provided position, p, is not a valid
	 *                                  position
	 */
    public Position<E> before( Position<E> p ) {
    	
    	if ( validate( p ).getPrevious().getElement() == null )
    		return null;
    	
    	return validate( p ).getPrevious();
    }
    
	/**
	 * Returns a reference to the first Position in the list
	 * 
	 * @return a reference to the first position in the list
	 */
    public Position<E> first() {
    	
    	if ( isEmpty() )
    		return null;
    	
    	return front.getNext();
    }
    
	/**
	 * Returns true if the list is empty, otherwise return false. Return null if the
	 * list is empty.
	 * 
	 * @return true if the list is empty, otherwise return false
	 */
    public boolean isEmpty() {
		return size == 0;
	}


	/**
	 * Returns a reference to the last/final Position in the list. Return null if
	 * the list is empty.
	 * 
	 * @return a reference to the last position in the list
	 */
	public Position<E> last() {
		
		if ( isEmpty() )
			return null;
		
    	return tail.getPrevious();
    }
    
	/**
	 * Removes the position p from the list and returns the element stored at p.
	 * 
	 * @param p the position to remove from the list
	 * @return the element stored at p
	 * @throws IllegalArgumentException if the provided position, p, is not a valid
	 *                                  position
	 */
    public E remove( Position<E> p ) {
    	
    	PositionalNode<E> removed = validate( p );
    	
    	removed.previous.next = removed.getNext();
    	removed.next.previous = removed.getPrevious();
    	
    	size--;
    	
    	return removed.getElement();
    }
    
	/**
	 * Updates the element in a given position, p, to a new element.
	 * 
	 * @param p       the position in which to update the element
	 * @param element the new element that will overwrite the existing element
	 * @return the original element that was replaced by the new element
	 * @throws IllegalArgumentException if the provided position, p, is not a valid
	 *                                  position
	 */
    public E set( Position<E> p, E element ) {
    	
    	PositionalNode<E> node = validate( p );
    	
    	E replaced = node.getElement();
    	
    	node.setElement( element );
    	
    	return replaced;
    }
    
    /**
     * Safely casts a Position, p, to be a PositionalNode.
     * 
     * @param p the position to cast to a PositionalNode
     * @return a reference to the PositionalNode
     * @throws IllegalArgumentException if p is null, or if p is not a valid
     *                                  PositionalNode
     */
    private PositionalNode<E> validate(Position<E> p) {
        if (p instanceof PositionalNode) {
            return (PositionalNode<E>) p;
        }
        throw new IllegalArgumentException("Position is not a valid positional list node.");
    }
    
    /**
     * Represents a singular node in a linked list.
     * 
     * @author Will Greene
     *
     * @param <E> element in a node
     */
    private static class PositionalNode<E> implements Position<E> {

    	/** element in node */
        private E element;
        /** next node in list */
        private PositionalNode<E> next;
        /** previous node in list */
        private PositionalNode<E> previous;

        /**
         * Constructs a PositionNode object - no next or previous node.
         * 
         * @param value element in node
         */
        public PositionalNode(E value) {
            this(value, null);
        }

        /**
         * Constructs a PositionalNode object - with next node but no previous node.
         * 
         * @param value element in node
         * @param next next node in list
         */
        public PositionalNode(E value, PositionalNode<E> next) {
            this(value, next, null);
        }

        /**
         * Constructs a PositionalNode object with next and previous node.
         * 
         * @param value element in node
         * @param next next node in list
         * @param prev previous node in list
         */
        public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
            setElement(value);
            setNext(next);
            setPrevious(prev);
        }

        /**
         * Sets previous node.
         * 
         * @param prev previous node
         */
        public void setPrevious(PositionalNode<E> prev) {
            previous = prev;
        }

        /**
         * Returns previous node.
         * @return previous node
         */
        public PositionalNode<E> getPrevious() {
            return previous;
        }
        
        /**
         * Sets next node.
         * 
         * @param next next node
         */
        public void setNext(PositionalNode<E> next) {
            this.next = next;
        }

        /**
         * Returns next node.
         * @return next node
         */
        public PositionalNode<E> getNext() {
            return next;
        }

        /**
         * Returns the element in this node.
         * @return the element in this node
         */
        @Override
        public E getElement() {
            return element;
        }
        
        /**
         * Sets the element in this node.
         * 
         * @param element element to set
         */
        public void setElement(E element) {
            this.element = element;
        }
    }
    
    /**
     * Inner class that creates a specific type of iterator object.
     * 
     * @author Will Greene
     */
    private class PositionIterator implements Iterator<Position<E>> {

    	/** current position in list */
        private Position<E> current;
        /** flag for whether a node may be removed */
        private boolean removeOK;

        /**
         * Construct a new position iterator where the position is initialized 
         * to the beginning of the list.
         */
        public PositionIterator() {        	
        	current = front ;
        	removeOK = false;
        }

        /**
         * Returns whether there is an element after the current position.
         * @return true if there is, false if not
         */
        @Override
        public boolean hasNext() {        	
        	return validate( current ).getNext() != tail;
        }

        /**
         * Moves the position to the next element in the list.
         * 
         * @return the position
         * @throws NoSuchElementException if at the end of the list
         */
        @Override
        public Position<E> next() {
        	
        	if ( !hasNext() )
        		throw new NoSuchElementException();
        	
        	current = validate( current ).getNext();
        	
        	removeOK = true;
        	
        	return current;
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
        	
        	PositionalLinkedList.this.remove( current );
        	        	
        	removeOK = false;
        }
    }
    
    /**
     * Inner class that creates a specific type of iterator object.
     * 
     * @author Will Greene
     */
    private class ElementIterator implements Iterator<E> {

    	/** iterator instance */
        private Iterator<Position<E>> it;

        /**
         * Constructs an element iterator object.
         */
        public ElementIterator() {
            it = new PositionIterator();
        }

        /**
         * Returns whether there is an element after the current position.
         * @return true if there is, false if not
         */
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        /**
         * Moves the position to the next element in the list.
         * 
         * @return the element
         */
        @Override
        public E next() {
            return it.next().getElement();
        }

        /**
         * Removes the element that was last called by next().
         */
        @Override
        public void remove() {
            it.remove();
        }
    }
    
    /**
     * Inner class that creates a specific type of iterable object.
     * 
     * @author Will Greene
     */
    private class PositionIterable implements Iterable<Position<E>> {
        
    	/**
    	 * Returns an instance of a PositionIterator.
    	 * @return an instance of a PositionIterator
    	 */
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }
}
