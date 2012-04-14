package uniquelist;

public class UniqueList extends List {

    public UniqueList() {
    }

    public boolean searchForUniqueness(int value) {
        boolean notFound = true;
        ListElement index = head;
        if (index != null) {
            if (index.next == null && index.value == value) {
                notFound = false;
            } else {
                while (index.next != null) {
                    if (index.value != value) {
                        index = index.next;
                    } else {
                        notFound = false;
                        break;
                    }
                }
            }
        }
        return notFound;
    }

    @Override
    public void addToBegin(int value) throws RepeatingElement {
        if (searchForUniqueness(value)) {
            ListElement newEl = new ListElement(value);
            if (!isEmpty()) {
                newEl.next = head;
                head = newEl;
            } else {
                head = newEl;
                tail = newEl;
                newEl.next = null;
            }
        } else {
            throw new RepeatingElement();
        }

    }

    @Override
    public void addToEnd(int value) throws RepeatingElement {
        if (searchForUniqueness(value)) {
            ListElement newEl = new ListElement(value);
            if (isEmpty()) {
                head = newEl;
                tail = newEl;
                newEl.next = null;
            } else {
                newEl.next = null;
                tail.next = newEl;
                tail = newEl;
            }
        } else {
            throw new RepeatingElement();
        }
    }

    @Override
    public void deleteElement(int value) throws ElementNotFound {
        if (!searchForUniqueness(value)) {
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
        } else {
            throw new ElementNotFound();
        }
    }

    @Override
    public void add(int value) throws RepeatingElement {
        if (searchForUniqueness(value)) {
            ListElement index = head;
            ListElement further = new ListElement(value);
            if (index == null || index.value >= value) {
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
        } else {
            throw new RepeatingElement();
        }
    }

    @Override
    public void addToPlace(int value, int number) throws RepeatingElement {
        ListElement index = head;
        if (number == 1 || index == null) {
            addToBegin(value);
        }
        if ((number > 1) && (number <= numberOfElements())) {
            while (index.next != null) {
                for (int i = 1; i < number - 1; i++) {
                    index = index.next;
                }
                if (searchForUniqueness(value)) {
                    ListElement further = new ListElement(value);
                    further.next = index.next;
                    index.next = further;
                } else {
                    throw new RepeatingElement();
                }
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

    /*
     * public static void main(String[] args) { // TODO code application logic
     * here }
     */
}
