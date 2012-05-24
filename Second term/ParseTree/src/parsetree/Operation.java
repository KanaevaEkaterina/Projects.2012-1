/*
 * interface for mathematical operation
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public abstract class Operation extends ParseTreeElement {
            
    @Override
    public void setLChild(ParseTreeElement lCh){
        lChild = lCh;
    }
    
    @Override
    public void setRChild(ParseTreeElement rCh){
        rChild = rCh;
    }
    
    @Override
    public ParseTreeElement getLChild(){
        return lChild;
    }
    
    @Override
    public ParseTreeElement getRChild(){
        return rChild;
    }
    
    @Override
    public abstract char getLabel();
    /**
     * calculate using one of the operations
     * 
     * @param first first number for calculation
     * @param second second number for calculation
     * @return result of calculation
     */
    @Override
    public abstract int calc(int first, int second) throws DivisionByZero;
}
