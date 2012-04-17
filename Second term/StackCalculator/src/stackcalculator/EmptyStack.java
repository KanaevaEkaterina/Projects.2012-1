package stackcalculator;

/**
 * Exception for StackCalculator, is thrown, when you try to get elements form
 * emppty stack
 *
 * @author Kanaeva Ekaterina
 */
class EmptyStack extends Exception {

    /**
     * constructor for exception EmptyStack
     */
    public EmptyStack() {
    }

    /**
     * constructor for exception EmptyStack
     *
     * @param str string, which is written when the exception is thrown
     */
    public EmptyStack(String str) {
        System.out.println(str);
    }
}
