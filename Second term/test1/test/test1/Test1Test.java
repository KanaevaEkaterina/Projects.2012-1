/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import org.junit.*;
import static org.junit.Assert.*;
import test1.Test1.T;

/**
 *
 * @author Master
 */
public class Test1Test {
    
    public Test1Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        intList = new List<>();
        strList = new List<>();
        test = new Test1();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of bubbleSort method, of class Test1.
     */
    @Test
    public void testBubbleSort() {
        intList.addToBegin(3);
        intList.addToBegin(6);
        intList.addToBegin(1);
        intList.addToBegin(4);
        test.bubbleSort(intList);
        
        
    }

    List<Integer> intList;
    List<String> strList;
    Test1 test;
}
