package hashtwithvariedhashfunc;

/**
 * create list for hash table
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
     * check, if string is in list
     *
     * @param value string, which you want to find in list
     * @return true, if the string is in list, false - otherwise
     */
    public boolean searchForElement(String value) {
        boolean isFound = false;
        ListElement index = head;
        if (index != null) {
            if (index.next == null && index.value == value) {
                isFound = true;
            } else {
                while (index.next != null) {
                    if (index.value != value) {
                        index = index.next;
                    } else {
                        isFound = true;
                        break;
                    }
                }
            }
        }
        return isFound;
    }

    /**
     * add string to the begin of the list
     *
     * @param j string for addition
     */
    public void addToBegin(String j) {
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
     * add string to the end of the list
     *
     * @param j string for addition
     */
    public void addToEnd(String j) {
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
     * chack, if the list is empty
     *
     * @return true, if the list is empty, false - otherwise
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * delete string from the begin of the list
     */
    public void deleteFromBegin() {
        if (!isEmpty()) {
            head = head.next;
        } else {
            System.out.println("Error. Is empty");
        }
    }

    /**
     * delete string from the end of the list
     */
    public void deleteFromEnd() {
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
     * delete the string from the list
     *
     * @param value string for deletion
     */
    public void deleteElement(String value) {
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
     * add string to the special position in the list
     *
     * @param value string for addition
     * @param number number of index, where to put the string
     */
    public void addToPlace(String value, int number) {
        ListElement index = head;
        if (number == 1 || index == null) {
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
     * count the number of element in the list
     *
     * @return number of elements
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
    private ListElement head;
    /**
     * pointer to the end of the list
     */
    private ListElement tail;

    /**
     * Element of the list
     */
    private class ListElement {

        /**
         * constructor of list's element
         *
         * @param n string, which should be in this list's element
         */
        public ListElement(String n) {
            value = n;
        }

        /**
         * print list's element's value
         */
        public void printListElement() {
            System.out.print(value + " ");
        }
        /**
         * String from list's element
         */
        private String value;
        /**
         * pointer to the next element in the list
         */
        private ListElement next;
    }
}
