/*
 * Exception, that is thrown after division by zero
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
class DivisionByZero extends Exception {

    /**
     * constructor for DivisionByZero exception
     */
    public DivisionByZero() {
    }

    /**
     * constructor for DivisionByZero exception
     * 
     * @param str string, which is written, when exception is thrown
     */
    public DivisionByZero(String str) {
        System.out.println(str);
        
    }
}
