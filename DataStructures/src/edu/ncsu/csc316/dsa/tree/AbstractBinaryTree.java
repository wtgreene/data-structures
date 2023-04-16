package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;
//import edu.ncsu.csc316.dsa.tree.LinkedBinaryTree.BinaryTreeNode;

/**
 * A skeletal implementation of the Binary Tree abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the binary tree abstract data type.
 * 
 * @author Dr. King
 * @author Will Greene
 *
 * @param <E> the type of elements stored in the binary tree
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    /**
     * Returns an {@link Iterable} collection of positions that represent the
     * inorder traversal of positions within the tree
     * 
     * @return a collection of positions that represent the tree's inorder traversal
     */
    @Override
    public Iterable<Position<E>> inOrder() {
    	PositionCollection traversal = new PositionCollection();
    	if ( !isEmpty() )
    		inOrderHelper( root(), traversal );
    	return traversal;
    }

    /**
     * Helper method for inOrder().
     * 
     * @param p position to add
     * @param traversal position collection
     */
    private void inOrderHelper(Position<E> p, PositionCollection traversal) {
    	
    	if ( left(p) != null )
    		inOrderHelper( left(p), traversal );
    	
    	traversal.add(p);
    	
    	if ( right(p) != null )
    		inOrderHelper( right(p), traversal );
    }
    
    /**
     * Returns the number of children a given position has.
     * 
     * @param p position
     * @return the number of children a given position has
     */
    @Override
    public int numChildren(Position<E> p) {
    	
    	if ( p == null )
    		return 0;
    	
    	if ( left(p) == null && right(p) == null )
    		return 0;
    	
    	if ( left(p) == null && right(p) != null )
    		return 1;
    	
    	if ( left(p) != null && right(p) == null )
    		return 1;
    	
    	return 2;
    	
//    	if ( left(p) == null && right(p) == null )
//    		return 0;
//    	
//    	if ( left(p) == null && right(p) != null && right(p).getElement() == null )
//    		return 0;
//    	
//    	if ( left(p) != null && right(p) == null && left(p).getElement() == null )
//    		return 0;
//    	    	
//    	if ( left(p).getElement() == null && right(p).getElement() == null )
//    		return 0;
//    	
//    	if ( left(p).getElement() == null && right(p).getElement() != null )
//    		return 1;
//    	
//    	if ( left(p).getElement() != null && right(p).getElement() == null )
//    		return 1;
//    	
//    	return 2;
    }
    
    /**
     * Returns the position that is the sibling of the provided position, p
     * 
     * @param p the position for which to return the sibling of the position
     * @return the position that is the sibling of the provided position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public Position<E> sibling(Position<E> p) {
    	
    	if ( p.equals(left(parent(p))) )
    		return right(parent(p));
    	
    	return left(parent(p));
    }
    
    /**
     * Returns a PositionCollection of the children of position.
     * 
     * @param p position
     * @return a PositionCollection of the children of position
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        PositionCollection childrenCollection = new PositionCollection();
        if (left(node) != null) {
            childrenCollection.add(left(node));
        }
        if (right(node) != null) {
            childrenCollection.add(right(node));
        }
        return childrenCollection;
    }
}
