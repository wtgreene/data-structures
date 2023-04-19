package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.priority_queue.AdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.HeapAdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * ShortestPathUtil provides a collection of behaviors for computing shortest
 * path spanning trees for a given graph.
 * 
 * The ShortestPathUtil class is based on the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 *
 */
public class ShortestPathUtil {
    
    /**
     * For a connected graph, returns a map that represents shortest path costs to
     * all vertices computed using Dijkstra's single-source shortest path algorithm.
     * 
     * @param <V>   the type of data in the graph vertices
     * @param <E>   the type of data in the graph edges
     * @param graph the graph for which to compute the shortest path spanning tree
     * @param start the vertex at which to start computing the shorest path spanning
     *              tree
     * @return a map that represents the shortest path costs to all vertices in the
     *         graph
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Integer> dijkstra(Graph<V, E> graph, Vertex<V> start) {
        //TODO: complete this method
        //NOTE: since Dijkstra's algorithm is very similar to Prim-Jarnik's algorithm,
        //     you should review the provided Prim-Jarnik implementation in the next
        //     section of the lab on Minimum Spanning Trees
    	
    	AdaptablePriorityQueue<Integer, Vertex<V>> apq = new HeapAdaptablePriorityQueue<Integer, Vertex<V>>();
    	Map<Vertex<V>, Integer> cMap = new LinearProbingHashMap<Vertex<V>, Integer>();
    	Set<Vertex<V>> set = new HashSet<Vertex<V>>();
    	Map<Vertex<V>, Entry<Integer, Vertex<V>>> eMap = new LinearProbingHashMap<Vertex<V>, Entry<Integer, Vertex<V>>>();
    	
    	for ( Vertex<V> v : graph.vertices() ) {
    		
    		if ( v.equals(start) )
    			cMap.put(v, 0);
    		
    		else
    			cMap.put(v, null);
    		
    		int currentCost = cMap.get(v);
    		Entry<Integer, Vertex<V>> apqEntry = apq.insert(currentCost, v);
    		eMap.put(v, apqEntry);
    	}
    	
    	while ( !apq.isEmpty() ) {
    		
    		Entry<Integer, Vertex<V>> entry = apq.deleteMin();
    		Vertex<V> u = entry.getValue();
    		set.add(u);
    		
    		for ( Edge<E> e : graph.outgoingEdges(u) ) {
    			
    			Vertex<V> z = graph.opposite(u, e);
    			
    			if ( !set.contains(z) ) {
    				
    				int r = e.getElement().getWeight() + cMap.get(u);
    				
    				if ( r < cMap.get(z) ) {
    					cMap.put(z, r);
    					apq.replaceKey( eMap.get(z) , r);
    				}
    			}
    		}
    	}
    	
    	return cMap;
    }
    
    /**
     * For a connected graph, returns a map that represents shortest path spanning
     * tree edges computed using Dijkstra's single-source shortest path algorithm.
     * 
     * @param <V>       the type of data in the graph vertices
     * @param <E>       the type of data in the graph edges
     * @param graph         the graph for which to compute the shortest path spanning
     *                  tree
     * @param start         the vertex at which to start computing the shortest path
     *                  spanning tree
     * @param costs the map of shortest path costs to reach each vertex in the
     *                  graph
     * @return a map that represents the shortest path spanning tree edges
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Edge<E>> shortestPathTree(Graph<V, E> graph, Vertex<V> start, Map<Vertex<V>, Integer> costs) {
    	
    	Map<Vertex<V>, Edge<E>> map = new LinearProbingHashMap<Vertex<V>, Edge<E>>();
    	
    	for ( Vertex<V> v : costs ) {
    		
    		if ( !v.equals(start) ) {
    			
    			for ( Edge<E> e : graph.incomingEdges(v) ) {
    				
    				Vertex<V> u = graph.opposite(v, e);
    				
    				if ( costs.get(v).equals(costs.get(u) + e.getElement().getWeight()) )
    					map.put(v, e);
    			}
    		}
    	}
    	
    	return map;
    }
}
