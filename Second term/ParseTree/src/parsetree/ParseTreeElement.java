/*
 * Element of ParseTree
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public abstract class ParseTreeElement {

    /*
     * return left child of the element
     *
     * @return left child
     */
    public ParseTreeElement getLChild() {
        return lChild;
    }

    /*
     * return right child of the element
     *
     * @return right child
     */
    public ParseTreeElement getRChild() {
        return rChild;
    }

    /*
     * set element as left child of current element
     *
     * @param child new left child
     */
    public void setLChild(ParseTreeElement child) {
        lChild = child;
    }

    /*
     * set element as right child of current element
     *
     * @param child new right child
     */
    public void setRChild(ParseTreeElement child) {
        rChild = child;
    }
    
    /*
     * set element as parent of current element
     *
     * @param newParent new parent
     */
    public void setParent(ParseTreeElement newParent) {
        parent = newParent;
    }
    
    /*
     * return right child of element's parent
     *
     * @return parent's right child
     */
    public ParseTreeElement getRSibling(){
        return parent.rChild;
    }

    /*
     * return element's label
     *
     * @return label
     */
    public abstract char getLabel(); 

    /*
     * check, if element has children
     *
     * @return true, if element has no children, false - otherwise
     */
    public boolean isEmpty() {
        return (rChild == null && lChild == null);
    }

    /*
     * check, if element's label is a digit
     *
     * @return true, if element is a digit, false - otherwise
     */
    public boolean isDigit() {
        return (getLabel() <= '9' && getLabel() >= '0');
    }
    
    /*
     * print element's label
     */
    public abstract void print();
 
    /*
     * calculate using operation, if element is operation 
     * return digit, if element is digit
     * 
     *@return result of calculation
     */
    public abstract int calc(int first, int second) throws DivisionByZero;

    /*
     * left child
     */
    protected ParseTreeElement lChild;
    /*
     * right child
     */
    protected ParseTreeElement rChild;
    /*
     * parent
     */
    protected ParseTreeElement parent;
}
