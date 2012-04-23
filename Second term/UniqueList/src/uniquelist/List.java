package uniquelist;

/**
 * create list
 *
 * @author Kanaeva Ekaterina
 */
public class List {

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
    public void addToBegin(int j) throws RepeatingElement {
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
    public void addToEnd(int j) throws RepeatingElement {
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
    public void deleteFromBegin() throws ElementNotFound {
        if (!isEmpty()) {
            head = head.next;
        } else {
            System.out.println("Error. Is empty");
        }
    }

    /**
     * delete number from the end of the list
     */
    public void deleteFromEnd() throws ElementNotFound {
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
            System.out.println("Error. Is empty");
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
    public void deleteElement(int value) throws ElementNotFound {
        ListElement index = head;
        if (index.value == value) {
            deleteFromBegin();
        } else {
            while (index.next != null) {
                if (index.next.value == value) {
                    index.next = index.next.next;
                } else {
                    index = index.next;
                }
            }
            if ((index.next == null) && (index.value == value)) {
                deleteFromEnd();
            }
        }
    }

    /**
     * add number to the list in sorted order
     *
     * @param value value for addition
     */
    public void add(int value) throws RepeatingElement {
        ListElement index = head;
        ListElement further = new ListElement(value);
        if (index == null || index.value >= value && index.next == null) {
            addToBegin(value);
        } else {
            while (index.next != null) {
                if (index.next.value <= value) {
                    index = index.next;
                } else {
                    further.next = index.next;
                    index.next = further;
                    break;
                }
            }
            if (index.next == null) {
                addToEnd(value);
            }
        }
    }

    /**
     * add number to the special position in the list
     *
     * @param value value for addition
     * @param number number of index, where to put the string
     */
    public void addToPlace(int value, int number) throws RepeatingElement {
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
     * pointer to the begin of the list
     */
    protected ListElement head;
    /**
     * pointer to the end of the list
     */
    protected ListElement tail;

    /**
     * element of the list
     */
    class ListElement {

        /**
         * constructor of list's element
         *
         * @param n value, which should be in this list's element
         */
        public ListElement(int n) {
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
        protected int value;
        /**
         * pointer to the next element in the list
         */
        protected ListElement next;
    }
}
