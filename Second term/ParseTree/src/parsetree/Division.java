/*
 * Implementation of  Operation for division
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Division extends Operation{
    
    /**
     * division
     * 
     * @param first dividend
     * @param second divider
     * @return result of division
     */
    @Override
    public int calc(int first, int second) /*throws DivisionByZero */{
        //if (second != 0){
            return first/second;
       // } else throw new DivisionByZero();
    }
}
