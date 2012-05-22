/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsetree;
/*
 *
 * @author Kanaeva Ekaterina
 */

public class ParseTree {

    public ParseTree(String str) {

        addToTree(str, root, 0);
    }

    public void addToTree(String str, ParseTreeElement current, int pos) {
        if (current == root) {
            ParseTreeElement parent = new ParseTreeElement(str.charAt(pos));
            current = parent;
            root = parent;
            pos++;
        }
        ParseTreeElement lCh = new ParseTreeElement(str.charAt(pos));
        current.setLChild(lCh);
        pos++;
        if (!current.getLChild().isDigit()) {
            addToTree(str, current.getLChild(), pos);
            int countNum = 0;
            int countOper = 0;
            while (countNum != countOper + 2) {
                if (str.charAt(pos) <= '9' && str.charAt(pos) >= '0') {
                    countNum++;
                } else {
                    countOper++;
                }
                pos++;
            }
            ParseTreeElement rCh = new ParseTreeElement(str.charAt(pos));
            current.setRChild(rCh);
            if (!current.getRChild().isDigit()) {
                 pos++;
                 addToTree(str, current.getRChild(), pos);
            }
        } 
        else {
            ParseTreeElement rCh = new ParseTreeElement(str.charAt(pos));
            current.setRChild(rCh);
        }


    }

    public interface Operation {

        public int calc(int first, int second) throws DivisionByZero;
    }

    public class Sum implements Operation {

        @Override
        public int calc(int first, int second) {
            return first + second;
        }
    }

    public class Minus implements Operation {

        @Override
        public int calc(int first, int second) {
            return first - second;
        }
    }

    public class Division implements Operation {

        @Override
        public int calc(int first, int second) throws DivisionByZero {
            if (second != 0) {
                return first / second;
            } else {
                throw new DivisionByZero();
            }
        }
    }

    public class Multiplication implements Operation {

        @Override
        public int calc(int first, int second) {
            return first * second;
        }
    }

   public void print(){
       System.out.println(root.label);
       System.out.print(root.lChild.label);
       System.out.print(" ");
       System.out.println(root.rChild.label);
       System.out.println(root.rChild.label);
       System.out.print(root.lChild.lChild.label);
       System.out.print(" ");
       System.out.print(root.lChild.rChild.label);
       System.out.print(" ");
   }
   
    public int calculator(ParseTreeElement current) {
        int first = 0;
        int second = 0;
        char sign = current.getLabel();
        System.out.println(sign);
        if (!current.getLChild().isDigit()) {
            first = calculator(current.getLChild());
            System.out.println(first);
        } else {
        first = current.getLChild().getLabel() - 48;
        System.out.println(first);
        }
        if (!current.getRChild().isDigit()) {
            second = calculator(current.getRChild());
            System.out.println(second);
        } else {
        second = current.getRChild().getLabel() - 48;
        System.out.println(second);
        }
        if (sign == '+') {
            return first + second;
        }
        if (sign == '-') {
            return first - second;
        }
        if (sign == '*') {
            return first * second;
        }
        if (sign == '/') {
            return first / second;
        } else {
            return 0;
        }


    }

    public void preorder(ParseTreeElement pos) {
        ParseTreeElement tmp = pos;
        System.out.print(tmp.getLabel());
        ParseTreeElement child = tmp.getLChild();
        while (!child.isEmpty()) {
            preorder(child);
            child = child.getRSibling();
        }
    }

    public ParseTreeElement getRoot() {
        return root;


    }
    private ParseTreeElement root;

    public class ParseTreeElement {

        public ParseTreeElement() {
        }

        public ParseTreeElement(char newLabel) {
            label = newLabel;
        }

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

        public ParseTreeElement getLSibling() {
            return parent.lChild;
        }

        public ParseTreeElement getRSibling() {
            return parent.rChild;
        }

        public char getLabel() {
            return label;
        }

        public void setLabel(char newLabel) {
            label = newLabel;
        }

        public boolean isEmpty() {
            return (rChild == null && lChild == null);
        }

        public boolean isDigit() {
            return (getLabel() <= '9' && getLabel() >= '0');
        }
        private ParseTreeElement lChild;
        private ParseTreeElement rChild;
        private ParseTreeElement parent;
        char label;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "+-54+36";
        ParseTree tree = new ParseTree(str);
        System.out.println(tree.calculator(tree.getRoot()));
    }
}
