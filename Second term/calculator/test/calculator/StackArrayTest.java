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
public class StackArrayTest {
    
    public StackArrayTest() {
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
     * Test of push method, of class StackArray.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        char element = ' ';
        StackArray instance = new StackArray();
        instance.push(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class StackArray.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        StackArray instance = new StackArray();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class StackArray.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        StackArray instance = new StackArray();
        char expResult = ' ';
        char result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printStack method, of class StackArray.
     */
    @Test
    public void testPrintStack() {
        System.out.println("printStack");
        StackArray instance = new StackArray();
        instance.printStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
