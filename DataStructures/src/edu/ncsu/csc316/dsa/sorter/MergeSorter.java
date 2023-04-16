package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * MergeSorter sorts arrays of comparable elements using the merge sort
 * algorithm. This implementation ensures O(nlogn) worst-case runtime to sort an
 * array of n elements that are comparable.
 * 
 * @author Dr. King
 * @author Will Greene
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

    /**
     * Constructs a new MergeSorter with a specified custom Comparator
     * 
     * @param comparator a custom Comparator to use when sorting
     */
    public MergeSorter(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * Constructs a new MergeSorter with comparisons based on the element's natural
     * ordering
     */ 
    public MergeSorter() {
        this(null);
    }

	/**
	 * Sorts an array of elements using merge sort.
	 * 
	 * @param data array of elements
	 */
	@Override
	public void sort(E[] data) {

		if ( data.length < 2 )
			return;
		
		int mid = data.length / 2;
						
		@SuppressWarnings( "unchecked" )
		E[] left = ( E[] ) ( new Comparable[ mid ] );
		@SuppressWarnings( "unchecked" )		
		E[] right = ( E[] ) ( new Comparable[ data.length - mid ] );
		
		for ( int i = 0; i < mid; i++ )
			left[ i ] = data[ i ];
		
		for ( int i = mid; i < data.length; i++ )
			right[ i - mid ] = data[ i ];
		
		sort( left );
		sort( right );
		
		merge( left, right, data );
	}
    
	/**
	 * Helper method for sort().
	 * 
	 * @param left "left" side of the array
	 * @param right "right" side of the array
	 * @param data full array
	 */
    private void merge( E[] left, E[] right, E[] data ) {
    	
    	int leftIndex = 0;
    	int rightIndex = 0;
    	
    	while ( leftIndex + rightIndex < data.length ) {
    		    		
    		if ( rightIndex == right.length || ( leftIndex < left.length && compare(left[ leftIndex ], right[ rightIndex ] ) < 0 ) ) {
    			data[ leftIndex + rightIndex ] = left [ leftIndex ];
    			leftIndex++;
    		}
    		
    		else {
    			data[ leftIndex + rightIndex ] = right[ rightIndex ];
    			rightIndex++;
    		}
    	}
    }
}