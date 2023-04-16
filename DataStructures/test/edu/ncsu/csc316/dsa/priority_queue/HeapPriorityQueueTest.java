package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
//import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;

/**
 * Test class for HeapPriorityQueue
 * Checks the expected outputs of the Priorty Queue abstract data type behaviors when using
 * a min-heap data structure 
 *
 * @author Dr. King
 *
 */
public class HeapPriorityQueueTest {

    private PriorityQueue<Integer, String> heap;
    
    /**
     * Create a new instance of a heap before each test case executes
     */     
    @Before
    public void setUp() {
        heap = new HeapPriorityQueue<Integer, String>();
    }
    
    /**
     * Test the output of the insert(k,v) behavior
     */     
    @Test
    public void testInsert() {
        assertTrue(heap.isEmpty());
        assertTrue(heap.size() == 0);
        
        heap.insert(8, "eight");
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(8, (int)heap.min().getKey());
    }
    
    /**
     * Test the output of the min behavior
     */ 
    @Test
    public void testMin() {
        assertTrue(heap.isEmpty());
        assertTrue(heap.size() == 0);
        
        assertNull(heap.min());
        
        heap.insert(8, "eight");
        assertTrue( heap.min().getKey() == 8 );
        
        heap.insert(9, "nine");
        assertTrue( heap.min().getKey() == 8 );
        
        heap.insert(7, "seven");
        assertTrue( heap.min().getKey() == 7 );
    }
    
    /**
     * Test the output of the deleteMin behavior
     */     
    @Test 
    public void deleteMin() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        assertNull(heap.deleteMin());
        
        heap.insert(8, "eight");
        heap.deleteMin();
        assertTrue( heap.isEmpty() );
        
        heap.insert(8, "eight");
        heap.insert(9, "nine");
        heap.deleteMin();
        assertTrue( heap.min().getKey() == 9 );
        
        heap.deleteMin();
        assertTrue( heap.isEmpty() );
        
        heap.insert(2, "two");
        heap.insert(6, "six");
        heap.insert(4, "four");
        heap.insert(8, "eight");
        heap.insert(10, "ten");
        heap.insert(12, "twelve");
        heap.insert(14, "fourteen");
        heap.insert(16, "sixteen");
        heap.insert(18, "eighteen");
        
        heap.insert(3, "three");
        heap.deleteMin();
        assertTrue( heap.min().getKey() == 3 );
        
        heap.deleteMin();
        assertTrue( heap.min().getKey() == 4 );
        
//        heap.deleteMin();
//        heap.deleteMin();
//        heap.deleteMin();
//        heap.deleteMin();
//        heap.deleteMin();
    }
    
    /**
     * Test the output of the heap behavior when using arbitrary key objects to
     * represent priorities
     */ 
    @Test
    public void testStudentHeap() {
        PriorityQueue<Student, String> sHeap = new HeapPriorityQueue<Student, String>(new StudentIDComparator());
        Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
        Student s2 = new Student("J", "S", 2, 1, 2, "js2");
//        Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
//        Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
//        Student s5 = new Student("L", "B", 5, 1, 5, "lb5");
        
        assertTrue(sHeap.isEmpty());
        assertEquals(0, sHeap.size());
                
        sHeap.insert(s1, "s1");
        assertTrue( sHeap.size() == 1 );
        assertEquals( s1, sHeap.min().getKey() );
        
        sHeap.deleteMin();
        assertTrue( sHeap.isEmpty() );
        
        sHeap.insert(s1, "s1");
        sHeap.insert(s2, "s2");
        assertEquals( s1, sHeap.min().getKey() );

        sHeap.deleteMin();
        sHeap.deleteMin();
        assertTrue( sHeap.isEmpty() );
        
        sHeap.insert(s2, "s2");
        assertEquals( s2, sHeap.min().getKey() );
        
        sHeap.insert(s1, "s1");
        assertEquals( s1, sHeap.min().getKey() );
    }
}
