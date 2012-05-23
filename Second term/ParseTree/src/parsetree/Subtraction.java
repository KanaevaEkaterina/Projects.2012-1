/*
 * Implementation of Operation for subtraction
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Subtraction extends Operation {

    /**
     * subtraction
     *
     * @param first minuend
     * @param second subtrahend
     * @return result of subtraction
     */
    @Override
    public int calc(int first, int second){
            return first - second;
    }
}