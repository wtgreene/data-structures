package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

public class ShortestPathUtilTest {
		
    private Graph<String, Highway> undirectedGraph;
//    private Graph<String, Integer> directedGraph;
	
	@Before
	public void setUp() {
        undirectedGraph = new AdjacencyListGraph<String, Highway>();
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
    public void testDijkstra() {
    	
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        
        undirectedGraph.insertEdge(v1, v2, new Highway("a",  5) );
        undirectedGraph.insertEdge(v1, v3, new Highway("b", 10) );
        undirectedGraph.insertEdge(v1, v4, new Highway("c", 15) );
        undirectedGraph.insertEdge(v1, v5, new Highway("d", 20) );
        undirectedGraph.insertEdge(v2, v3, new Highway("e", 25) );
        undirectedGraph.insertEdge(v2, v4, new Highway("f", 30) );
        undirectedGraph.insertEdge(v2, v5, new Highway("g", 35) );
        undirectedGraph.insertEdge(v3, v4, new Highway("h", 40) );
        undirectedGraph.insertEdge(v3, v5, new Highway("i", 45) );
        undirectedGraph.insertEdge(v4, v5, new Highway("j", 50) );
        
        Map<Vertex<String>, Integer> map = ShortestPathUtil.dijkstra(undirectedGraph, v1);
    	    	
        assertEquals(  5, map.size() );
    	assertEquals(  0, (int)map.get(v1) );
    	assertEquals(  5, (int)map.get(v2) );
    	assertEquals( 10, (int)map.get(v3) );
    	assertEquals( 15, (int)map.get(v4) );
    	assertEquals( 20, (int)map.get(v5) );
    }
    
    @Test
    public void testShortestPathTree() {
    	
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        
        undirectedGraph.insertEdge(v1, v2, new Highway("a",  5) );
        undirectedGraph.insertEdge(v1, v3, new Highway("b", 10) );
        undirectedGraph.insertEdge(v1, v4, new Highway("c", 15) );
        undirectedGraph.insertEdge(v1, v5, new Highway("d", 20) );
        undirectedGraph.insertEdge(v2, v3, new Highway("e", 25) );
        undirectedGraph.insertEdge(v2, v4, new Highway("f", 30) );
        undirectedGraph.insertEdge(v2, v5, new Highway("g", 35) );
        undirectedGraph.insertEdge(v3, v4, new Highway("h", 40) );
        undirectedGraph.insertEdge(v3, v5, new Highway("i", 45) );
        undirectedGraph.insertEdge(v4, v5, new Highway("j", 50) );
        
        Map<Vertex<String>, Integer> dij = ShortestPathUtil.dijkstra(undirectedGraph, v1);
        Map<Vertex<String>, Edge<Highway>> map = ShortestPathUtil.shortestPathTree(undirectedGraph, v1, dij);
    	    	
        assertEquals(  4, map.size() );
    	assertEquals(  5, map.get(v2).getElement().getWeight() );
    	assertEquals( 10, map.get(v3).getElement().getWeight() );
    	assertEquals( 15, map.get(v4).getElement().getWeight() );
    	assertEquals( 20, map.get(v5).getElement().getWeight() );
    }
    
    public class Highway implements Weighted {
//        private String name;
        private int length;
        
        public Highway(String n, int l) {
//            setName(n);
            setLength(l);
        }

//        public void setName(String name) {
//            this.name = name;
//        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public int getWeight() {
            return getLength();
        }
    }
}
