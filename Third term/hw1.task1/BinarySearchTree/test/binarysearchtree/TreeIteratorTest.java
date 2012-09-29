package binarysearchtree;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

/**
 * test foe methods of class TreeIterator
 *
 * @author Kanaeva Ekaterina
 */
public class TreeIteratorTest {

    public TreeIteratorTest() {
    }

    /**
     * Test of hasNext method, of class TreeIterator.
     */
    @Test
    public void testHasNext() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        TreeIterator iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    /**
     * Test of next method, of class TreeIterator.
     */
    @Test
    public void testNext() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(7);
        TreeIterator iterator = tree.iterator();
        assertEquals(5, iterator.next(), 0.0);
        assertEquals(7, iterator.next(), 0.0);
        assertEquals(4, iterator.next(), 0.0);
        assertEquals(3, iterator.next(), 0.0);
    }

    /**
     * Test of next method, of class TreeIterator, in case, when there's nothing
     * next.
     */
    @Test(expected = NoSuchElementException.class)
    public void testNothingNext() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        TreeIterator iterator = tree.iterator();
        assertEquals(5, iterator.next(), 0.0);
        iterator.next();
    }

    /**
     * Test of remove method, of class TreeIterator.
     */
    @Test
    public void testRemove() {
    }
}
