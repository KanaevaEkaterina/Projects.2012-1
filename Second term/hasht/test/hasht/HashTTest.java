package hasht;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class HashTTest {

    public HashTTest() {
    }

    @Test
    public void testHashFunction() {
        HashT instance = new HashT();
        int result = instance.hashFunction("b");
        assertEquals(98, result);
    }

    /**
     * Test of addHash method form class HashT.
     */
    @Test
    public void testAddHash() {
        HashT instance = new HashT();
        instance.addHash("b");
        assertEquals(true, instance.isInHashTable("b"));
    }

    /**
     * Test of isInHashTable method from class HashT.
     */
    @Test
    public void TestIsInHashTable() {
        HashT instance = new HashT();
        assertEquals(false, instance.isInHashTable("be"));
    }

    /**
     * Test of deleteElement method from class HashT.
     */
    @Test
    public void testDeleteElement() {
        HashT instance = new HashT();
        instance.addHash("b");
        instance.deleteElement("b");
        assertEquals(false, instance.isInHashTable("b"));
    }
}