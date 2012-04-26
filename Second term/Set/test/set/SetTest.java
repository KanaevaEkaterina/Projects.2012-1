package set;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * tests for class Set
 * 
 * @author Kanaeva Ekaterina
 */
public class SetTest {
    
    public SetTest() {
    }

    /**
     * creates new sets, before each test
     */
    @Before
    public void setUp() {
        set = new Set<>();
        set2 = new Set<>();
    }
    
    /**
     * Test of add method, of class Set.
     */
    @Test
    public void testAdd() {
        set.add(2);
        set.add(3);
        set.add(2);
    }

    /**
     * Test of delete method, of class Set.
     */
    @Test
    public void testDelete() throws ElementNotFound {
        set.add(2);
        set.delete(2);
    }
    
    /**
     * Test of delete method, of class Set
     * throws exception ElementNotFound, when you want to delete element, that isn't in set
     */
    @Test(expected = ElementNotFound.class)
    public void testDeleteFromEmptySet() throws ElementNotFound {
        set.delete(2);
    }
    
    public void testDeleteNotFounfElement() throws ElementNotFound {
        set.add(3);
        set.delete(2);
    }
    

    /**
     * Test of isEmpty method, of class Set.
     */
    @Test
    public void testIsEmpty() throws ElementNotFound{
        assertEquals(true, set.isEmpty());
        set.add(2);
        assertEquals(false, set.isEmpty());
        set.delete(2);
        assertEquals(true, set.isEmpty());
    }

    /**
     * Test of intersectionOfSets method, of class Set.
     */
    @Test
    public void testIntersectionOfSets() {
        set2.add(1);
        set2.add(3);
        set2.add(2);
        set.add(3);
        Set<Integer> resultSet = new Set<>();
        resultSet.add(3);
        assertEquals(true, resultSet.equalSets(set.intersectionOfSets(set2)));
    }
    
    /**
     * Test of equalSets method, of class Set.
     */
    @Test
    public void testEqualSets(){
        set.add(1);
        set2.add(2);
        set.add(2);
        set2.add(1);
        assertEquals(true, set.equalSets(set2));
        set2.add(3);
        assertEquals(false, set.equalSets(set2));
    }

    /**
     * Test of unionOfSets method, of class Set.
     */
   @Test
    public void testUnionOfSets() {
        set2.add(1);
        set2.add(3);
        set2.add(2);
        set.add(2);
        set.add(5);
        Set<Integer> resultSet = new Set<>();
        resultSet.add(1);
        resultSet.add(3);
        resultSet.add(2);
        resultSet.add(5);
        assertTrue(resultSet.equalSets(set.unionOfSets(set2)));
    }

    /**
     * Test of isInSet method, of class Set.
     */
    @Test
    public void testIsInSet() {
        assertFalse(set.isInSet(3));
        set.add(2);
        assertFalse(set.isInSet(3));
        assertTrue(set.isInSet(2));
        set.add(3);
        assertTrue(set.isInSet(3));
        assertTrue(set.isInSet(2));
        assertFalse(set.isInSet(5));
}
    
    /**
     * Sets for tests
     */
    private Set<Integer> set;
    private Set<Integer> set2;

}
