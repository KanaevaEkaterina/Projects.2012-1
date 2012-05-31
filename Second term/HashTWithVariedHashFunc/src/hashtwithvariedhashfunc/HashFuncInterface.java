/*
 * interface for hashFunction method of class hashTable
 */
package hashtwithvariedhashfunc;

/**
 *
 * @author Kanaeva Ekaterina
 */
public interface HashFuncInterface {

    /**
     * hash function for hash table, that should be override
     * 
     * @param str string, which hash function you want to get
     */
    public int hashFunction(String str);
}
