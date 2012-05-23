/*
 * interface for mathematical operation
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public abstract class Operation extends ParseTreeElement {

    /**
     * calculate using one of the operations
     * 
     * @param first first number for calculation
     * @param second second number for calculation
     * @return result of calculation
     */
    public abstract int calc(int first, int second) /*throws DivisionByZero*/;
}
