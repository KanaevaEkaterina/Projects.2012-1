/*
 * creates hash table with varied hash function
 */
package hashtwithvariedhashfunc;

import java.util.ArrayList;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class HashTable {

    /**
     * constructor for hash table
     */
    public HashTable(HashFuncInterface hashFunc) {
        for (int i = 0; i < hashSize; i++) {
            mass[i] = new ArrayList();
        }
        hashFunction = hashFunc;
    }

    /**
     * add element to hash table
     *
     * @param str string for addition
     */
    public void addHash(String str) {
        int i = hashFunction.hashFunction(str) % hashSize;
        mass[i].add(str);
    }

    /**
     * check, if string is in hash table
     *
     * @param str string, which you want to find in hash table
     * @return true, if the string is in hash table, false - otherwise
     */
    public boolean isInHashTable(String str) {
        int i = hashFunction.hashFunction(str) % hashSize;
        return mass[i].contains(str);
    }

    /**
     * delete element from hash table
     *
     * @param str string for deletion
     */
    public void deleteElement(String str) {
        int i = hashFunction.hashFunction(str) % hashSize;
        mass[i].remove(str);
    }

    /**
     * change hash function
     *
     * @param newFunction new hash function
     */
    public void changeHashFunction(HashFuncInterface newFunction) {
        ArrayList[] mass1 = new ArrayList[hashSize];
        for (int k = 0; k < hashSize; ++k) {
            mass1[k] = new ArrayList();
        }
        for (int i = 0; i < hashSize; i++) {
            for (Object elem : mass[i]) {
                int j = newFunction.hashFunction(elem.toString()) % hashSize;
                mass1[j].add(elem);
            }
        }
        System.arraycopy(mass1, 0, mass, 0, hashSize);
        hashFunction = newFunction;
    }
    /**
     * size of hash table
     */
    private int hashSize = 100;
    /**
     * elements of hash table
     */
    private ArrayList[] mass = new ArrayList[hashSize];
    /**
     * current hash function of hash table
     */
    private HashFuncInterface hashFunction;
}
