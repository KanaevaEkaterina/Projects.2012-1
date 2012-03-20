
package calculator;

public class Stack implements VarStack{

    private Element first;

    public Stack() {
        first = null;
    }

    public void push(char j) {
        Element newEl = new Element(j);
        newEl.next = first;
        first = newEl;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public char pop() {
        if (!isEmpty()) {
            Element buf = first;
            first = first.next;
            return buf.value;
        } else {
            System.out.println("Error. Is empty");
            return 0;
        }
    }

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

    class Element {

        private char value;
        private Element next;

        public Element(char n) {
            value = n;
        }

        public void printElement() {
            System.out.print(value + " ");
        }
    }
}
