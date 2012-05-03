/*
 * Tests for methods of class PriorityQueue
 */
package priorityqueue;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class PriorityQueueTest {
    
    public PriorityQueueTest() {
    }
    
    @Before
    public void setUp() {
        instance = new PriorityQueue<Integer>();
    }

    /**
     * Test of enqueue method, of class PriorityQueue.
     */
    @Test
    public void testEnqueue() throws EmptyQueueException {
        instance.enqueue(3, 0);
        instance.enqueue(2, 1);
        instance.enqueue(4, 0);
        assertEquals(2, instance.dequeue(), 0.0);
    }

    /**
     * Test of dequeue method, of class PriorityQueue.
     */
    @Test
    public void testDequeue() throws EmptyQueueException {
        instance.enqueue(3, 0);
        instance.enqueue(2, 1);
        instance.enqueue(4, 0);
        instance.dequeue();
        assertEquals(3, instance.dequeue(), 0.0);
        
    }
    
    /**
     * Test of dequeue method, of class PriorityQueue, in case, when queue is empty
     * 
     */
    @Test(expected = EmptyQueueException.class)
    public void testDequeueFromEmptyQueue() throws EmptyQueueException {
        instance.dequeue();
    }

    PriorityQueue<Integer> instance;
}
