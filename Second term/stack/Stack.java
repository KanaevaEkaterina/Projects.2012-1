
package stack;

public class Stack {

    private Element first;

    public Stack() {
        first = null;
    }

    public void push(int j) {
        Element newEl = new Element(j);
        newEl.next = first;
        first = newEl;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public int pop() {
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

        private int value;
        private Element next;

        public Element(int n) {
            value = n;
        }

        public void printElement() {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Empty? - " + stack.isEmpty());
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.printStack();
        stack.pop();
        System.out.println("Empty? - " + stack.isEmpty());
        stack.printStack();
    }
}
