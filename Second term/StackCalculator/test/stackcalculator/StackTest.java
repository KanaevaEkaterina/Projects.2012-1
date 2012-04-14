package stackcalculator;

import org.junit.*;
import static org.junit.Assert.*;

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

    @Test
    public void testPush() throws EmptyStack {
        Stack instance = new Stack();
        instance.push('3');
        instance.push('2');
        assertEquals('2', instance.top());
    }

    @Test
    public void testIsEmpty() {
        Stack instance = new Stack();
        assertEquals(true, instance.isEmpty());
    }

    @Test
    public void testPop() throws EmptyStack {
        Stack instance = new Stack();
        instance.push('3');
        instance.push('2');
        assertEquals('2', instance.pop());
        assertEquals('3', instance.top());
    }

    @Test(expected = EmptyStack.class)
    public void testEmptyStackPop() throws EmptyStack {
        Stack instance = new Stack();
        instance.pop();
    }

    @Test
    public void testTop() throws EmptyStack {
        Stack instance = new Stack();
        instance.push('3');
        instance.push('2');
        assertEquals('2', instance.top());
        assertEquals('2', instance.top());
    }

    @Test(expected = EmptyStack.class)
    public void testEmptyStackTop() throws EmptyStack {
        Stack instance = new Stack();
        instance.top();
    }
}
