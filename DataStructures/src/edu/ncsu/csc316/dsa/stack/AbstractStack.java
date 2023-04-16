package edu.ncsu.csc316.dsa.stack;

/**
 * A skeletal implementation of the Stack abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the stack abstract data type.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the stack
 */
public abstract class AbstractStack<E> implements Stack<E> {

    /**
     * Returns true if the stack contains no elements, otherwise returns false
     * 
     * @return true if the stack contains no elements, otherwise returns false
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}