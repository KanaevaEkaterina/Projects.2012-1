package stackcalculator;

import org.junit.*;
import static org.junit.Assert.*;

public class StackCalculatorTest {

    public StackCalculatorTest() {
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
    public void testAdd() throws EmptyStack {
        VarStack st = new Stack();
        StackCalculator calculator = new StackCalculator(st);
        char ch = ' ';
        calculator.add(ch);
        assertEquals(ch, calculator.get(), 0.0);
    }

    @Test
    public void testCalc() throws DivisionByZero, EmptyStack, NotDigit {
        VarStack st = new Stack();
        StackCalculator calculator = new StackCalculator(st);
        calculator.add('5');
        calculator.add('/');
        calculator.add('2');
        assertEquals(2.5, calculator.calc(), 0.0);
    }

    @Test(expected = DivisionByZero.class)
    public void testDivisionByZero() throws DivisionByZero, EmptyStack, NotDigit {
        VarStack st = new Stack();
        StackCalculator calculator = new StackCalculator(st);
        calculator.add('5');
        calculator.add('/');
        calculator.add('0');
        calculator.calc();
    }

    public void testDivisionByZeroResult() throws DivisionByZero, EmptyStack, NotDigit {
        VarStack st = new Stack();
        StackCalculator calculator = new StackCalculator(st);
        calculator.add('5');
        calculator.add('/');
        calculator.add('0');
        calculator.result();
    }

    @Test(expected = NotDigit.class)
    public void testNotDigit() throws DivisionByZero, EmptyStack, NotDigit {
        VarStack st = new Stack();
        StackCalculator calculator = new StackCalculator(st);
        calculator.add('5');
        calculator.add('7');
        calculator.add('0');
        calculator.calc();
    }
    
    public void testNotDigitResult() throws DivisionByZero, EmptyStack, NotDigit {
        VarStack st = new Stack();
        StackCalculator calculator = new StackCalculator(st);
        calculator.add('5');
        calculator.add('7');
        calculator.add('0');
        calculator.result();
    }
    

    @Test
    public void testResult() throws DivisionByZero, EmptyStack, NotDigit {
        VarStack st = new Stack();
        StackCalculator calculator = new StackCalculator(st);
        calculator.add('1');
        calculator.add('+');
        calculator.add('2');
        assertEquals(3.0, calculator.result(), 0.0);
    }
}
