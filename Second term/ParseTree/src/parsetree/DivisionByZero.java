package parsetree;

class DivisionByZero extends Exception {

    public DivisionByZero() {
    }

    public DivisionByZero(String str) {
        System.out.println("division by zero");
    }
}
