
package stackcalculator;

public class ArrayStack implements VarStack {

    char[] mass = new char[0];

    public ArrayStack() {
    }

    @Override
    public void push(char element) {
        char [] mass1 = new char[mass.length + 1];
        System.arraycopy(mass, 0, mass1, 0, mass.length);
        mass1[mass1.length - 1] = element;
        mass = new char[mass1.length];
        System.arraycopy(mass1, 0, mass, 0, mass1.length);
    }

    @Override
    public boolean isEmpty() {
        return (mass.length == 0);
    }

    @Override
    public char pop() throws EmptyStack {
        if (!isEmpty()) {
            char result = mass[mass.length - 1];
            char [] mass1 = new char [mass.length - 1];
            System.arraycopy(mass, 0, mass1, 0, mass1.length);
            mass = new char[mass1.length];
            System.arraycopy(mass1, 0, mass, 0, mass.length);
            return result;
        } else {
           throw new EmptyStack();
        }
    }

    @Override
    public char top() throws EmptyStack {
        if (!isEmpty()) {
            char result = mass[mass.length - 1];
            return result;
        } else {
            throw new EmptyStack();
        }
    }

    @Override
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Is empty");
        } else {
            for (int i = 0; i < mass.length; i++) {
                System.out.print(mass[i] + " ");
            }
            System.out.println(" ");
        }
    }
}

