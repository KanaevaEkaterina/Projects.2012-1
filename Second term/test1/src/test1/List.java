/*
 * creates list using generic-class
 */
package test1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class List<T> implements Iterable<T>{

    /**
     * constructor for list
     */
    public List() {
    }

    /**
     * add number to the begin of the list
     *
     * @param j value for addition
     */
    public void addToBegin(T j) {
        ListElement newEl = new ListElement(j);
        if (!isEmpty()) {
            newEl.next = head;
            head = newEl;
        } else {
            head = newEl;
            tail = newEl;
            newEl.next = null;
        }

    }

    /**
     * add number to the end of the list
     *
     * @param j value for addition
     */
    public void addToEnd(T j) {
        ListElement newEl = new ListElement(j);
        if (isEmpty()) {
            head = newEl;
            tail = newEl;
            newEl.next = null;
        } else {
            newEl.next = null;
            tail.next = newEl;
            tail = newEl;
        }
    }

    /**
     * check if the list is empty
     *
     * @return true, if the list is empty, false - otherwise
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * delete number from the begin of the list
     */
    public void deleteFromBegin() throws DeletionFromEmptyListException {
        if (!isEmpty()) {
            head = head.next;
        } else {
            throw new DeletionFromEmptyListException();
        }
    }

    /**
     * delete number from the end of the list
     */
    public void deleteFromEnd() throws DeletionFromEmptyListException {
        if (!isEmpty()) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                ListElement index = head;
                while (index.next.next != null) {
                    index = index.next;
                }
                index.next = null;
                tail = index;
            }
        } else {
            throw new DeletionFromEmptyListException();
        }
    }

    /**
     * print list
     */
    public void printList() {
        System.out.print("List: ");
        ListElement current = head;
        if (current == null) {
            System.out.println("Is empty");
        }
        while (current != null) {
            current.printListElement();
            current = current.next;
        }
        System.out.println(" ");
    }

    /**
     * delete the number from the list
     *
     * @param value value for deletion
     */
    public void deleteElement(T value) throws DeletionFromEmptyListException {
        ListElement index = head;
        if (index == null) {
            throw new DeletionFromEmptyListException();
        } else {
            if (index.value == value) {
                deleteFromBegin();
            } else {
                while (index.next != null) {
                    if (index.next.value == value) {
                        index.next = index.next.next;
                        if (index.next == null)
                            tail = index;
                    } else {
                        index = index.next;
                    }
                }
            }
        }
    }

    /**
     * add number to the special position in the list
     *
     * @param value value for addition
     * @param number number of index, where to put the string
     */
    public void addToPlace(T value, int number) {
        ListElement index = head;
        if (number == 1) {
            addToBegin(value);
        }
        if ((number > 1) && (number <= numberOfElements())) {
            while (index.next != null) {
                for (int i = 1; i < number - 1; i++) {
                    index = index.next;
                }
                ListElement further = new ListElement(value);
                further.next = index.next;
                index.next = further;
                break;
            }
            if (index.next == null) {
                addToEnd(value);
            }
        }
        if (number == numberOfElements() + 1) {
            addToEnd(value);
        }
    }

    /**
     * count number of elements in the list
     *
     * @return number of elements in the list
     */
    public int numberOfElements() {
        ListElement index = head;
        int count = 0;
        while (index != null) {
            index = index.next;
            count++;
        }
        return count;
    }
    
    /**
     * return element on the given place
     *
     * @param index index of the place
     * @return element
     */
    public ListElement getElement(int index) {
        ListElement current = head;
        for (int i = 1; i < index; i++){
            current = current.next;
        }
        return current;
    }
    
    public T getValue(ListElement elem) {
        return elem.value;
    }
    
    public void setValue(ListElement elem, T value) {
         elem.value = value;
    }
    
    public List<T> bubbleSort(List<T> list) {
        int n = list.numberOfElements();
        for (int i = 1; i <= n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j <= n - 2; j++) {
                if (list.getValue(
                    list.getElement(j)).compareTo(list.getValue(list.getElement(j + 1))) > 0) {
                    T change = list.getValue(list.getElement(j));
                    list.setValue(list.getElement(j + 1), list.getValue(list.getElement(j + 1)));
                    list.setValue(list.getElement(j + 1), change);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return list;
    }
    
    


    /**
     * first element
     *
     * @return first element's value
     */
    public T first() {
        return head.value;
    }

    /**
     * last element
     *
     * @return last element's value
     */
    public T last() {
        return tail.value;
    }

    @Override
    public ListIterator<T> iterator() {
        return new LIterator();
    }

    public class LIterator implements ListIterator<T> {

        public LIterator() {
            pos = head;
        }

        @Override
        public T next() {
            if (hasNext()) {
                ListElement tmp = pos;
                pos = pos.next;
                return tmp.value;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasNext() {
            if (pos == null)
                return false;
            else return true;
        }

        @Override
        public void remove() {
            if (pos == null) {
                throw new NullPointerException();
            } else if (pos == head) {
                head = head.next;
                pos = pos.next;
            } else {
                ListElement tmp = head;
                while (tmp.next != pos) {
                    tmp = tmp.next;
                }
                tmp.next = pos.next;
                if (pos == tail) {
                    pos = tmp;
                    tail = pos;
                } else {
                    pos = pos.next;
                }
            }
        }
        ListElement pos;
    }
    /**
     * pointer to the begin of the list
     */
    private ListElement head;
    /**
     * pointer to the end of the list
     */
    private ListElement tail;

    /**
     * element of the list
     */
    private class ListElement {

        /**
         * constructor of list's element
         *
         * @param n value, which should be in this list's element
         */
        public ListElement(T n) {
            value = n;
        }

        /**
         * print list's element's value
         */
        public void printListElement() {
            System.out.print(value + " ");
        }
        /**
         * value from list's element
         */
        private T value;
        /**
         * pointer to the next element in the list
         */
        private ListElement next;
       
    }
}
