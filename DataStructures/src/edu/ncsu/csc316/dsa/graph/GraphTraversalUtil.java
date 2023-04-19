package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;
import edu.ncsu.csc316.dsa.queue.Queue;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * GraphTraversalUtil provides a collection of behaviors for traversing graphs,
 * including depth-first search and breadth-first search.
 * 
 * The GraphTraversalUtil class is based on the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 *
 */
public class GraphTraversalUtil {
    
    /**
     * Returns a map of discovery edges that represent a depth-first search
     * traversal of the given graph from a given starting vertex.
     * 
     * @param <V>   the type of data in the graph vertices
     * @param <E>   the type of data in the graph edges
     * @param graph a graph to traverse
     * @param start the vertex at which to start the depth-first search traversal
     * @return a map of discovery edges that were used to discover vertices in the
     *         graph
     */
    public static <V, E> Map<Vertex<V>, Edge<E>> depthFirstSearch(Graph<V, E> graph, Vertex<V> start) {
    	
    	Set<Vertex<V>> set = new HashSet<Vertex<V>>();
    	Map<Vertex<V>, Edge<E>> map = new LinearProbingHashMap<Vertex<V>, Edge<E>>();
    	
    	dfsHelper( graph, start, set, map );
    	
    	return map;
    }
    
    private static <V, E> void dfsHelper(Graph<V, E> graph, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
    	
    	known.add(u);
    	
    	for ( Edge<E> e : graph.outgoingEdges(u) ) {
    		
    		Vertex<V> v = graph.opposite(u, e);
    		
    		if ( !known.contains(v) ) {
    			forest.put(v, e);
    			dfsHelper( graph, v, known, forest );
    		}
    	}
    }

    /**
     * Returns a map of discovery edges that represent a breadth-first search
     * traversal of the given graph from a given starting vertex.
     * 
     * @param <V>   the type of data in the graph vertices
     * @param <E>   the type of data in the graph edges
     * @param graph a graph to traverse
     * @param start the vertex at which to start the breadth-first search traversal
     * @return a map of discovery edges that were used to discover vertices in the
     *         graph
     */    
    public static <V, E> Map<Vertex<V>, Edge<E>> breadthFirstSearch(Graph<V, E> graph, Vertex<V> start) {
    	
    	Set<Vertex<V>> set = new HashSet<Vertex<V>>();
    	Map<Vertex<V>, Edge<E>> map = new LinearProbingHashMap<Vertex<V>, Edge<E>>();
    	Queue<Vertex<V>> queue = new ArrayBasedQueue<Vertex<V>>();
    	
    	set.add(start);
    	queue.enqueue(start);
    	
    	while ( !queue.isEmpty() ) {
    		
    		Vertex<V> u = queue.dequeue();
    		
    		for ( Edge<E> e : graph.outgoingEdges(u) ) {
    			
    			Vertex<V> w = graph.opposite(u, e);
    			
    			if ( !set.contains(w) ) {
    				set.add(w);
    				map.put(w, e);
    				queue.enqueue(w);
    			}
    		}
    	}
    	
    	return map;
    }
}
