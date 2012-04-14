package stackcalculator;

public class StackCalculator {

    VarStack stack;

    public StackCalculator(VarStack stack) {
        this.stack = stack;
    }

    public char get() throws EmptyStack {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new EmptyStack();
        }
    }

    public void add(char ch) {
        stack.push(ch);
    }

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

    public double result() throws DivisionByZero, EmptyStack, NotDigit {

        if (!stack.isEmpty()) {
            double res = calc();
            return res;
        } else {
            throw new EmptyStack();
        }
    }
}