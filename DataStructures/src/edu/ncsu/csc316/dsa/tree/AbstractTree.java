package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;
import edu.ncsu.csc316.dsa.queue.Queue;

/**
 * A skeletal implementation of the Tree abstract data type. This class provides
 * implementation for common methods that can be implemented the same no matter
 * what specific type of concrete data structure is used to implement the tree
 * abstract data type.
 * 
 * @author Dr. King
 * @author Will Greene
 *
 * @param <E> the type of elements stored in the tree
 */
public abstract class AbstractTree<E> implements Tree<E> {
    
    /**
     * Returns true if the provided position has at least 1 child
     * 
     * @param p a position for which to determine if the position is an internal
     *          position of the tree
     * @return true if the provided position has at least 1 child, otherwise return
     *         false
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }
    
    /**
     * Returns true if the provided position has no children
     * 
     * @param p a position for which to determine if the position is a leaf position
     *          of the tree
     * @return true if the provided position has no childred, otherwise return false
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public boolean isLeaf(Position<E> p) {
        return numChildren(p) == 0;
    }
    
    /**
     * Returns true if the provided position is the root of the tree
     * 
     * @param p a position for which to determine if the position is the root of the
     *          tree
     * @return true if the provided position is the root of the tree, otherwise
     *         return false
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }
    
    /**
     * Returns true if the tree contains no elements, otherwise return false
     * 
     * @return true if the tree contains no elements, otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Updates the given position to have the provided element.
     * 
     * @param p       the position for which to update the element stored at that
     *                position
     * @param value the new element that should replace the existing element in
     *                the provided position
     * @return the original element that was replaced by the new element at the
     *         provided position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public E set(Position<E> p, E value) {    	
    	validate(p).setElement(value);
    	return value;
    }   
    
    /**
     * Returns an {@link Iterable} collection of positions that represent the
     * preorder traversal of positions within the tree
     * 
     * @return a collection of positions that represent the tree's preorder
     *         traversal
     */
    @Override
    public Iterable<Position<E>> preOrder() {
        PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
            preOrderHelper(root(), traversal);
        }
        return traversal;
    }

    /**
     * Helper method for preOrder().
     * 
     * @param p position to add
     * @param traversal position collection
     */
    private void preOrderHelper(Position<E> p, PositionCollection traversal) {
        traversal.add(p);
        for (Position<E> c : children(p)) {
            preOrderHelper(c, traversal);
        }
    }
    
    /**
     * Returns an {@link Iterable} collection of positions that represent the
     * postorder traversal of positions within the tree
     * 
     * @return a collection of positions that represent the tree's postorder
     *         traversal
     */
    @Override
    public Iterable<Position<E>> postOrder() {
        PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
            postOrderHelper(root(), traversal);
        }
        return traversal;
    }
    
    /**
     * Helper method for postOrder().
     * 
     * @param p position to add
     * @param traversal position collection
     */
    private void postOrderHelper(Position<E> p, PositionCollection traversal) {
        for (Position<E> c : children(p)) {
            postOrderHelper(c, traversal);
        }
    	traversal.add(p);
    }
    
    /**
     * Returns an {@link Iterable} collection of positions that represent the
     * levelorder traversal of positions within the tree
     * 
     * @return a collection of positions that represent the tree's levelorder
     *         traversal
     */
    @Override
    public Iterable<Position<E>> levelOrder() {
    	
    	PositionCollection traversal = new PositionCollection();
    	Queue<Position<E>> q = new ArrayBasedQueue<Position<E>>();

    	if ( isEmpty() )
    		return null;
    	
    	Position<E> p = root();
    	q.enqueue( p );
    	
    	while ( !q.isEmpty() ) {
    		p = q.dequeue();
    		traversal.add( p );
    		for ( Position<E> c : children(p) )
    			q.enqueue( c );
    	}
    	
    	return traversal;
    }
    
    /**
     * Safely casts a Position, p, to be an AbstractTreeNode.
     * 
     * @param p the position to cast to a AbstractTreeNode
     * @return a reference to the AbstractTreeNode
     * @throws IllegalArgumentException if p is null, or if p is not a valid
     *                                  AbstractTreeNode
     */
    protected abstract AbstractTreeNode<E> validate(Position<E> p);
    
    /**
     * Inner class of AbstractTree that establishes nodes.
     * 
     * @author Will Greene
     *
     * @param <E> element in node
     */
    protected abstract static class AbstractTreeNode<E> implements Position<E> {

    	/** element in node */
        private E element;
        
        /**
         * Constructs an AbstractTreeNode object.
         * 
         * @param element element in node
         */
        public AbstractTreeNode(E element) {
            setElement(element);
        }
        
        /**
         * Returns element in node.
         * @return element in node
         */
        @Override
        public E getElement() {
            return element;
        }
        
        /**
         * Sets the element.
         * 
         * @param element to set
         */
        public void setElement(E element) {
            this.element = element;
        }
    }
    
    /**
     * Returns a string representation of the tree.
     * @return a string representation of the tree
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[\n");
        toStringHelper(sb, "", root());
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Helper method for toString() regarding special formatting.
     * 
     * @param sb StringBuilder object
     * @param indent space characters
     * @param root beginning position
     */
    private void toStringHelper(StringBuilder sb, String indent, Position<E> root) {
        if(root == null) {
            return;
        }
        sb.append(indent).append(root.getElement()).append("\n");
        for(Position<E> child : children(root)) {
            toStringHelper(sb, indent + " ", child);
        }
    }
    
    /**
     * PositionCollection implements the {@link Iterable} interface to allow traversing
     * through the positions of the tree. PositionCollection does not allow removal
     * operations
     * 
     * @author Dr. King
     * @author Will Greene
     *
     */
    protected class PositionCollection implements Iterable<Position<E>> {

    	/** list of positions */
        private List<Position<E>> list;

        /**
         * Construct a new PositionCollection
         */
        public PositionCollection() {
            list = new SinglyLinkedList<Position<E>>();
        }

        /**
         * Add a position to the collection. Null positions or positions with null
         * elements are not added to the collection
         * 
         * @param position the position to add to the collection
         */
        public void add(Position<E> position) {
            if (position != null && position.getElement() != null) {
                list.addLast(position);
            }
        }

        /**
         * Return an iterator for the PositionCollection
         * @return an iterator for the PositionCollection
         */
        public Iterator<Position<E>> iterator() {
            return new PositionSetIterator();
        }

        /**
         * Inner class of PositionCollection that adds iterator functionality.
         * 
         * @author Will Greene
         *
         */
        private class PositionSetIterator implements Iterator<Position<E>> {

        	/** iterator */
            private Iterator<Position<E>> it;

            /**
             * Constructs a PositionSetIterator object.
             */
            public PositionSetIterator() {
                it = list.iterator();
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
             * @return the position
             * @throws NoSuchElementException if at the end of the list
             */
            @Override
            public Position<E> next() {
                return it.next();
            }

            /**
             * Removes the element that was last called by next().
             * 
             * @throws UnsupportedOperationException because functionality is not yet supported
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException("The remove operation is not supported yet.");
            }
        }
    }
}
