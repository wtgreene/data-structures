package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * 
 * @author Dr. King
 * @author Will Greene
 * @param <E> the generic type of data to sort
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
		
	/**
	 * Constructs an InsertionSorter object - one parameter.
	 * 
	 * @param comparator optional comparator used to specify sorting metric
	 */
	public InsertionSorter( Comparator<E> comparator ) {
		super( comparator );
	}
	
	/**
	 * Constructs an InsertionSorter object - no parameters.
	 */
	public InsertionSorter() {
		super( null );
	}
	
	/**
	 * Sorts an array of elements using insertion sort.
	 * 
	 * @param a array of elements
	 */
	@Override
	public void sort( E[] a ) {
		
		E x;
		int j = 0;
		
		for ( int i = 1; i < a.length; i++ ) {
			
			x = a[ i ];
			j = i - 1;
						
			while ( j >= 0 && compare( a[ j ], x ) > 0 ) {
				
				a[ j + 1 ] = a[ j ];
				j = j - 1;
			}
			
			a[ j + 1 ] = x;
		}
	}
}
