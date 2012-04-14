package stackcalculator;

interface VarStack {

    public void push(char element);

    public char pop() throws EmptyStack;

    public char top() throws EmptyStack;

    public boolean isEmpty();

    public void printStack();
}

