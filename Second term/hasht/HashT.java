/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hasht;

/**
 *
 * @author Master
 */
public class HashT {

    HashT hash;
    private int p = 13;
    private int hashSize = 100;
    List[] mass = new List[hashSize];

    public HashT() {
        for (int i = 0; i < hashSize; i++) {
            mass[i] = new List();
        }
    }

    public int hashFunction(String str) {
        int hashCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char[] str1 = str.toCharArray();
            hashCount = hashCount * p + str1[i];
        }
        return hashCount;
    }

    public void addHash(String str) {
        int i = hashFunction(str) % 100;
        mass[i].addToEnd(str);
    }

    public void printHash() {
        for (int i = 0; i < hashSize; i++) {
            System.out.print(i + " ");
            mass[i].printList();
            System.out.println(" ");
        }
    }
}
