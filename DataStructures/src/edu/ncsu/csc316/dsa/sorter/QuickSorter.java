package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
import java.util.Random;

/**
 * QuickSorter sorts arrays of comparable elements using the quicksort
 * algorithm. This implementation allows the client to specify a specific pivot
 * selection strategy: (a) use the first element as the pivot, (b) use the last
 * element as the pivot, (c) use the middle element as the pivot, or (d) use an
 * element at a random index as the pivot.
 * 
 * Using the randomized pivot selection strategy ensures O(nlogn)
 * expected/average case runtime when sorting n elements that are comparable
 * 
 * @author Dr. King
 * @author Will Greene
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class QuickSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

    /**
     * Pivot selection strategy that uses the element at the first index each time a
     * pivot must be selected
     */
    public static final PivotSelector FIRST_ELEMENT_SELECTOR = new FirstElementSelector();
    
    /**
     * Pivot selection strategy that uses the element at the last index each time a
     * pivot must be selected
     */
    public static final PivotSelector LAST_ELEMENT_SELECTOR = new LastElementSelector();
    
    /**
     * Pivot selection strategy that uses the element at the middle index each time
     * a pivot must be selected
     */
    public static final PivotSelector MIDDLE_ELEMENT_SELECTOR = new MiddleElementSelector();
    
    /**
     * Pivot selection strategy that uses the element at a randomly-chosen index
     * each time a pivot must be selected
     */
    public static final PivotSelector RANDOM_ELEMENT_SELECTOR = new RandomElementSelector();

    /** client's PivotSelector type */
    private PivotSelector selector;
	
    /**
    /**
     * Constructs a new QuickSorter with a provided custom Comparator and a
     * specified PivotSelector strategy
     * 
     * @param comparator a custom comparator to use when sorting
     * @param selector   the pivot selection strategy to use when selecting pivots
     */
    public QuickSorter(Comparator<E> comparator, PivotSelector selector) {
        super(comparator);
        setSelector(selector);
    }

    /**
     * Constructs a new QuickSorter using the natural ordering of elements. Pivots
     * are selected using the provided PivotSelector strategy
     * 
     * @param selector the pivot selection strategy to use when selecting pivots
     */
    public QuickSorter(PivotSelector selector) {
        this(null, selector);
    }

    /**
     * Constructs a new QuickSorter with a provided custom Comparator and the
     * default random pivot selection strategy
     * 
     * @param comparator a custom comparator to use when sorting
     */
    public QuickSorter(Comparator<E> comparator) {
        this(comparator, null);
    }

    /**
     * Constructs a new QuickSorter that uses an element's natural ordering and uses
     * the random pivot selection strategy
     */
    public QuickSorter() {
        this(null, null);
    }
    
    private void setSelector(PivotSelector selector) {
        if(selector == null) {
            this.selector = new RandomElementSelector();
        } else {
            this.selector = selector;
        }
    }

	/**
	 * Sorts an array of elements using quick sort.
	 * 
	 * @param data array of elements
	 */
	@Override
	public void sort(E[] data) {
		quickSort( data, 0, data.length - 1 );
	}
	
	
	private void quickSort( E[] data, int low, int high ) {
		
		if ( low < high ) {
			
			int pivotLocation = partition( data, low, high );
			quickSort( data, low, pivotLocation - 1  );
			quickSort( data, pivotLocation + 1, high );
		}
	}
	
	
	private int partition( E[] data, int low, int high ) {
		
		int pivotIndex = selector.selectPivot( low, high );
		
		swap( data, pivotIndex, high );
		
		return partitionHelper( data, low, high );
	}
	
	
	private int partitionHelper( E[] data, int low, int high ) {
		
		E pivot = data[ high ];
		int index = low;
		
		for ( int j = low; j < high; j++ ) {
			if ( compare( data[ j ], pivot ) <= 0 ) {
				swap( data, index, j );
				index++;
			}
		}
		
		swap( data, index, high );
		
		return index;
	}
	
	
	private void swap( E[] data, int one, int two ) {
		E temp = data[ one ];
		data[ one ] = data[ two ];
		data[ two ] = temp;
	}
	
    /**
     * Defines the behaviors of a PivotSelector
     * 
     * @author Dr. King
     *
     */
    private interface PivotSelector {
    	
        /**
         * Returns the index of the selected pivot element
         * 
         * @param low  - the lowest index to consider
         * @param high - the highest index to consider
         * @return the index of the selected pivot element
         */
        int selectPivot(int low, int high);
    }
    
    /**
     * FirstElementSelector chooses the first index of the array as the index of the
     * pivot element that should be used when sorting
     * 
     * @author Dr. King
     * @author Will Greene
     * 
     */
    public static class FirstElementSelector implements PivotSelector {

    	
        @Override
        public int selectPivot(int low, int high) {
            return low;
        }
    }
    
    /**
     * FirstElementSelector chooses the last index of the array as the index of the
     * pivot element that should be used when sorting
     * 
     * @author Dr.King
     * @author Will Greene
     *
     */
    public static class LastElementSelector implements PivotSelector {

    	
        @Override
        public int selectPivot(int low, int high) {
            return high;
        }
    }
    
    /**
     * FirstElementSelector chooses the "middle" index of the array as the index of the
     * pivot element that should be used when sorting
     * 
     * @author Dr. King
     * @author Will Greene
     *
     */
    public static class MiddleElementSelector implements PivotSelector {

    	
        @Override
        public int selectPivot(int low, int high) {
            return ( low + high ) / 2;
        }
    }
    
    /**
     * FirstElementSelector chooses a random index of the array as the index of the
     * pivot element that should be used when sorting
     * 
     * @author Dr. King
     * @author Will Greene
     *
     */
    public static class RandomElementSelector implements PivotSelector {

    	
        @Override
        public int selectPivot(int low, int high) {
        	Random rand = new Random();
        	return rand.nextInt( high - low + 1 ) + low;
        }
    }
}
