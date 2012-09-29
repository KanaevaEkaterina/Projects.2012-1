package binarysearchtree;

import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

/**
 * iterator for binary search tree
 *
 * @author Kanaeva Ekaterina
 */
public class TreeIterator implements Iterator<Integer> {

    /**
     * constructor for TreeIterator
     */
    public TreeIterator(BinarySearchTree tree) {
        node = tree.getHead();
        stack.push(node);
    }

    /**
     * check if the element has next one
     *
     * @return true, if the element has next, false - otherwise
     */
    @Override
    public boolean hasNext() {
        return node != null;
    }

    /**
     * return value of the current element and move pointer to the next one
     *
     * @return value of the current element
     */
    @Override
    public Integer next() {
        if (node == null) {
            throw new NoSuchElementException();
        }
        node = stack.pop();
        int value = node.getValue();
        if (node.getLeft() != null) {
            stack.push(node.getLeft());
        }
        if (node.getRight() != null) {
            stack.push(node.getRight());
        }
        if (stack.empty()) {
            node = null;
        }
        return value;
    }

    /**
     * method without overriding
     */
    @Override
    public void remove() {
    }
    /**
     * current element of the tree
     */
    private TreeElement node;
    /**
     * stack for elements of the tree, which verteces've been visited, but
     * haven't printed yet
     */
    private Stack<TreeElement> stack = new Stack<>();
}
