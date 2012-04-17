package stackcalculator;

/**
 * interface for stacks using array and list
 *
 * @author Kanaeva Ekaterina
 */
interface VarStack {

    /**
     * add element to stack
     * 
     * @param element element for addition
     */
    public void push(char element);

    /**
     * delete element from stack
     * 
     * @return element, that was deleted
     */
    public char pop() throws EmptyStack;

     /**
     * return element from the top of stack
     * 
     * @return element, that was deleted
     */
    public char top() throws EmptyStack;

    /**
     * shows, if stack is empty
     * 
     * @return true if array is empty, false - otherwise
     */
    public boolean isEmpty();

    /**
     * print stack
     */
    public void printStack();
}

