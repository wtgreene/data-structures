package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * An unordered link-based map is an unordered (meaning keys are not used to
 * order entries) linked-memory representation of the Map abstract data type.
 * This link-based map delegates to an existing doubly-linked positional list.
 * To help self-organizing entries to improve efficiency of lookUps, the
 * unordered link-based map implements the move-to-front heuristic: each time an
 * entry is accessed, it is shifted to the front of the internal list.
 * 
 * @author Dr. King
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

	/** positional list */
    private PositionalList<Entry<K, V>> list;
    
    /**
     * Constructs an UnorderedLinkedMap object.
     */
    public UnorderedLinkedMap() {
        this.list = new PositionalLinkedList<Entry<K, V>>();
    }
    
    /**
     * Returns a specified list position.
     * 
     * @param key key to look up
     * @return a specified list position
     */
    private Position<Entry<K, V>> lookUp(K key)
    {
    	Position<Entry<K, V>> temp = list.first();
    	
    	for ( int i = 0; i < size(); i++ ) {
    		
    		if ( temp.getElement().getKey().equals( key ) )
    			return temp;
    		
    		temp = list.after( temp );
    	}
    	
    	return null;
    }

    /**
     * Returns a specified list position value.
     * 
     * @param key key to look up
     * @return a specified list position value
     */
    @Override
    public V get(K key) {
    	
        Position<Entry<K, V>> p = lookUp(key);
        
        if ( p == null )
        	return null;
        
        moveToFront( p );
        return p.getElement().getValue();
    }
    
    /**
     * Moves a position to the front of the list.
     * 
     * @param position to move
     */
    private void moveToFront(Position<Entry<K, V>> position) {    	
    	list.addFirst( list.remove( position ) );
    }

    /**
     * Inserts a position in the list.
     * 
     * @param key position key
     * @param value position value
     */
    @Override
    public V put(K key, V value) {
    	
        Position<Entry<K, V>> p = lookUp(key);
        
        if ( p == null ) {
        	
        	Entry<K, V> newEntry = new MapEntry<K, V>( key, value );
        	list.addFirst( newEntry );
        	return null;
        }
        
        moveToFront( p );
        return p.getElement().getValue();
    }
    
    /**
     * Removes a position from the list.
     * 
     * @param key key to look up
     * @return the value of the removed position
     */
    @Override
    public V remove(K key) {
    	
    	Position<Entry<K, V>> p = lookUp(key);
    	
    	if ( p == null )
    		return null;
    	
    	return list.remove( p ).getValue();
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
     * Returns an Iterable EntryCollection.
     * @return an Iterable EntryCollection
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        EntryCollection collection = new EntryCollection();
        for(Entry<K, V> entry : list) {
            collection.add(entry);
        }
        return collection;
    }
    
    /**
     * Returns a string representation of the list.
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UnorderedLinkedMap[");
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
