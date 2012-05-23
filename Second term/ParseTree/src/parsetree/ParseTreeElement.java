/*
 * Element of ParseTree
 */
package parsetree;

/**
 *
 * @author Kanaeva Ekaterina
 */
public abstract class ParseTreeElement {
     //public ParseTreeElement() {
        //}

      //  public ParseTreeElement(char newLabel) {
       //         label = newLabel;
       // }

        public ParseTreeElement getLChild() {
            return lChild;
        }

        public ParseTreeElement getRChild() {
            return rChild;
        }

        public void setLChild(ParseTreeElement child) {
            lChild = child;
        }

        public void setRChild(ParseTreeElement child) {
            rChild = child;
        }

        public char getLabel() {
            return label;
        }

        public void setLabel(char ch){
            label = ch;
        }
      /*  public ParseTreeElement setLabel(char newLabel) {
            ParseTreeElement newEl = new ParseTreeElement(newLabel);
            if (newLabel == '+') {
                newEl = new Addition();
            } else if (newLabel == '-') {
                newEl = new Subtraction();
            } else if (newLabel == '*') {
                newEl = new Multiplication();
            } else if (newLabel == '/') {
                newEl = new Division();
            }
            return newEl;
            
        } */

        public boolean isEmpty() {
            return (rChild == null && lChild == null);
        }

        public boolean isDigit() {
            return (getLabel() <= '9' && getLabel() >= '0');
        }
        
        public abstract int calc(int first, int second) ;/*throws DivisionByZero*/ 
        
        
        private ParseTreeElement lChild;
        private ParseTreeElement rChild;
        char label;
}
