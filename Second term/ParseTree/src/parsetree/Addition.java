/*
 * Implementation of Operation for addition
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Addition extends Operation {

    /**
     * addition
     *
     * @param first first summand
     * @param second second summand
     * @return result of addition
     */
    @Override
    public int calc(int first, int second){
            return first + second;
    }
}
