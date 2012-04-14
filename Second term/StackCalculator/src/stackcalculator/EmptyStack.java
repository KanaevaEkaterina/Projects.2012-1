package stackcalculator;

class EmptyStack extends Exception {

    public EmptyStack() {
    }

    public EmptyStack(String str) {
        System.out.println("Stack is empty");
    }
}
