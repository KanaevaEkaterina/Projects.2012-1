package calculator;

public class StackArray implements VarStack{

    char[] mass = new char[0];

    public StackArray() {
    }

    public void push(char element) {
        char[] current = new char[mass.length];
        System.arraycopy(mass, 0, current, 0, mass.length);
        mass = new char[mass.length + 1];
        mass[mass.length] = element;
    }

    public boolean isEmpty() {
        return (mass.length == 0);
    }

    public char pop() {
        if (!isEmpty()) {
            char result = mass[mass.length];
            return result;
        } else {
            System.out.println("Error. Is empty");
            return '@';
        }
    }

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
