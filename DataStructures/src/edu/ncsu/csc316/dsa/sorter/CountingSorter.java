package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data. // added a period + blank line
 * 
 * @author Dr. King
 * @author Will Greene
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {
	
	/**
	 * Sorts an array of elements using counting sort.
	 * 
	 * @param data array of elements
	 */
	@Override
	public void sort( E[] data ) {
		
		int min = data[ 0 ].getId();
		int max = data[ 0 ].getId();
		
		for ( int i = 1; i < data.length; i++ ) {
			
			if ( data[ i ].getId() < min )
				min = data[ i ].getId();
			
			if ( data[ i ].getId() > max )
				max = data[ i ].getId();
		}
		
		int range = max - min + 1;
		int[] b = new int[ range ];
		
		// Record Frequency
		for ( int i = 0; i < data.length; i++ )			
			b[ data[ i ].getId() - min ]++;
		
		// Accumulate Frequency
		for ( int i = 1; i < range; i++ )		
			b[ i ] += b[ i - 1 ];
		
		@SuppressWarnings("unchecked")
		E[] f = ( E[] ) ( new Identifiable[ data.length ] );
		
		for ( int i = data.length - 1; i >= 0; i-- ) {
			
			f[ b[ data[ i ].getId() - min ] - 1 ] = data[ i ];
			b[ data[ i ].getId() - min ]--;
		}
		
		// a = f
		for ( int i = 0; i < data.length; i++ )
			data[ i ] = f[ i ];
	}
}
