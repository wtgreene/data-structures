/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * BubbleSorter uses the bubble sort algorithm to sort data.
 * 
 * @author Will Greene
 * @param <E> the generic type of data to sort
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	
	/**
	 * Constructs a BubbleSorter object - one parameter.
	 * 
	 * @param comparator optional comparator used to specifiy sorting metric
	 */
	public BubbleSorter( Comparator<E> comparator ) {
		super( comparator );
	}
	
	/**
	 * Constructs a BubbleSorter object - no parameters.
	 */
	public BubbleSorter() {
		super( null );
	}
	
	/**
	 * Sorts an array of elements using bubble sort.
	 * 
	 * @param data array of elements
	 */
	@Override
	public void sort( E[] data ) {
		
		boolean sortingInProcess = true;
		
		while ( sortingInProcess ) {
			
			sortingInProcess = false;
			
			for ( int i = 1; i < data.length; i++ ) {
				
				if ( compare( data[ i ], data[ i - 1 ] ) < 0 ) {
					
					E temp = data[ i - 1 ];
					data[ i - 1 ] = data[ i ];
					data[ i ] = temp;
					sortingInProcess = true;
				}
			}
		}
	}
}
