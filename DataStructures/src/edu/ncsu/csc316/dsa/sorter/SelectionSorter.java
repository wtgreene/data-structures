package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data. // added a period + blank line
 * 
 * @author Dr. King
 * @author Will Greene
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	    
    /**
     * Constructs a SelectionSorter object - one parameter.
     * 
     * @param comparator optional comparator used to specify sorting metric
     */
    public SelectionSorter(Comparator<E> comparator) {
        super(comparator);
    }
    
    /**
     * Constructs a SelectionSorter object - no parameters.
     */
    public SelectionSorter() {
    	super( null );
    }

    /**
     * Sorts an array of elements using selection sort.
     * 
     * @param data array of elements
     */
    @Override
    public void sort( E[] data ) {
    	
    	for ( int i = 0; i < data.length; i++ ) {
    		
    		int min = i;
    		
    		for ( int j = i + 1; j < data.length; j++ ) {
    			
    			if ( compare( data[ j ], data[ min ] ) < 0 )
    				min = j;
    		}
    				
    		if ( i != min ) {
    			
    			E x = data[ i ];
    			data[ i ] = data[ min ];
    			data[ min ] = x;
    		}
    	}
    }
}
