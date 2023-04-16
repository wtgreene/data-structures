package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data. // added a period + blank line
 * 
 * @author Dr. King
 * @author Will Greene
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {
		
	/**
	 * Sorts an array of elements using radix sort.
	 * 
	 * @param data array of elements
	 */
	@Override
	public void sort( E data[] ) {
		
		int max = 0;
		
		for ( int i = 0; i < data.length; i++ ) {
			
			if ( data[ i ].getId() > max )
				max = data[ i ].getId();
		}
		
		double numDigits = Math.ceil( Math.log( max + 1 ) / Math.log( 10 ) );
		int p = 1;
		
		for ( int j = 1; j < numDigits + 1; j++ ) {
			
			int[] b = new int[ 10 ];
			
			for ( int i = 0; i < data.length; i++ )
				b[ ( data[ i ].getId() / p ) % 10 ]++;
			
			for ( int i = 1; i <= 9; i++ )
				b[ i ] += b[ i - 1 ];
			
			@SuppressWarnings( "unchecked" )
			E[] f = ( E[] ) ( new Identifiable[ data.length ] );
			
			for ( int i = data.length - 1; i >= 0; i-- ) {
				
				f[ b[ ( data[ i ].getId() / p ) % 10 ] - 1 ] = data[ i ];
				b[ ( data[ i ].getId() / p ) % 10 ]--;
			}
			
			for ( int i = 0; i < data.length; i++ )
				data[ i ] = f[ i ];
			
			p *= 10;
		}
	}
}
