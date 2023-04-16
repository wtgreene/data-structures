package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;
import java.util.Iterator;
import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * A Search Table map is an ordered (meaning entries are stored in a sorted
 * order based on the keys of the entries) contiguous-memory representation of
 * the Map abstract data type. This array-based map delegates to an existing
 * array-based list. To improve efficiency of lookUps, the search table map
 * implements binary search to locate entries in O(logn) worst-case runtime.
 * Insertions and deletions have O(n) worst-case runtime.
 * 
 * @author Dr. King
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class SearchTableMap<K extends Comparable<K>, V> extends AbstractOrderedMap<K, V> {

    private ArrayBasedList<Entry<K, V>> list;

    /**
     * Constructs a new SearchTableMap where keys of entries are compared based on
     * their natural ordering based on {@link Comparable#compareTo}
     */
    public SearchTableMap() {
        this(null);
    }
    
    /**
     * Constructs a new SearchTableMap where keys of entries are compared based on a
     * provided {@link Comparator}
     * 
     * @param compare a Comparator that defines comparisons rules for keys in the
     *                map
     */ 
    public SearchTableMap(Comparator<K> compare) {
        super(compare);
        list = new ArrayBasedList<Entry<K, V>>();
    }

    /**
     * Starts binarySearchHelper() by giving the parameters 0 and size() - 1.
     * 
     * @param key key to look up
     * @return index of insertion
     */
    private int lookUp(K key) {
    	return binarySearchHelper( 0, size() - 1, key );
    }

    /**
     * Uses binary search to look up a key.
     * 
     * @param min min index
     * @param max max index
     * @param key key to look up
     * @return index of insertion
     */
    private int binarySearchHelper(int min, int max, K key) {
        
    	if ( min > max )
    		return -1 * ( min + 1 );
    	
    	int mid = ( max + min ) / 2;
    	
    	if ( compare( list.get( mid ).getKey(), key ) == 0 )
    		return mid;
    	
    	else if ( compare( list.get( mid ).getKey(), key ) > 0 )
    		return binarySearchHelper( min, mid - 1, key );
    	
    	else
    		return binarySearchHelper( mid + 1, max, key );
    }

    /**
     * Returns list size.
     * @return list size
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns the value of a key.
     * 
     * @param key key to look up
     * @return the value of a key
     */
    @Override
    public V get(K key) {
    	
        int index = lookUp(key);
        
        if ( index < 0 )
        	return null;
        
        return list.get( index ).getValue();
    }

    /**
     * Returns an Iterable EntryCollection.
     * @return an Iterable EntryCollection
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        EntryCollection set = new EntryCollection();
        for (Entry<K, V> entry : list) {
            set.add(entry);
        }
        return set;
    }

    /**
     * Inserts a key:value pair in the list.
     * 
     * @param key key
     * @param value value
     * @return the value replaced (if the key already exists), null if not
     */
    @Override
    public V put(K key, V value) {
    	
        int index = lookUp(key);
        MapEntry<K, V> entry = new MapEntry<K, V>( key, value );
        
        if ( index < 0 ) {
        	list.add( -1 * ( index + 1 ), entry);
        	return null;
        }
        
        V originalValue = list.remove( index ).getValue();
        list.add( index, entry );
        
        return originalValue;
    }

    /**
     * Removes a key:value pair in the list.
     * 
     * @return the value of the removed pair
     */
    @Override
    public V remove(K key) {
    	
        int index = lookUp(key);
        
        if ( index < 0 )
        	return null;
        
        return list.remove( index ).getValue();
    }
    
    /**
     * Returns a string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SearchTableMap[");
        Iterator<Entry<K, V>> it = list.iterator();
        while(it.hasNext()) {
            sb.append(it.next().getKey());
            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
