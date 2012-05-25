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

    /*
     * constructor for ParseTree
     *
     * @param str string which should be count
     */
    public ParseTree(String str) {
        addToTree(str, root, 0);
    }

    /*
     * create element for ParseTree
     *
     * @param ch label, depends on which element will be number or operation
     * @return created element
     */
    public static ParseTreeElement createElement(char ch) {
        if (ch >= '0' && ch <= '9') {
            return new Leaf(ch);
        }
        if (ch == '+') {
            return new Addition();
        }
        if (ch == '-') {
            return new Subtraction();
        }
        if (ch == '*') {
            return new Multiplication();
        }
        if (ch == '/') {
            return new Division();
        } else {
            return null;
        }
    }

    /*
     * add symbol from string to the current place in the tree
     *
     * @param str string for taking symbols @param current element to which new
     * element will be add @param pos number of symbol in the string for
     * addition
     */
    public void addToTree(String str, ParseTreeElement current, int pos) {
        if (current == root) {
            ParseTreeElement parent = createElement(str.charAt(pos));
            root = parent;
            current = parent;
            pos++;
        }
        ParseTreeElement lCh = createElement(str.charAt(pos));
        current.setLChild(lCh);
        lCh.setParent(current);
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
            ParseTreeElement rCh = createElement(str.charAt(pos));
            current.setRChild(rCh);
            rCh.setParent(current);
            if (!current.getRChild().isDigit()) {
                pos++;
                addToTree(str, current.getRChild(), pos);
            }
        } else {
            ParseTreeElement rCh = createElement(str.charAt(pos));
            current.setRChild(rCh);
            rCh.setParent(current);
            if (!current.getRChild().isDigit()) {
                pos++;
                addToTree(str, current.getRChild(), pos);
            }
        }


    }

    /*
     * calculate down from current element in the tree
     *
     * @param current starting element for calculation @return result of
     * calculation
     */
    public int calculator(ParseTreeElement current) throws DivisionByZero {
        int first = 0;
        int second = 0;
        if (!current.getLChild().isDigit()) {
            first = calculator(current.getLChild());
        } else {
            first = current.getLChild().getLabel() - 48;
        }
        if (!current.getRChild().isDigit()) {
            second = calculator(current.getRChild());
        } else {
            second = current.getRChild().getLabel() - 48;
        }
        ParseTreeElement sign = current;
        return sign.calc(first, second);
    }

    /*
     * print tree in right order from current place
     *
     * @param current starting element
     */
    public void preorder(ParseTreeElement current) {
        ParseTreeElement tmp = current;
        tmp.print();
        ParseTreeElement child = tmp.getLChild();
        if (child != null) {
            preorder(child);
            preorder(child.getRSibling());
        }
    }

    /*
     * print tree
     */
    public void print() {
        preorder(root);
    }

    /*
     * calculate ParseTree
     */
    public void calculationOfTree() throws DivisionByZero {
        System.out.print("Result: ");
        System.out.println(calculator(root));
    }

    /*
     * root of the ParseTree
     */
    private ParseTreeElement root;

    /**
     * write resilt of calculation of given string
     */
    public static void main(String[] args) {
        String str = "*+55-42";
        ParseTree tree = new ParseTree(str);
        System.out.print("Tree: ");
        tree.print();
        System.out.println(" ");
        try {
            tree.calculationOfTree();
        } catch (DivisionByZero e) {
            e.printStackTrace();
        }
    }
}
