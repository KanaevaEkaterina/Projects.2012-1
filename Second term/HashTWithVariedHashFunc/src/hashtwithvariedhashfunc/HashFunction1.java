/*
 * hash function for interface HashFuncInterface
 * use 13 as primary number for interpretation
 */
package hashtwithvariedhashfunc;
/**
 *
 * @author Kanaeva Ekaterina
 */
public class HashFunction1 implements HashFuncInterface {

    /**
     * return hash function of the string
     *
     * @param str string for conversion
     * @return value or hash function of the string
     */
    @Override
    public int hashFunction(String str) {
        int hashCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char[] str1 = str.toCharArray();
            hashCount = hashCount * 13 + str1[i];
        }
        return hashCount;
    }
}
