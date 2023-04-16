package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * The LinkedBinaryTree is implemented as a linked data structure to support
 * efficient Binary Tree abstract data type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The LinkedBinaryTree class is based on the implementation developed for use
 * with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the binary tree
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	/** tree root */
    private BinaryTreeNode<E> root;
    /** tree size */
    private int size;

    /**
     * Create a new empty binary tree
     */
    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }
    
    /**
     * Safely casts a Position, p, to be a BinaryTreeNode.
     * 
     * @param p the position to cast to a BinaryTreeNode
     * @return a reference to the BinaryTreeNode
     * @throws IllegalArgumentException if p is null, or if p is not a valid
     *                                  BinaryTreeNode
     */
    protected BinaryTreeNode<E> validate(Position<E> p) {
        if (!(p instanceof BinaryTreeNode)) {
            throw new IllegalArgumentException("Position is not a valid linked binary tree node");
        }
        return (BinaryTreeNode<E>) p;
    }

    /**
     * A BinaryTreeNode stores an element and references the node's parent, left
     * child, and right child
     * 
     * @author Dr. King
     *
     * @param <E> the type of element stored in the node
     */
    public static class BinaryTreeNode<E> extends AbstractTreeNode<E> {
    	
    	/** parent of node */
        private BinaryTreeNode<E> parent;
        /** left child of node */
        private BinaryTreeNode<E> left;
        /** right child of node */
        private BinaryTreeNode<E> right;

        /**
         * Constructs a new BinaryTreeNode with the provided element
         * 
         * @param element the element to store in the node
         */
        public BinaryTreeNode(E element) {
            this(element, null);
        }

        /**
         * Constructs a new BinaryTreeNode with the provided element and provided parent
         * reference
         * 
         * @param element the element to store in the node
         * @param parent  the parent of the newly created node
         */
        public BinaryTreeNode(E element, BinaryTreeNode<E> parent) {
            super(element);
            setParent(parent);
        }

        /**
         * Returns the left child of the current node
         * 
         * @return the left child of the current node
         */
        public BinaryTreeNode<E> getLeft() {
            return left;
        }

        /**
         * Returns the right child of the current node
         * 
         * @return the right child of the current node
         */
        public BinaryTreeNode<E> getRight() {
            return right;
        }

        /**
         * Sets the left child of the current node
         * 
         * @param left the node to set as the left child of the current node
         */
        public void setLeft(BinaryTreeNode<E> left) {
            this.left = left;
        }

        /**
         * Sets the right child of the current node
         * 
         * @param right the node to set as the right child of the current node
         */
        public void setRight(BinaryTreeNode<E> right) {
            this.right = right;
        }

        /**
         * Returns the parent of the current node
         * 
         * @return the parent of the current node
         */
        public BinaryTreeNode<E> getParent() {
            return parent;
        }

        /**
         * Sets the parent of the current node
         * 
         * @param parent the node to set as the parent of the current node
         */
        public void setParent(BinaryTreeNode<E> parent) {
            this.parent = parent;
        }
    }

    /**
     * Returns the position that is the left child of the provided position, p
     * 
     * @param p the position for which to return the left child of the position
     * @return the position that is the left child of the provided position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public Position<E> left(Position<E> p) {
        BinaryTreeNode<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the position that is the right child of the provided position, p
     * 
     * @param p the position for which to return the right child of the position
     * @return the position that is the right child of the provided position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public Position<E> right(Position<E> p) {
        BinaryTreeNode<E> node = validate(p);
        return node.getRight();
    }

    /**
     * Returns a reference to the new tree position that is created to store the
     * given element. The newly created position is added as the left child of the
     * provided position.
     * 
     * @param p       the position for which to add a new left child
     * @param value the element to add to the tree in the newly created position
     * @return the position that is created as the left child of the provided
     *         position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     * @throws IllegalArgumentException if the provided position already has an
     *                                  existing left child
     */
    @Override
    public Position<E> addLeft(Position<E> p, E value) {
        BinaryTreeNode<E> node = validate(p);
        if (left(node) != null) {
            throw new IllegalArgumentException("Node already has a left child.");
        }
        
        size++;
        
        BinaryTreeNode<E> newNode = createNode( value, node, null, null );
        node.setLeft( newNode );
    	return newNode;
    }

    /**
     * Returns a reference to the new tree position that is created to store the
     * given element. The newly created position is added as the right child of the
     * provided position.
     * 
     * @param p       the position for which to add the new right child
     * @param value the element to add to the tree in the newly created position
     * @return the position that is created as the right child of the provided
     *         position
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     * @throws IllegalArgumentException if the provided position already has an
     *                                  existing right child
     */
    @Override
    public Position<E> addRight(Position<E> p, E value) {
        BinaryTreeNode<E> node = validate(p);
        if (right(node) != null) {
            throw new IllegalArgumentException("Node already has a right child.");
        }
        
        size++;
        
        BinaryTreeNode<E> newNode = createNode( value, node, null, null );
        node.setRight( newNode );
    	return newNode;
    }

    /**
     * Returns a reference to the root position of the tree
     * 
     * @return the root position of the tree
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns a reference to the parent of the provided position, p
     * 
     * @param p a position for which to retrieve the position's parent
     * @return the parent of the provided position, p
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     */
    @Override
    public Position<E> parent(Position<E> p) {
    	
//    	if ( p == null )
//    		return null;
    	
        BinaryTreeNode<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns a reference to the new root position of the tree that is created to
     * store the given element
     * 
     * @param value the element to add to the tree
     * @return the root position that is created to store the element
     * @throws IllegalArgumentException if the tree already has an existing root
     *                                  position
     */
    @Override
    public Position<E> addRoot(E value) {
        if (root() != null) {
            throw new IllegalArgumentException("The tree already has a root.");
        }
        this.root = createNode(value, null, null, null);
        size++;
        return root;
    }

    /**
     * Removes the provided position from the tree. Returns the element that was
     * stored in the position that is removed.
     * 
     * @param p the position for which to remove from the tree
     * @return the element that was stored in the position that is removed
     * @throws IllegalArgumentException if the position, p, does not represent a
     *                                  valid tree position
     * @throws IllegalArgumentException if removal of the position is not allowed
     */
    @Override
    public E remove(Position<E> p) {
    	
    	if ( p == null )
    		return null;
    	
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("The node has two children");
        
        BinaryTreeNode<E> node = validate(p);
        
        E ret = node.getElement();
        
        // special case (root)
        if ( node.getParent() == null ) {
        	
        	if ( node.getLeft() == null ) {
        		// set root to right(node)
//        		setRoot( node.getRight() );
//        		setRoot( null );
        		if ( node.getRight() != null ) {
        			node.getRight().setParent(null);
        			setRoot( node.getRight() );
        			size = size - 2;
        			return ret; // something
        		}
        		
        		node.setElement(null);
        		size--;
        		return ret;
        	}
        	
        	if ( node.getRight() == null ) {
        		// set root to left(node)
//        		setRoot( node.getLeft() );
//        		setRoot( null );
        		node.getLeft().setParent(null);
        		setRoot( node.getLeft() );
        		size = size - 2;
        		return ret; // something
        	}
        }
        
        else if ( numChildren(p) == 0 ) {
        	if ( node.equals(node.getParent().getRight()) ) {
        		node.getParent().setRight(null);
        	}
        	if ( node.equals(node.getParent().getLeft()) ) {
        		node.getParent().setLeft(null);
        	}
        }
        
        else if ( node.getLeft() == null && node.equals(node.getParent().getLeft()) ) {
        	node.getParent().setLeft( node.getRight() );
        	node.getRight().setParent( node.getParent() );
        } else if ( node.getLeft() == null && node.equals(node.getParent().getRight()) ) {
        	node.getParent().setRight( node.getRight() );
        	node.getRight().setParent( node.getParent() );
        } else if ( node.getRight() == null && node.equals(node.getParent().getLeft()) ) {
        	node.getParent().setLeft( node.getLeft() );
        	node.getLeft().setParent( node.getParent() );
        } else if ( node.getRight() == null && node.equals(node.getParent().getRight()) ) {
        	node.getParent().setRight( node.getLeft() );
        	node.getLeft().setParent( node.getParent() );
        }
        
        if ( ret != null )
        	size = size - 2;
        
//        if ( node.getLeft() == null && node.getRight() == null ) {
//        	
//        }
        
//        int children = numChildren(p);
//        children = children + 1;
        
//        if ( node.getParent() == null ) {
//        	
//        	
//        }
        
//        /* else */ if ( numChildren(p) == 0 ) {
        	
//        	if ( node.getParent() == null ) {
//        		root = null;
//        		size--;
//        		return ret;
        	
//        	if ( node.equals(left(parent(node))) )
//        		validate(parent(node)).setLeft( null );
//        	
//        	else if ( node.equals(right(parent(node))) )
//        		validate(parent(node)).setRight( null );
//        	
//        	else
//        		return null;
//        }
        
//        else if ( node.equals(left(parent(node))) ) {
//        	
//        	if ( node.getLeft() != null ) {
//        		validate(parent(node)).setLeft( node.getLeft() );
//        		validate(node.getLeft()).setParent( validate(parent(node)) );
//        	}
//        	
//        	if ( node.getRight() != null ) {
//        		validate(parent(node)).setLeft( node.getRight() );
//        		validate(node.getRight()).setParent( validate(parent(node)) );
//        	}
//        }
//        
//        else if ( node.equals(right(parent(node))) ) {
//        	
//        	if ( node.getLeft() != null ) {
//        		validate(parent(node)).setRight( node.getLeft() );
//        		validate(node.getLeft()).setParent( validate(parent(node)) );
//        	}
//        	
//        	if ( node.getRight() != null ) {
//        		validate(parent(node)).setRight( node.getRight() );
//        		validate(node.getRight()).setParent( validate(parent(node)) );
//        	}
//        }
//        
//        else
//        	return null;
        
        return ret;
    }

    /**
     * Return the number of elements stored in the tree
     * 
     * @return the number of elements stored in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a newly created node.
     * 
     * @param e element in node
     * @param parent node parent
     * @param left left child of node
     * @param right right child of node
     * @return a newly created node
     */
    protected BinaryTreeNode<E> createNode(E e, BinaryTreeNode<E> parent, BinaryTreeNode<E> left,
            BinaryTreeNode<E> right) {
        BinaryTreeNode<E> newNode = new BinaryTreeNode<E>(e);
        newNode.setParent(parent);
        newNode.setLeft(left);
        newNode.setRight(right);
        return newNode;
    }

    // setRoot is needed for a later lab...
    // ...but THIS DESIGN IS BAD! If a client arbitrarily changes
    // the root by using the method, the size may no longer be correct/valid.
    // Instead, the precondition for this method is that
    // it should *ONLY* be used when rotating nodes in 
    // balanced binary search trees. We could instead change
    // our rotation code to not need this setRoot method, but that
    // makes the rotation code messier. For the purpose of this lab,
    // we will sacrifice a stronger design for cleaner/less code.
    protected Position<E> setRoot(Position<E> p) {
        root = validate(p);
        return root;
    }
}
