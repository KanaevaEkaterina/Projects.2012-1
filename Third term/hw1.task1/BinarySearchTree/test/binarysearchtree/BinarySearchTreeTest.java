package binarysearchtree;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * tests for methods of class BinarySearchTree
 * 
 * @author Kanaeva Ekaterina
 */
public class BinarySearchTreeTest {

    public BinarySearchTreeTest() {
    }

    /**
     * Test of isEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testIsEmpty() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        tree.add(4);
        assertFalse(tree.isEmpty());
    }

    /**
     * Test of add method, of class BinarySearchTree.
     */
    @Test
    public void testAdd() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        tree.add(3);
        assertFalse(tree.isEmpty());
    }

    /**
     * Test of search method, of class BinarySearchTree.
     */
    @Test
    public void testSearch() {
        BinarySearchTree tree = new BinarySearchTree();
        assertFalse(tree.search(3));
        tree.add(3);
        tree.add(4);
        assertTrue(tree.search(3));
        tree.remove(3);
        assertFalse(tree.search(3));
    }
    
    /**
     * Test of remove method, of class BinarySearchTree.
     */
    @Test
    public void testRemove() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.remove(3);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.remove(4);
        assertFalse(tree.search(4));
        tree.remove(3);
        assertFalse(tree.search(3));
        tree.remove(2);
        assertFalse(tree.search(2));
        assertTrue(tree.isEmpty());
    }

    /**
     * Test of getHead method, of class BinarySearchTree.
     */
    @Test
    public void testGetHead() {
    }

}
