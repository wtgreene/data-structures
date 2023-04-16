package edu.ncsu.csc316.dsa.set;

/**
 * A skeletal implementation of the Set abstract data type. This class provides
 * implementation for common methods that can be implemented the same no matter
 * what specific type of concrete data structure is used to implement the set
 * abstract data type.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the set
 */
public abstract class AbstractSet<E> implements Set<E> {

    /**
     * Adds all elements from the provided set into the current set. Mathematically,
     * "union".
     * 
     * @param other the reference set from which to add all elements into the
     *              current set
     */
    @Override
    public void addAll(Set<E> other) {
        for(E element : other) {
            add(element);
        }
    }

    /**
     * Removes all entries from the current set that are not also contained in the
     * provided set. Mathematically, "intersection".
     * 
     * @param other the reference set from which to remove all entries from the
     *              current set that are not also contained in reference set
     */
    @Override
    public void retainAll(Set<E> other) {
        for(E element : this) {
            if(!other.contains(element)) {
                remove(element);
            }
        }
    }

    /**
     * Removes all entries from the current set that are contained in the provided
     * set. Mathematically, "substraction".
     * 
     * @param other the reference set from which to remove all entries from the
     *              current set that are also contained in the reference set
     */
    @Override
    public void removeAll(Set<E> other) {
        for(E element : other) {
            remove(element);
        }
    }
    
    /**
     * Returns true to indicate the set contains no elements, or false to indicate
     * the set contains at least 1 element.
     * 
     * @return true if the set contains no elements; otherwise, return false
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
