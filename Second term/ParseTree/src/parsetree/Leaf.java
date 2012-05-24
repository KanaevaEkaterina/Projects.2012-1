/*
 * class Leaf for elements in ParseTree, that are numbers 
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Leaf extends ParseTreeElement {

    /*
     * constructor for leaf - element that is number
     */
    public Leaf(char ch) {
        label = ch;
    }

    /*
     * print label
     */
    @Override
    public void print() {
        System.out.print(label);
    }

    /*
     * return label
     *
     * @return label
     */
    @Override
    public char getLabel() {
        return label;
    }

    /**
     * calculate leaf's value
     *
     * @param first first number for calculation
     * @param second second number for calculation
     * @return integer representation of char-element
     */
    @Override
    public int calc(int first, int second) {
        return label - 48;
    }
    /*
     * label of the element - number
     */
    private char label;
}
