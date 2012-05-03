/*
 * EmptyQueueException exception for PriorityQueue, which is thrown, when you delete element from empty queue
 */
package priorityqueue;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class EmptyQueueException extends Exception {

    /*
     * constructor for EmptyQueueException
     */
    public EmptyQueueException() {
        super();
    }

    /*
     * constructor for EmptyQueueException
     * 
     * @param str string, which is written, when exception is thrown
     */
    public EmptyQueueException(String str) {
        super(str);
    }
}
