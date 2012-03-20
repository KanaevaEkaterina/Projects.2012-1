/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class StackTest {
    
    public StackTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        char j = ' ';
        Stack instance = new Stack();
        instance.push(j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Stack instance = new Stack();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack instance = new Stack();
        char expResult = ' ';
        char result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printStack method, of class Stack.
     */
    @Test
    public void testPrintStack() {
        System.out.println("printStack");
        Stack instance = new Stack();
        instance.printStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
