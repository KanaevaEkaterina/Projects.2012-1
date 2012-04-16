package uniquelist;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests for UniqueList
 *
 * @author Kanaeva Ekaterina
 */
public class UniqueListTest {

    /**
     *
     */
    public UniqueListTest() {
    }

    /**
     * test of searchForUniqueness method from class UniqueList
     */
    @Test
    public void testSearchForUniqueness() {
        UniqueList instance = new UniqueList();
        assertEquals(true, instance.searchForUniqueness(2));
    }

    /**
     * test of addToBegin method from class UniqueList
     */
    @Test
    public void testAddToBegin() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToBegin(1);
        instance.addToBegin(2);
        assertEquals(2, instance.head.value);
    }

    /**
     * test of addToEnd method from class UniqueList
     */
    @Test
    public void testAddToEnd() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.addToEnd(2);
        assertEquals(2, instance.tail.value);
    }

    /**
     * test of deleteElement method from class UniqueList
     */
    @Test
    public void testDeleteElement() throws ElementNotFound, RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.addToEnd(2);
        instance.deleteElement(1);
        assertEquals(2, instance.head.value);
    }

    /**
     * test of add method from class UniqueList
     */
    @Test
    public void testAdd() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.add(2);
        instance.add(1);
        instance.add(3);
        assertEquals(1, instance.head.value);
    }

    /**
     * test of addToPlace method from class UniqueList
     */
    @Test
    public void testAddToPlace() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToPlace(2, 1);
        assertEquals(2, instance.head.value);
    }

    @Test(expected = RepeatingElement.class)
    /**
     * test of addToBegin method from class UniqueList, in case, when element is
     * repeating
     */
    public void testAddRepeatingElementToBegin() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToBegin(2);
        instance.addToBegin(2);
    }

    /**
     * test of addToEnd method from class UniqueList, in case, when element is
     * repeating
     */
    public void testAddRepeatingElementToEnd() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.addToEnd(1);
    }

    /**
     * test of add method from class UniqueList, in case, when element is
     * repeating
     */
    public void testAddRepeatingElement() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.add(1);
        instance.add(1);
    }

    /**
     * test of addToPlace method from class UniqueList, in case, when element is
     * repeating
     */
    public void testAddRepeatingElementToPlace() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToPlace(2, 3);
        instance.addToPlace(2, 4);
        instance.addToPlace(2, 4);
    }

    @Test(expected = ElementNotFound.class)
    /**
     * test of method deleteElement from class UniqueList, in case when element
     * is not found
     */
    public void testDeleteNotFoundElement() throws ElementNotFound, RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.deleteElement(2);
    }
}
