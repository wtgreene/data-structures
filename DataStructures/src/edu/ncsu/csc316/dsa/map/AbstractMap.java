package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * A skeletal implementation of the Map abstract data type. This class provides
 * implementation for common methods that can be implemented the same no matter
 * what specific type of concrete data structure is used to implement the map
 * abstract data type.
 * 
 * @author Dr. King
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    /**
     * MapEntry implements the Entry abstract data type.
     * 
     * @author Dr. King
     * @author Will Greene
     *
     * @param <K> the type of key stored in the entry
     * @param <V> the type of value stored in the entry
     */
    protected static class MapEntry<K, V> implements Entry<K, V> {

    	/** MapEntry key */
        private K key;
        /** MapEntry value */
        private V value;

        /**
         * Constructs a MapEntry with a provided key and a provided value
         * 
         * @param key   the key to store in the entry
         * @param value the value to store in the entry
         */
        public MapEntry(K key, V value) {
            setKey(key);
            setValue(value);
        }

        /**
         * Returns the key.
         * @return the key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Returns the value.
         * @return the value
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Set the key of the entry to the provided key
         * 
         * @param key the key to store in the entry
         */
        private void setKey(K key) {
            this.key = key;
        }

        /**
         * Set the value of the entry to the provided value
         * 
         * @param value the value to store in the entry
         */
        public void setValue(V value) {
            this.value = value;
        }
        
        /**
         * Compares the this key to another. Returns > 0 if this key belongs after the other,
         * 0 if this key is equal to the other and < 0 if this key belongs before the other.
         * 
         * @param o Entry to compare keys with
         * @return integer value pertaining to relative order
         */
        @SuppressWarnings("unchecked")
        @Override
        public int compareTo(Entry<K, V> o) {
            return ((Comparable<K>)this.key).compareTo(o.getKey());
        }       
    }
    
    /**
     * EntryCollection implements the {@link Iterable} interface to allow traversing
     * through the entries stored in the map. EntryCollection does not allow removal
     * operations
     * 
     * @author Dr. King
     * @author Will Greene
     *
     */
    protected class EntryCollection implements Iterable<Entry<K, V>> {

    	/** list */
        private List<Entry<K, V>> list;

        /**
         * Constructs an EntryCollection object as a SinglyLinkedList.
         */
        public EntryCollection() {
            list = new SinglyLinkedList<Entry<K, V>>();
        }

        /**
         * Adds an Entry to the end of the list.
         * 
         * @param entry Entry to add
         */
        public void add(Entry<K, V> entry) {
            list.addLast(entry);
        }

        /**
         * Returns an iterator.
         * @return an iterator
         */
        public Iterator<Entry<K, V>> iterator() {
            return new EntryCollectionIterator();
        }

        /**
         * Iterator class for an EntryCollection.
         * 
         * @author Will Greene
         *
         */
        private class EntryCollectionIterator implements Iterator<Entry<K, V>> {

        	/** iterator */
            private Iterator<Entry<K, V>> it;

            /**
             * Constructs an EntryCollectionIterator object.
             */
            public EntryCollectionIterator() {
                it = list.iterator();
            }

            /**
             * Returns whether there is an Entry next.
             * @return true if there is, false if not
             */
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            /**
             * Returns the next Entry.
             * @return the next Entry
             */
            @Override
            public Entry<K, V> next() {
                return it.next();
            }

            /**
             * Removes an Entry.
             * 
             * @throws UnsupportedOperationException if the remove operation is not supported
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException("The remove operation is not supported yet.");
            }
        }
    }     

    /**
     * KeyIterator implements the {@link Iterator} interface to allow traversing
     * through the keys stored in the map
     * 
     * @author Dr. King
     * @author Will Greene
     *
     */
    protected class KeyIterator implements Iterator<K> {

    	/** key iterator */
        private Iterator<Entry<K, V>> it;
        
        /**
         * Constructs a KeyIterator object.
         */
        public KeyIterator() {
            it = entrySet().iterator();
        }
        
        /**
         * Returns whether there is an Entry (and thus key) next.
         * @return whether there is an Entry (and thus key) next
         */
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        /**
         * Returns the next key.
         * @return the next key
         */
        @Override
        public K next() {
            return it.next().getKey();
        }
        
        /**
         * Removes an Entry / key.
         * 
         * @throws UnsupportedOperationException if the remove operation is not supported
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("The remove operation is not supported yet.");
        }
    }

    /**
     * ValueIterator implements the {@link Iterator} interface to allow traversing
     * through the values stored in the map
     * 
     * @author Dr. King
     * @author Will Greene
     *
     */
    protected class ValueIterator implements Iterator<V> {
    	
    	/** value iterator */
        private Iterator<Entry<K, V>> it;
        
        /**
         * Constructs a ValueIterator object.
         */
        public ValueIterator() {
            it = entrySet().iterator();
        }
        
        /**
         * Returns whether there is an Entry (and thus value) next.
         * @return whether there is an Entry (and thus value) next
         */
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        /**
         * Returns the next value.
         * @return the next value
         */
        @Override
        public V next() {
            return it.next().getValue();
        }
        
        /**
         * Removes an Entry / value.
         * 
         * @throws UnsupportedOperationException if the remove operation is not supported
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("The remove operation is not supported yet.");
        }
    }

    /**
     * Returns whether the list is empty.
     * @return true if empty, false if not
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns a KeyIterator.
     * @return a KeyIterator
     */
    @Override
    public Iterator<K> iterator() {
        return new KeyIterator();
    }

    /**
     * Returns a ValueIterable.
     * @return a ValueIterable
     */
    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }

    /**
     * Iterator class for ValueIterator.
     * 
     * @author Will Greene
     *
     */
    private class ValueIterable implements Iterable<V> {
    	
    	/**
    	 * Returns a ValueIterator.
    	 * @return a ValueIterator
    	 */
        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }
}
