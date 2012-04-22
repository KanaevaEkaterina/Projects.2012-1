package hasht;

/**
 * create hash table
 *
 * @author Kanaeva Ekaterina
 */
public class HashT {

    /**
     * constructor for hash table
     */
    public HashT() {
        for (int i = 0; i < hashSize; i++) {
            mass[i] = new List();
        }
    }

    /**
     * return hash function of the string
     *
     * @param str string for conversion
     * @return value or hash function of the string
     */
    public int hashFunction(String str) {
        int hashCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char[] str1 = str.toCharArray();
            hashCount = hashCount * p + str1[i];
        }
        return hashCount;
    }

    /**
     * add element to hash table
     *
     * @param str string for addition
     */
    public void addHash(String str) {
        int i = hashFunction(str) % 100;
        mass[i].addToEnd(str);
    }

    /**
     * print hash table
     */
    public void printHash() {
        for (int i = 0; i < hashSize; i++) {
            System.out.print(i + " ");
            mass[i].printList();
            System.out.println(" ");
        }
    }

    /**
     * check, if string is in hash table
     *
     * @param str string, which you want to find in hash table
     * @return true, if the string is in hash table, false - otherwise
     */
    public boolean isInHashTable(String str) {
        int i = hashFunction(str) % 100;
        return mass[i].searchForElement(str);
    }

    /**
     * delete element from hash table
     *
     * @param str string for deletion
     */
    public void deleteElement(String str) {
        int i = hashFunction(str) % 100;
        mass[i].deleteElement(str);
    }
    /**
     * prime number for hash function
     */
    private int p = 13;
    /**
     * size of hash table
     */
    private int hashSize = 100;
    /**
     * elements of hash table
     */
    private List[] mass = new List[hashSize];
}
