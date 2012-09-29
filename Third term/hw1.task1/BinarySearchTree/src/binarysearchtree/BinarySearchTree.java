package binarysearchtree;

/**
 * class for binary search tree
 *
 * @author Kanaeva Ekaterina
 */
public class BinarySearchTree implements Iterable<Integer> {

    /**
     * constructor for binary search tree
     */
    public BinarySearchTree() {
    }

    /**
     * check if tree is empty
     *
     * @return true, if tree is empty, false - otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * add element to the tree
     *
     * @param value value of the element, that should be added
     */
    public void add(int value) {
        if (this.isEmpty()) {
            head = new TreeElement();
            head.setValue(value);
        } else {
            head.addToVertex(value);
        }
    }

    /**
     * check if this element is in the tree
     *
     * @return true, if the element is in the tree, false - otherwise
     */
    public boolean search(int value) {
        if (this.isEmpty()) {
            return false;
        } else {
            return head.searchInVertex(value);
        }
    }

    /**
     * remove element from the tree
     *
     * @param value value of the element, that should be removed
     */
    public void remove(int value) {
        removeFromSubtree(head, value);
    }

    /**
     * remove element from the subtree
     *
     * @param value value of the element, that should be removed
     * @param node root of the subtree
     */
    public void removeFromSubtree(TreeElement node, int value) {
        if (node != null) {
            while (node.getValue() != value) {
                if (node.getValue() <= value) {
                    node = node.getRight();
                } else {
                    node = node.getLeft();
                }
            }
            if (node.getLeft() == null && node.getRight() != null) {
                if (node.getParent() == null) {
                    head = node.getRight();
                } else if (node.getParent().getValue() < node.getValue()) {
                    node.getParent().setRight(node.getRight());
                } else if (node.getParent().getValue() > node.getValue()) {
                    node.getParent().setLeft(node.getRight());
                }
            } else if (node.getRight() == null && node.getLeft() != null) {
                if (node.getParent() == null) {
                    head = node.getLeft();
                } else if (node.getParent().getValue() < node.getValue()) {
                    node.getParent().setRight(node.getLeft());
                } else if (node.getParent().getValue() > node.getValue()) {
                    node.getParent().setLeft(node.getLeft());
                }
            } else if (node.getRight() == null && node.getLeft() == null) {
                if (node.getParent() == null) {
                    head = null;
                } else if (node.getParent().getValue() < node.getValue()) {
                    node.getParent().setRight(null);
                } else if (node.getParent().getValue() > node.getValue()) {
                    node.getParent().setLeft(null);
                }

            } else if (node.getRight() != null && node.getLeft() != null) {
                TreeElement node2 = node.getRight();
                while (node2.getLeft() != null) {
                    node2 = node2.getLeft();
                }
                node.setValue(node2.getValue());
                removeFromSubtree(node2, node2.getValue());
            }
        }

    }

    /**
     * return head of the tree
     *
     * @return element, that is head of the tree
     */
    public TreeElement getHead() {
        return head;
    }
    
    /**
     * return iterator for the tree
     *
     * @return iterator
     */
    @Override
    public TreeIterator iterator(){
        return new TreeIterator(this);
    }
    /**
     * element of the tree
     */
    private TreeElement head;
}
