package stackcalculator;

/**
 * Exception for StackCalculator, is thrown, when the divider is equal to null.
 *
 * @author Kanaeva Ekaterina
 */
class DivisionByZero extends Exception {

    /**
     * constructor for exception DivisionByZero
     */
    public DivisionByZero() {
    }

    /**
     * constructor for exception DivisionByZero
     *
     * @param str string, which is written when the exception is thrown
     */
    public DivisionByZero(String str) {
        System.out.println(str);
    }
}
