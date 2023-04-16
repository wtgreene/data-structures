package edu.ncsu.csc316.dsa.queue;

/**
 * A skeletal implementation of the Queue abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the queue abstract data type.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the queue
 */
public abstract class AbstractQueue<E> implements Queue<E> {

	/**
	 * Returns true if the queue contains no elements, otherwise returns false
	 * 
	 * @return true if the queue does not contain any elements, otherwise returns
	 *         false
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}