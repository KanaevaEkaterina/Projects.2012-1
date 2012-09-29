package binarysearchtree;

/**
 * class for element of the binary search tree
 *
 * @author Kanaeva Ekaterina
 */
public class TreeElement {

    /**
     * return value of the element
     *
     * @return value of the element
     */
    public int getValue() {
        return this.value;
    }

    /**
     * set value of the element
     *
     * @param value new value of the element
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * return right child of the element
     *
     * @return right child
     */
    public TreeElement getRight() {
        return this.RChild;
    }

    /**
     * return left child of the element
     *
     * @return left child
     */
    public TreeElement getLeft() {
        return this.LChild;
    }

    /**
     * set right child of the element
     *
     * @param RChild element, that will be right child of the element
     */
    public void setRight(TreeElement RChild) {
        this.RChild = RChild;
    }

    /**
     * set left child of the element
     *
     * @param LChild element, that will be left child of the element
     */
    public void setLeft(TreeElement LChild) {
        this.LChild = LChild;
    }

    /**
     * add new element to the current vertex
     *
     * @param value value of the new element, that should be added
     */
    public void addToVertex(int value) {
        TreeElement newEl = new TreeElement();
        newEl.setValue(value);
        if (value >= this.value) {
            if (this.getRight() != null) {
                this.getRight().addToVertex(value);
            } else {
                this.setRight(newEl);
            }
        } else {
            if (this.getLeft() != null) {
                this.getLeft().addToVertex(value);
            } else {
                this.setLeft(newEl);
            }
        }
    }

    /**
     * check if element with this value is in the vertex
     *
     * @param value element, that is found
     * @return true, if the element is found, false - otherwise
     */
    public boolean searchInVertex(int value) {
        if (this != null) {
            if (value == this.value) {
                return true;
            } else if (value > this.value && this.getRight() != null) {
                return this.getRight().searchInVertex(value);
            } else if (value < this.value && this.getLeft() != null) {
                return this.getLeft().searchInVertex(value);
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * return the element, that is before current one
     *
     * @return parent of the element
     */
    public TreeElement getParent() {
        return this.parent;
    }
    /**
     * value of the element
     */
    private int value;
    /**
     * element, that is right child of the current one
     */
    private TreeElement RChild;
    /**
     * element, that is left child of the current one
     */
    private TreeElement LChild;
    /**
     * element, that is before current one
     */
    private TreeElement parent;
}
