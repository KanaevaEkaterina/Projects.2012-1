/*
 * Tests for methods of class Stack
 */
package genericstack;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class StackTest {
    
    public StackTest() {
    }

    @Before
    public void setUp() {
        intStack = new Stack<>();
    }
    
    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() throws EmptyStack {
        intStack.push(3);
        intStack.push(4);
        assertEquals(4, intStack.top(), 0.0);
        intStack.push(5);
        assertEquals(5, intStack.top(), 0.0);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() throws EmptyStack {
        assertTrue(intStack.isEmpty());
        intStack.push(4);
        assertFalse(intStack.isEmpty());
        intStack.pop();
        assertTrue(intStack.isEmpty());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() throws EmptyStack {
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        assertEquals(4, intStack.pop(), 0.0);
        assertEquals(3, intStack.top(), 0.0);
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() throws EmptyStack {
        intStack.push(2);
        assertEquals(2, intStack.top(), 0.0);
        intStack.push(3);
        assertEquals(3, intStack.top(), 0.0);
        assertEquals(3, intStack.top(), 0.0);
        intStack.pop();
        assertEquals(2, intStack.top(), 0.0);
    }
    
    @Test(expected = EmptyStack.class)
    /**
     * Test of top method, of class Stack, in case, when stack is empty.
     */
    public void testTopOfEmptyStack() throws EmptyStack {    
        intStack.top();
    }   
   
    /**
     * Test of pop method, of class Stack, in case, when stack is empty.
     */
    public void testPopFromEmptyStack() throws EmptyStack {    
        intStack.pop();
    }   
    
    Stack<Integer> intStack;
}
