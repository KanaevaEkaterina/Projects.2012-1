package calculator;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    public CalculatorTest() {
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
    public void testAdd() {
        VarStack st = new Stack();
        Calculator calculator = new Calculator(st);
        char ch = ' ';
        calculator.add(ch);
        assertEquals(ch, calculator.get(), 0.0);
    }

    @Test
    public void testCalc() throws DivisionByZero {
        VarStack st = new Stack();
        Calculator calculator = new Calculator(st);
        calculator.add('5');
        calculator.add('/');
        calculator.add('2');
        assertEquals(2.5, calculator.calc(), 0.0);
    }

    @Test(expected = DivisionByZero.class)
    public void testDivisionByZero() {
        VarStack st = new Stack();
        Calculator calculator = new Calculator(st);
        calculator.add('5');
        calculator.add('/');
        calculator.add('0');
        calculator.calc();
    }

    @Test
    public void testResult() {
        VarStack st = new Stack();
        Calculator calculator = new Calculator(st);
        assertEquals(calculator.calc(), calculator.result(), 0.0);
    }
}
