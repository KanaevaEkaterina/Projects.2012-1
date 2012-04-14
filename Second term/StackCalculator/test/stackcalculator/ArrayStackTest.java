package stackcalculator;

import org.junit.*;
import static org.junit.Assert.*;

public class ArrayStackTest {

    public ArrayStackTest() {
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
        ArrayStack instance = new ArrayStack();
        instance.push('3');
        instance.push('2');
        assertEquals('2', instance.top());
    }

    @Test
    public void testIsEmpty() {
        ArrayStack instance = new ArrayStack();
        assertEquals(true, instance.isEmpty());
    }

    @Test
    public void testPop() throws EmptyStack {
        ArrayStack instance = new ArrayStack();
        instance.push('3');
        instance.push('2');
        assertEquals('2', instance.pop());
        assertEquals('3', instance.top());
    }

    @Test(expected = EmptyStack.class)
    public void testEmptyStackPop() throws EmptyStack {
        ArrayStack instance = new ArrayStack();
        instance.pop();
    }

    @Test
    public void testTop() throws EmptyStack {
        ArrayStack instance = new ArrayStack();
        instance.push('3');
        instance.push('2');
        assertEquals('2', instance.top());
        assertEquals('2', instance.top());
    }

    @Test(expected = EmptyStack.class)
    public void testEmptyStackTop() throws EmptyStack {
        ArrayStack instance = new ArrayStack();
        instance.top();
    }
}
