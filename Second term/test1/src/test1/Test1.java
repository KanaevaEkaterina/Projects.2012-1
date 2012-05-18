/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 *
 * @author Master
 */
public class Test1<T> {

    public List<T> bubbleSort(List<T> list) {
        int n = list.numberOfElements();
        for (int i = 1; i <= n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j <= n - 2; j++) {
                if (list.getValue(
                    list.getElement(j)).compareTo(list.getValue(list.getElement(j + 1))) > 0) {
                    T change = list.getValue(list.getElement(j));
                    list.setValue(list.getElement(j + 1), list.getValue(list.getElement(j + 1)));
                    list.setValue(list.getElement(j + 1), change);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return list;
    }


    private class T implements Comparable<T>{    
    @Override
        public int compareTo(T obj2) {
            return obj1.compareTo(obj2);
        }
    T obj1;
   
    }
        
            
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
    }
}
