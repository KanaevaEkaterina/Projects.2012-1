/*
 * exception, that is thrown, when you delete element from empty list
 */
package genericlist;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class DeletionFromEmptyListException extends Exception {

    /**
     * constructor for DeletionFromEmptyList exception
     */
    public DeletionFromEmptyListException() {
        super();
    }

    /**
     * constructor for DeletionFromEmptyList exception
     * 
     * @param str string, which will be written after throwing the exception
     */
    public DeletionFromEmptyListException(String str) {
        super(str);
    }
}
