/*
 * Tests for methods of class List
 */
package genericlist;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class ListTest {
    
    public ListTest() {
    }

    @Before
    public void setUp() {
        intList = new List<>();
        strList = new List<>();
    }
    
    /**
     * Test of addToBegin method, of class List.
     */
    @Test
    public void testAddIntegerToBegin() {
        intList.addToBegin(3);
        intList.addToBegin(4);
        assertEquals(4, intList.first(), 0.0);
        assertEquals(3, intList.last(), 0.0);
    }

    /**
     * Test of addToBegin method, of class List.
     */
    @Test
    public void testAddStringToBegin() {
        strList.addToBegin("world");
        strList.addToBegin("hello");
        assertEquals("hello", strList.first());
    }
    
    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddIntegerToEnd() {
        intList.addToEnd(3);
        intList.addToEnd(4);
        assertEquals(4, intList.last(), 0.0);
        assertEquals(3, intList.first(), 0.0);
    }
    
    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddStringToEnd() {
        strList.addToEnd("Hello");
        strList.addToEnd("world");
        assertEquals("world", strList.last());
    }
    
    /**
     * Test of isEmpty method, of class List.
     */
    @Test
    public void testIsEmpty() throws DeletionFromEmptyListException {
        assertTrue(intList.isEmpty());
        intList.addToBegin(3);
        assertFalse(intList.isEmpty());
        intList.deleteFromEnd();
        assertTrue(intList.isEmpty());
        assertTrue(strList.isEmpty());
    }

    /**
     * Test of deleteFromBegin method, of class List.
     */
    @Test
    public void testDeleteIntegerFromBegin() throws DeletionFromEmptyListException {
        intList.addToBegin(3);
        intList.addToBegin(4);
        intList.deleteFromBegin();
        assertEquals(3, intList.first(), 0.0);
    }
    
    
    /**
     * Test of deleteFromBegin method, of class List.
     */
    @Test
    public void testDeleteStringFromBegin() throws DeletionFromEmptyListException {
        strList.addToBegin("world");
        strList.addToBegin("Hello");
        strList.deleteFromBegin();
        assertEquals("world", strList.first());
    }
    
    /**
     * Test of deleteFromBegin method, of class List.
     */
    @Test
    public void testDeleteIntegerFromEnd() throws DeletionFromEmptyListException {
        intList.addToBegin(3);
        intList.addToBegin(4);
        intList.deleteFromEnd();
        assertEquals(4, intList.last(), 0.0);
    }
    
    /**
     * Test of deleteFromBegin method, of class List.
     */
    @Test
    public void testDeleteStringFromEnd() throws DeletionFromEmptyListException {
        strList.addToBegin("world");
        strList.addToBegin("Hello");
        strList.deleteFromEnd();
        assertEquals("Hello", strList.last());
    }

    /**
     * Test of printList method, of class List.
     */
    @Test
    public void testPrintList() {
        intList.printList();
        intList.addToBegin(3);
        intList.printList();
        strList.addToBegin("hello");
        strList.printList();
    }

    /**
     * Test of deleteElement method, of class List.
     */
    @Test
    public void testDeleteIntegerElement() throws DeletionFromEmptyListException {
        intList.addToBegin(3);
        intList.addToEnd(4);
        intList.addToBegin(2);
        intList.deleteElement(4);
        assertEquals(3, intList.last(), 0.0);
    }

    /**
     * Test of deleteElement method, of class List.
     */
    @Test
    public void testDeleteStringElement() throws DeletionFromEmptyListException {
        strList.addToBegin(",");
        strList.addToEnd("world");
        strList.addToBegin("Hello");
        strList.deleteElement("world");
        assertEquals(",", strList.last());
    }
    
    /**
     * Test of addToPlace method, of class List.
     */
    @Test
    public void testAddIntegerToPlace() {
        intList.addToPlace(2, 1);
        intList.addToPlace(3, 2);
        intList.addToPlace(1, 1);
        assertEquals(1, intList.first(), 0.0);
        assertEquals(3, intList.last(), 0.0);
    }
    
     /**
     * Test of addToPlace method, of class List.
     */
    @Test
    public void testAddStringToPlace() {
        strList.addToPlace(",", 1);
        strList.addToPlace("world", 2);
        strList.addToPlace("Hello", 1);
        assertEquals("Hello", strList.first());
        assertEquals("world", strList.last());
    }

    /**
     * Test of numberOfElements method, of class List.
     */
    @Test
    public void testNumberOfElements() throws DeletionFromEmptyListException {
        assertEquals(0, intList.numberOfElements());
        intList.addToBegin(3);
        intList.addToBegin(2);
        assertEquals(2, intList.numberOfElements());
        intList.deleteFromBegin();
        assertEquals(1, intList.numberOfElements());
        strList.addToEnd("Yes");
        assertEquals(1, strList.numberOfElements());
    }
    
    @Test(expected = DeletionFromEmptyListException.class)

    /**
     * Test of deleteFromBegin method, of class List, in case, when list is empty.
     */
    public void testDeleteIntegerFromBeginInCaseOfEmptness() throws DeletionFromEmptyListException {
        intList.deleteFromBegin();
    }
    
    
    /**
     * Test of deleteFromBegin method, of class List, in case, when list is empty.
     */
    public void testDeleteStringFromBeginInCaseOfEmptness() throws DeletionFromEmptyListException {
        strList.deleteFromBegin();
    }
    
    /**
     * Test of deleteFromBegin method, of class List, in case, when list is empty.
     */
    public void testDeleteIntegerFromEndInCaseOfEmptness() throws DeletionFromEmptyListException {
        intList.deleteFromEnd();
    }
    
    /**
     * Test of deleteFromBegin method, of class List, in case, when list is empty.
     */
    public void testDeleteStringFromEndInCaseOfEmptness() throws DeletionFromEmptyListException {
        strList.deleteFromEnd();
    }

    /**
     * Test of deleteElement method, of class List, in case, when list is empty.
     */
    public void testDeleteIntegerElementInCaseOfEmptness() throws DeletionFromEmptyListException {
        intList.deleteElement(4);
    }

    /**
     * Test of deleteElement method, of class List, in case, when list is empty.
     */
    public void testDeleteStringElementInCaseOfEmptness() throws DeletionFromEmptyListException {
        strList.deleteElement("world");
    }
    
    /**
     * Test of next method, of class LIterator.
     */
    @Test
    public void testNext(){
        intList.addToBegin(3);
        intList.addToBegin(4);
        intList.addToBegin(5);
        ListIterator<Integer> iterator = intList.iterator();
        assertEquals(5, iterator.next(), 0.0);
        assertEquals(4, iterator.next(), 0.0);
    }
    
    /**
     * Test of hasNext method, of class LIterator.
     */
    @Test
    public void testHasNext(){
        intList.addToEnd(3);
        intList.addToBegin(4);
        ListIterator<Integer> iterator = intList.iterator();
        assertEquals(true, iterator.hasNext());
        iterator.next();
        iterator.next();
        assertEquals(false, iterator.hasNext());
    }
    
    /**
     * Test of remove method, of class LIterator.
     */
    @Test
    public void testRemove(){
        intList.addToBegin(3);
        intList.addToBegin(4);
        intList.addToBegin(5);
        ListIterator<Integer> iterator = intList.iterator();
        iterator.remove();
        assertEquals(4, intList.first(), 0.0);
        iterator.next();
        iterator.remove();
        assertEquals(4, intList.last(), 0.0);
        
    }
    

    private List<Integer> intList;
    private List<String> strList;
}
