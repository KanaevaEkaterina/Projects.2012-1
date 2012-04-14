package stackcalculator;

class NotDigit extends Exception {

    public NotDigit() {
    }

    public NotDigit(String str) {
        System.out.println("Not digit");
    }
}