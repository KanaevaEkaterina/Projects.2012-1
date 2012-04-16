package uniquelist;

/**
 * Exception for UniqueList, is thrown when the element for addition is already
 * in the list
 *
 * @author Kanaeva Ekaterina
 */
public class RepeatingElement extends Exception {

    /**
     * constructor for exception RepeatingElement
     */
    public RepeatingElement() {
    }

    /**
     * constructor for exception RepeatingElement
     * 
     * @param str string, which is written when the exception is thrown
     */
    public RepeatingElement(String str) {
        System.out.println(str);
    }
}
