/*
 * Implementation of Operation for multiplication
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Multiplication extends Operation {

    /**
     * multiplication
     *
     * @param first first multiplier
     * @param second second multiplier
     * @return result of multiplication
     */
    @Override
    public int calc(int first, int second){
            return first * second;
    }
}