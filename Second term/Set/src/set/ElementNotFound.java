package set;

/**
 * Exception for class set, is thrown when the element isn't found
 *
 * @author Kanaeva Ekaterina
 */
public class ElementNotFound extends Exception {

    /**
     * constructor for Exception ElementNotFound
     */
    public ElementNotFound() {
    }

    /**
     * constructor for Exception ElementNotFound
     * 
     * @param str string, which you want to write, in case of exception
     */
    public ElementNotFound(String str) {
        System.out.println(str);
    }
}