package stackcalculator;

/**
 * calculator, released on stack
 *
 * @author Kanaeva Ekaterina
 */
public class StackCalculator {

    /**
     * variable, that can be stack using array or list
     */
    VarStack stack;

    /**
     * constructor for calculator on stack
     *
     * @param stack variable, that can be stack using array or list
     */
    public StackCalculator(VarStack stack) {
        this.stack = stack;
    }

    /**
     * delete element from the top
     *
     * @return element from the top
     */
    public char get() throws EmptyStack {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new EmptyStack();
        }
    }

    /**
     * add element to stack
     *
     * @param ch element for addition
     */
    public void add(char ch) {
        stack.push(ch);
    }

    /**
     * calculate, using elements in stack
     *
     * @return double result of calculation
     */
    public double calc() throws DivisionByZero, EmptyStack, NotDigit {
        if (!stack.isEmpty()) {
            int a = get() - 48;
            char digit = get();
            int b = get() - 48;
            switch (digit) {
                case '+':
                    return a + b;
                case '-':
                    return b - a;
                case '*':
                    return a * b;
                case '/':
                    if (a != 0) {
                        return ((double) b) / ((double) a);
                    } else {
                        throw new DivisionByZero();

                    }
                default:
                    throw new NotDigit();

            }

        } else {
            throw new EmptyStack();
        }
    }

    /**
     * return result of calculation
     *
     * @return double result of calculation
     */
    public double result() throws DivisionByZero, EmptyStack, NotDigit {

        if (!stack.isEmpty()) {
            double res = calc();
            return res;
        } else {
            throw new EmptyStack();
        }
    }
}