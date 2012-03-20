
package calculator;

interface VarStack {

    public void push(char element);

    public char pop();

    public boolean isEmpty();

    public void printStack();
}

class notDigit extends Exception {

    public notDigit() {
    }

    public notDigit(String str) {
        System.out.println("Not digit");
    }
}

class DivisionByZero extends Exception {

    public DivisionByZero() {
    }

    public DivisionByZero(String str) {
        System.out.println("division by zero");
    }
}

public class Calculator {

    VarStack stack;

    public Calculator(VarStack stack) {
        this.stack = stack;
    }

    public char get() {
        return stack.pop();
    }

    public void add(char ch) {
        stack.push(ch);
    }

    public double calc() throws DivisionByZero {
        char a = get();
        char digit = get();
        char b = get();
        switch (digit) {
            case '+':
                return (a - 48) + (b - 48);
            case '-':
                return b - a;
            case '*':
                return (a - 48) * (b - 48);
            case '/':
                if (a != 0) {
                    return ((double) (b - 48)) / ((double) (a - 48));
                } else {
                   throw new DivisionByZero();
                   
                }
            default:
                return '@';
            //throw new notDigit();

        }

    }

    /*
     * public double result() {
     *
     * double res = calc(); return res;
    }
     */
    public static void main(String[] args) {

        VarStack st = new Stack();
        Calculator calculator = new Calculator(st);
        try {
            calculator.calc(); 
        }
            //catch(notDigit e) {
          //  e.getMessage();
            //e.printStackTrace();
            //throw new RuntimeException(e);
        /*}*/ catch (DivisionByZero e1) {
            e1.getMessage();
            e1.printStackTrace();
            throw new RuntimeException(e1);
        }
       /* calculator.add('5');
        calculator.add('/');
        calculator.add('2');
        System.out.println(calculator.get());
        calculator.add('2');
        char a = calculator.get();
        char sign = calculator.get();
        char b = calculator.get();
        double res = ((double) (b - 48)) / ((double) (a - 48));
        System.out.println(res);
        calculator.add('5');
        calculator.add('/');
        calculator.add('2');
        System.out.println(calculator.calc());
*/
    }
}
