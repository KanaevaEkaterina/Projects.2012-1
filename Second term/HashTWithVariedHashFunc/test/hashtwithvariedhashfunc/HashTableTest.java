/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtwithvariedhashfunc;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class HashTableTest {
    
    public HashTableTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        hashFunc = new HashFunction1();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addHash method form class HashT.
     */
    @Test
    public void testAddHash() {
        HashTable instance = new HashTable(hashFunc);
        instance.addHash("b");
        assertTrue(instance.isInHashTable("b"));
    }

    /**
     * Test of isInHashTable method from class HashT.
     */
    @Test
    public void TestIsInHashTable() {
        HashTable instance = new HashTable(hashFunc);
        assertFalse(instance.isInHashTable("be"));
    }

    /**
     * Test of deleteElement method from class HashT.
     */
    @Test
    public void testDeleteElement() {
        HashTable instance = new HashTable(hashFunc);
        instance.addHash("b");
        instance.deleteElement("b");
        assertFalse(instance.isInHashTable("b"));
    }

    /**
     * Test of changeHashFunction method, of class HashTable.
     */
    @Test
    public void testChangeHashFunction() {
        HashTable instance = new HashTable(hashFunc);
        instance.addHash("abc");
        instance.addHash("fdc");
        hashFunc = new HashFunction2();
        instance.changeHashFunction(hashFunc);
        assertTrue(instance.isInHashTable("abc"));
        assertTrue(instance.isInHashTable("fdc"));
    }
    
    HashFuncInterface hashFunc;
}
