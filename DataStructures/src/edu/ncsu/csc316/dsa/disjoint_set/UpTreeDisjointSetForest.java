package edu.ncsu.csc316.dsa.disjoint_set;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;

/**
 * The UpTreeDisjointSetForest is implemented as a forest of linked up-trees.
 * Using balanced union, {@link DisjointSetForest#union} has worst-case runtime
 * of O(1). Using path-compression find, {@link DisjointSetForest#find} has
 * worst-case O(logn), but over time has worst-case runtime O(log*(n))
 * [log-star].
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the disjoint set
 */
public class UpTreeDisjointSetForest<E> implements DisjointSetForest<E> {

    // We need a secondary map to quickly locate an entry within the forest of
    // up-trees
    // NOTE: The textbook implementation does not include this
    // functionality; instead, the textbook implementation leaves
    // the responsibility of tracking positions to the client in a
    // separate map structure
    private Map<E, UpTreeNode<E>> map;

    /**
     * Constructs a new DisjointSetForest
     */
    public UpTreeDisjointSetForest() {
        // Use an efficient map!
        map = new LinearProbingHashMap<E, UpTreeNode<E>>();
    }

    /**
     * An UpTreeNode maintains an element, a reference to the node's parent, and (if
     * it's the root of an up-tree) the number of nodes stored within that up-tree.
     * 
     * @author Dr. King
     *
     * @param <E>
     */
    private static class UpTreeNode<E> implements Position<E> {

        private E element;
        private UpTreeNode<E> parent;
        private int count;

        /**
         * Constructs a new UpTreeNode with the given element, a reference to itself as
         * the parent, and a count of 1.
         * 
         * @param element the element to store in the new UpTreeNode
         */
        public UpTreeNode(E element) {
            setElement(element);
            setParent(this);
            setCount(1);
        }

        /**
         * Sets the element of the UpTreeNode to the given element
         * 
         * @param element the element to store in the UpTreeNode
         */
        public void setElement(E element) {
            this.element = element;
        }

        @Override
        public E getElement() {
            return element;
        }

        /**
         * Sets the parent of the UpTreeNode to the given UpTreeNode
         * 
         * @param parent the UpTreeNode to set as the current node's parent
         */
        public void setParent(UpTreeNode<E> parent) {
            this.parent = parent;
        }

        /**
         * Returns a reference to the parent of the current UpTreeNode
         * 
         * @return a reference to the parent of the current UpTreeNode
         */
        public UpTreeNode<E> getParent() {
            return parent;
        }

        /**
         * Sets the number of nodes contained in the UpTree rooted at the current
         * UpTreeNode
         * 
         * @param count
         */
        public void setCount(int count) {
            this.count = count;
        }

        /**
         * If the current UpTreeNode is the root of an up-tree, returns the number of
         * elements stored within the UpTree. Otherwise, if the current UpTreeNode is
         * not the root of an up-tree, count is undefined.
         * 
         * @return the number of elements stored within the UpTree, if the current
         *         UpTreeNode is the root; otherwise, count is undefined.
         */
        public int getCount() {
            return count;
        }
    }

    /**
     * Creates a new disjoint set to store the given element, and returns a
     * reference to the position that contains the given element
     * 
     * @param value the element that will be contained in the new disjoint set
     * @return a reference to the position that contains the given element and
     *         represents the new disjoint set
     */
    @Override
    public Position<E> makeSet(E value) {
    	UpTreeNode<E> node = new UpTreeNode<E>(value);
    	map.put(value, node);
    	return node;
    }

    /**
     * Returns a reference to the position that identifies the disjoint set that
     * contains the given element
     * 
     * @param value the element for which to locate
     * @return the position that identifies the disjoint set that contains the given
     *         element
     */
    @Override
    public Position<E> find(E value) {
        // NOTE: The textbook solution requires the client to keep
        // track of the location of each position in the forest.
        // Our implementation includes a Map to handle this for the
        // client, so we should allow the client to find the set
        // that contains a node by specifying the element
    	
    	UpTreeNode<E> node = validate( map.get(value) );
    	return findHelper(node);
    }

    private UpTreeNode<E> findHelper(UpTreeNode<E> current) {
    	
    	if ( !current.getParent().getElement().equals(current.getElement()) )
    		current.setParent( findHelper(current.getParent()) );
    	
    	return current.getParent();
    }

    /**
     * Unions two disjoint sets together into a single disjoint set
     * 
     * @param s the position that identifies the first disjoint set for the union
     * @param t the position that identifies the second disjoint set for the union
     */
    @Override
    public void union(Position<E> s, Position<E> t) {
    	
        UpTreeNode<E> a = validate(s);
        UpTreeNode<E> b = validate(t);
        
        a = validate( find(a.getElement()) );
        b = validate( find(b.getElement()) );
        	
        if ( a.getCount() > b.getCount() ) {
        	a.setCount( a.getCount() + b.getCount() );
        	b.setParent(a);
        }
        
        else {
        	b.setCount( a.getCount() + b.getCount() );
        	a.setParent(b);
        }
    }

    private UpTreeNode<E> validate(Position<E> p) {
        if (!(p instanceof UpTreeNode)) {
            throw new IllegalArgumentException("Position is not a valid up tree node.");
        }
        return (UpTreeNode<E>) p;
    }
}
