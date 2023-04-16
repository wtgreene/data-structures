package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Abstract class for comparison sort classes (bubble, insertion and insertion sort).
 * 
 * @author CSC 316 Teaching Staff
 * @author Will Greene (Javadoc)
 * @param <E> the generic type of data to sort
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	/** optional comparator used to specify sorting metric */
    private Comparator<E> comparator;
    
    /**
     * Constructs an AbstractComparisonSorter object.
     * 
     * @param comparator optional comparator used to specify sorting metric
     */
    public AbstractComparisonSorter(Comparator<E> comparator) {
        setComparator(comparator);
    }
    
    /**
     * Sets comparator type. If comparator is null, the objects (most likely Students) will be
     * sorted by their natural order - first by last name, then first name, then id number.
     * Change this description if the natural order metrics change.
     * 
     * @param comparator optional comparator used to specify sorting metric
     */
    private void setComparator(Comparator<E> comparator) {
        if(comparator == null) {
            this.comparator = new NaturalOrder();
        } else {
            this.comparator = comparator;
        }
    }   
    
    /**
	 * Compares two elements to determine order.
	 * 
	 * @param data1 first element
	 * @param data2 second element
	 * @return negative if data1 belongs before data2,
	 * 		   positive if data1 belongs after data2
	 */
	public int compare(E data1, E data2) {
	    return comparator.compare(data1,  data2);
	}

	/**
     * Inner class used to compare objects using natural order.
     * 
     * @author Will Greene
     */
    private class NaturalOrder implements Comparator<E> {
        public int compare(E first, E second) {
            return ((Comparable<E>) first).compareTo(second);
        }
    }
}
