/*
 * Implementation of Operation for subtraction
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Subtraction extends Operation {

    /*
     * print '-', as label of the operation
     */
    @Override
    public void print(){
        System.out.print('-');
    }
    
    /*
     * return label = '-'
     * 
     * @return '-'
     */
    @Override
    public char getLabel(){
        return '-';
    }
    
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