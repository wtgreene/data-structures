package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

public class GraphTraversalUtilTest {
		
    private Graph<String, Integer> undirectedGraph;
//    private Graph<String, Integer> directedGraph;
	
	@Before
	public void setUp() {
        undirectedGraph = new AdjacencyListGraph<String, Integer>();
//        directedGraph = new AdjacencyListGraph<String, Integer>(true);
	}
	
//    private void buildUndirectedSample() {
//        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
//        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
//        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
//        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
//        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
//        
//        undirectedGraph.insertEdge(v1, v2, 5);
//        undirectedGraph.insertEdge(v1, v3, 10);
//        undirectedGraph.insertEdge(v1, v4, 15);
//        undirectedGraph.insertEdge(v1, v5, 20);
//        undirectedGraph.insertEdge(v2, v3, 25);
//        undirectedGraph.insertEdge(v2, v4, 30);
//        undirectedGraph.insertEdge(v2, v5, 35);
//        undirectedGraph.insertEdge(v3, v4, 40);
//        undirectedGraph.insertEdge(v3, v5, 45);
//        undirectedGraph.insertEdge(v4, v5, 50);
//    }
//    
//    private void buildDirectedSample() {
//        Vertex<String> v1 = directedGraph.insertVertex("Raleigh");
//        Vertex<String> v2 = directedGraph.insertVertex("Asheville");
//        Vertex<String> v3 = directedGraph.insertVertex("Wilmington");
//        Vertex<String> v4 = directedGraph.insertVertex("Durham");
//        Vertex<String> v5 = directedGraph.insertVertex("Greenville");
//        Vertex<String> v6 = directedGraph.insertVertex("Boone");
//        
//        directedGraph.insertEdge(v1, v2, 5);
//        directedGraph.insertEdge(v1, v3, 10);
//        directedGraph.insertEdge(v1, v4, 15);
//        directedGraph.insertEdge(v1, v5, 20);
//        directedGraph.insertEdge(v2, v3, 25);
//        directedGraph.insertEdge(v2, v4, 30);
//        directedGraph.insertEdge(v2, v5, 35);
//        directedGraph.insertEdge(v3, v4, 40);
//        directedGraph.insertEdge(v3, v5, 45);
//        directedGraph.insertEdge(v4, v5, 50);
//        directedGraph.insertEdge(v5, v6, 55);
//    }
    
    @Test
    public void testDFS() {
    	
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        undirectedGraph.insertEdge(v2, v5, 35);
        undirectedGraph.insertEdge(v3, v4, 40);
        undirectedGraph.insertEdge(v3, v5, 45);
        undirectedGraph.insertEdge(v4, v5, 50);
        
        Map<Vertex<String>, Edge<Integer>> map = GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1);
    	    	
        assertEquals(  4, map.size() );
    	assertEquals(  5, (int)map.get(v2).getElement() );
    	assertEquals( 25, (int)map.get(v3).getElement() );
    	assertEquals( 40, (int)map.get(v4).getElement() );
    	assertEquals( 50, (int)map.get(v5).getElement() );
    }
    
    @Test
    public void testBFS() {
    	
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        undirectedGraph.insertEdge(v2, v5, 35);
        undirectedGraph.insertEdge(v3, v4, 40);
        undirectedGraph.insertEdge(v3, v5, 45);
        undirectedGraph.insertEdge(v4, v5, 50);
        
        Map<Vertex<String>, Edge<Integer>> map = GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1);
    	    	
        assertEquals(  4, map.size() );
    	assertEquals(  5, (int)map.get(v2).getElement() );
    	assertEquals( 10, (int)map.get(v3).getElement() );
    	assertEquals( 15, (int)map.get(v4).getElement() );
    	assertEquals( 20, (int)map.get(v5).getElement() );
    }
}
