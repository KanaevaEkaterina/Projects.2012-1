package set;

/**
 * create generic-class for set
 *
 * @author Kanaeva Ekaterina
 */
public class Set<T> {

    /**
     * constructor for set
     */
    public Set() {
    }

    /**
     * add element to the set
     *
     * @param element element for addition
     */
    public void add(T element) {
        if (!isInSet(element)) {
            SetElement newEl = new SetElement(element);
            if (!isEmpty()) {
                newEl.next = first;
                first = newEl;
            } else {
                first = newEl;
                newEl.next = null;
            }
        }
    }

    /**
     * delete element from the set if the element to be deleted is not in set,
     * ElementNotFound - exception is thrown
     *
     * @param element element for deletion
     */
    public void delete(T element) throws ElementNotFound {
        if (isInSet(element)) {
            SetElement<T> current = first;
            if (current.value == element) {
                first = first.next;
            } else {
                while (current.next != null) {
                    while (current.next.value != element) {
                        current = current.next;
                    }
                    current.next = current.next.next;
                }
            }
        } else {
            throw new ElementNotFound();
        }
    }

    /**
     * checks, if set is empty
     *
     * @return true, if set is empty, false - otherwise
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * return intersection of two sets
     *
     * @param set1 first set for intersection
     * @param set2 second set for intersection
     * @return set - result of intersection
     */
    public Set<T> intersectionOfSets(Set<T> set1, Set<T> set2) {
        Set<T> resultSet = new Set<>();
        SetElement<T> currentInFirstSet = set1.first;
        if (!set1.isEmpty() && !set2.isEmpty()) {
            while (currentInFirstSet != null) {
                if (set2.isInSet(currentInFirstSet.value))
                    resultSet.add(currentInFirstSet.value);
                currentInFirstSet = currentInFirstSet.next;
            }
        }
        return resultSet;
    }

    /**
     * return union of two sets
     *
     * @param set1 first set for union
     * @param set2 second set for union
     * @return set - result of union
     */
    public Set<T> unionOfSets(Set<T> set1, Set<T> set2) {
        Set<T> resultSet = set1;
        SetElement<T> currentInSecondSet = set2.first;
        while (currentInSecondSet != null) {
            resultSet.add(currentInSecondSet.value);
            currentInSecondSet = currentInSecondSet.next;
        }
        return resultSet;
    }

    /**
     * checks, if element is already in the set
     *
     * @param element for checking
     * @return true, if element is in the set, false - otherwise
     */
    public boolean isInSet(T element) {
        boolean isFound = false;
        SetElement index = first;
        while (index != null) {
            if (index.value != element) {
                index = index.next;
            } else {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    /**
     * print set
     */
    public void printSet() {
        System.out.print("Set: ");
        SetElement current = first;
        if (isEmpty()) {
            System.out.println("Is empty");
        } else {
            while (current != null) {
                current.printSetElement();
                current = current.next;
            }
            System.out.println(" ");
        }
    }

    /**
     * shows number of elements in the set
     *
     * @return number of elements in the set
     */
    public int numberOfElements() {
        SetElement<T> current = first;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * chaecks, if two sets are equal
     *
     * @param set2 second set for checking
     * @return true, if sets are equal, false - otherwise
     */
    public boolean equalSets(Set<T> set2) {
        boolean equal = true;
        if (numberOfElements() == set2.numberOfElements()) {
            SetElement<T> current = first;
            while (current != null) {
                if (!set2.isInSet(current.value)) {
                    equal = false;
                    break;
                }
                current = current.next;
            }
        } else {
            equal = false;
        }
        return equal;
    }
    /**
     * pointer to the first element in the set
     */
    private SetElement<T> first;

    /**
     * element of the set
     */
    private class SetElement<T> {

        /**
         * constructor for set's element
         */
        public SetElement(T element) {
            value = element;
        }

        /**
         * print set's element
         */
        public void printSetElement() {
            System.out.print(value + " ");
        }
        /**
         * value of elements in the set
         */
        private T value;
        /**
         * pointer to the next element in the set
         */
        private SetElement<T> next;
    }
}
