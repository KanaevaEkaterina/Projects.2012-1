/*
 * creates stack, using generic-class
 */
package genericstack;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Stack<T> {

    /**
     * constructor for stack using list
     */
    public Stack() {
    }

    /**
     * add element to the begin of the list
     *
     * @param element element for addition
     */
    public void push(T j) {
        Element newEl = new Element(j);
        newEl.next = first;
        first = newEl;
    }

    /**
     * shows, if the list is empty
     *
     * @return true if array is empty, false - otherwise
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * delete element from the begin of the list
     *
     * @return element, that was deleted
     */
    public T pop() throws EmptyStack {
        if (!isEmpty()) {
            Element buf = first;
            first = first.next;
            return buf.value;
        } else {
            System.out.println("Error. Is empty");
            throw new EmptyStack();
        }
    }

    /**
     * return element from the top(form the begin of the list)
     *
     * @return element, that was deleted
     */
    public T top() throws EmptyStack {
        if (!isEmpty()) {
            Element buf = first;
            return buf.value;
        } else {
            throw new EmptyStack();
        }
    }

    /**
     * print list
     */
    public void printStack() {
        System.out.print("Stack: ");
        Element current = first;
        if (current == null) {
            System.out.println("Is empty");
        }
        while (current != null) {
            current.printElement();
            current = current.next;
        }
        System.out.println(" ");
    }

    /**
     * first element in the list
     */
    private Element first;
    
    /**
     * list's element
     */
    private class Element {

        /**
         * constructor for list's element
         *
         * @param n value, which should be in the new element
         */
        public Element(T n) {
            value = n;
        }

        /**
         * print element of the list
         */
        public void printElement() {
            System.out.print(value + " ");
        }
        
        /**
         * value of element in the list
         */
        private T value;
        /**
         * pointer to the next element in the list
         */
        private Element next;
    }
}
