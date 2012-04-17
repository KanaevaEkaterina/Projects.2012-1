package stackcalculator;

/**
 * Exception for StackCalculator, is thrown, when you try to calculate not appropriate elements.
 *
 * @author Kanaeva Ekaterina
 */
class NotDigit extends Exception {

    /**
     * constructor for exception NotDigit
     */
    public NotDigit() {
    }

    /**
     * constructor for exception NotDigit
     * @param str string, which is written when the exception is thrown
     */
    public NotDigit(String str) {
        System.out.println(str);
    }
}