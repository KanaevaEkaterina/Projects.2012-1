/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class VarStackTest {
    
    public VarStackTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class VarStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        char element = ' ';
        VarStack instance = new VarStackImpl();
        instance.push(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class VarStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        VarStack instance = new VarStackImpl();
        char expResult = ' ';
        char result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class VarStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        VarStack instance = new VarStackImpl();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printStack method, of class VarStack.
     */
    @Test
    public void testPrintStack() {
        System.out.println("printStack");
        VarStack instance = new VarStackImpl();
        instance.printStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class VarStackImpl implements VarStack {

        public void push(char element) {
        }

        public char pop() {
            return ' ';
        }

        public boolean isEmpty() {
            return false;
        }

        public void printStack() {
        }
    }
}
