package uniquelist;

/**
 * create list with unrepeating element
 *
 * @author Kanaeva Ekaterina
 */
public class UniqueList extends List {

    /**
     * constructor for unique list
     */
    public UniqueList() {
    }

    /**
     * shows if the element is already in the list
     *
     * @param value value which should be tested for the presence in the list
     * @return true if the element is not found in the list, false - otherwise
     */
    public boolean searchForUniqueness(int value) {
        boolean notFound = true;
        ListElement index = head;
        while (index != null){
            if (index.value == value) {
                notFound = false;
                break;
            }
            index = index.next;
        }
        return notFound;
    }

    /**
     * add number to the begin of the list
     *
     * @param value value for addition
     */
    @Override
    public void addToBegin(int value) throws RepeatingElement {
        if (searchForUniqueness(value)) {
            super.addToBegin(value);
        } else {
            throw new RepeatingElement();
        }

    }

    /**
     * add number to the end of the list
     *
     * @param j value for addition
     */
    @Override
    public void addToEnd(int value) throws RepeatingElement {
        if (searchForUniqueness(value)) {
            super.addToEnd(value);
        } else {
            throw new RepeatingElement();
        }
    }

    /**
     * delete the number from the list
     *
     * @param value value for deletion
     */
    @Override
    public void deleteElement(int value) throws ElementNotFound {
        if (!searchForUniqueness(value)) {
            super.deleteElement(value);
        } else {
            throw new ElementNotFound();
        }
    }

    /**
     * add number to the list in sorted order
     *
     * @param value value for addition
     */
    @Override
    public void add(int value) throws RepeatingElement {
        if (searchForUniqueness(value)) {
            super.add(value);
        } else {
            throw new RepeatingElement();
        }
    }

    /**
     * add number to the special position in the list
     *
     * @param value value for addition
     * @param number number of index, where to put the string
     */
    @Override
    public void addToPlace(int value, int number) throws RepeatingElement {
        if (searchForUniqueness(value)) {
            super.addToPlace(value, number);
        } else {
            throw new RepeatingElement();
        }
    }
}
