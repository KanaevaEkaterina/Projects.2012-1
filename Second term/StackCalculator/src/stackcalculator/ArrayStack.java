package stackcalculator;

/**
 * create stack using array
 *
 * @author Kanaeva Ekaterina
 */
public class ArrayStack implements VarStack {

    /**
     * constructor for stack using array
     */
    public ArrayStack() {
        numberOfElements = 0;
    }

    /**
     * add element to the end of the array
     *
     * @param element element for addition
     */
    @Override
    public void push(char element) {
        if (numberOfElements < mass.length) {
            mass[numberOfElements] = element;
        } else {
            char[] mass1 = new char[mass.length + 1 + mass.length/2];
            System.arraycopy(mass, 0, mass1, 0, mass.length);
            mass1[mass.length] = element;
            mass = new char[mass1.length];
            System.arraycopy(mass1, 0, mass, 0, mass1.length);
        }
        numberOfElements++;
    }

    /**
     * shows, if the array is empty
     *
     * @return true if array is empty, false - otherwise
     */
    @Override
    public boolean isEmpty() {
        return (numberOfElements == 0);
    }

    /**
     * delete element from the end of the array
     *
     * @return element, that was deleted
     */
    @Override
    public char pop() throws EmptyStack {
        if (!isEmpty()) {
            char result = mass[numberOfElements - 1];
            numberOfElements--;
            return result;
        } else {
            throw new EmptyStack();
        }
    }

    /**
     * return element from the top(form the end of the array)
     *
     * @return element, that was deleted
     */
    @Override
    public char top() throws EmptyStack {
        if (!isEmpty()) {
            char result = mass[numberOfElements - 1];
            return result;
        } else {
            throw new EmptyStack();
        }
    }

    /**
     * print array
     */
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
    
    /**
     * number of elements in array
     */
    private int numberOfElements;
    /**
     * array for stack
     */
    private char[] mass = new char[0];
}
