/*
 * class Leaf for elements in ParseTree, that are numbers 
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Leaf extends ParseTreeElement {

    public Leaf(char ch){
        leaf = ch;
    }
    /**
     * calculate leaf's value
     * 
     * @param first first number for calculation
     * @param second second number for calculation
     * @return integer representation of char-element
     */
    @Override
    public  int calc(int first, int second){
        return leaf - 48;
    }
    
    private char leaf;
}
