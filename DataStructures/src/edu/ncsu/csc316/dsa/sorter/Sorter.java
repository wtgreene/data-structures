package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior. // added a period + blank line
 * 
 * @author Dr. King
 * @author Will Greene
 * @param <E> the generic type of data to sort
 */
public interface Sorter<E> {
	
	/**
	 * Sorts an array of elements.
	 * 
	 * @param data array of elements
	 */
	public void sort( E[] data );
}
