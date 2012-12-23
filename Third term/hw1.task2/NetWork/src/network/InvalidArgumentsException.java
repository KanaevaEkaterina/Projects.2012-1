/*
 * class for exception, that appear when arguments for network's constructor are incorrect
 */
package network;

/**
 *
 * @author Kanaeva Yekaterina
 */
public class InvalidArgumentsException extends Exception {

    /**
     *constructor for InvalidArgumentsException
     * 
     */
    public InvalidArgumentsException() {
    }

    /**
     *constructor for InvalidArgumentsException
     * 
     * @param str error message
     */
    public InvalidArgumentsException(String str) {
        super(str);
    }
}
