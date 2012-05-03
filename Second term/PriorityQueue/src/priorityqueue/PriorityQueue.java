/*
 * creates queue with priority
 */
package priorityqueue;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class PriorityQueue<T> {
    // constructor

    public PriorityQueue() {
    }

    /*
     * add item to queue
     *
     * @param val value of the added element @param prio priority of the added
     * element
     */
    public void enqueue(T val, int prio) {
        ListElement l = head;
        ListElement tmp = new ListElement(val, prio);
        if (l == null || l.getPrio() < prio) {
            tmp.setNext(head);
            head = tmp;
        } else {
            while (l.getNext() != null && l.getNext().getPrio() >= prio) {
                l = l.getNext();
            }
            tmp.setNext(l.getNext());
            l.setNext(tmp);
        }
    }

    /*
     * delete item from queue
     *
     * @return value of the deleted element
     */
    public T dequeue() throws EmptyQueueException {
        if (head == null) {
            throw new EmptyQueueException("Queue is empty!!!");
        }
        ListElement tmp = head;
        head = tmp.getNext();
        return tmp.getValue();
    }

    /*
     * pointer, that identify first element of queue
     */
    private ListElement head;

    /*
     * queue's element
     */
    private class ListElement {

        /*
         * constructor for queue's element
         */
        public ListElement() {
        }

        /*
         * constructor for queue's element
         *
         * @param v value of added element @param p priority of added element
         */
        public ListElement(T v, int p) {
            value = v;
            prio = p;
        }

        /*
         * return next element
         *
         * @return pointer to the next element
         */
        public ListElement getNext() {
            return next;
        }

        /*
         * set next element
         *
         * @param nxt element, that will be the next
         */
        public void setNext(ListElement nxt) {
            next = nxt;
        }

        /*
         * return element's value
         *
         * @return value of the element
         */
        public T getValue() {
            return value;
        }

        /*
         * return element's priority
         *
         * @return int-number - priority of the element
         */
        public int getPrio() {
            return prio;
        }
        /*
         * element's value
         */
        private T value;
        /*
         * next element
         */
        private ListElement next;
        /*
         * element's priority
         */
        private int prio;
    }
}
