package uniquelist;

import org.junit.*;
import static org.junit.Assert.*;


public class UniqueListTest {
    
    public UniqueListTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSearchForUniqueness() {
        UniqueList instance = new UniqueList();
        assertEquals(true, instance.searchForUniqueness(2));
    }

    @Test
    public void testAddToBegin() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToBegin(1);
        instance.addToBegin(2);
        assertEquals(2, instance.head.value);
    }

    @Test
    public void testAddToEnd() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.addToEnd(2);
        assertEquals(2, instance.tail.value);
    }

    @Test
    public void testDeleteElement() throws ElementNotFound, RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.addToEnd(2);
        instance.deleteElement(1);
        assertEquals(2, instance.head.value);
    }

    @Test
    public void testAdd() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.add(2);
        instance.add(1);
        instance.add(3);
        assertEquals(1, instance.head.value);
    }

    @Test
    public void testAddToPlace() throws RepeatingElement{
        UniqueList instance = new UniqueList();
        instance.addToPlace(2, 1);
        assertEquals(2, instance.head.value);
    }
    
    @Test(expected = RepeatingElement.class)
    public void testAddRepeatingElementToBegin() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToBegin(2);
        instance.addToBegin(2);
     }
     
     public void testAddRepeatingElementToEnd() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.addToEnd(1);
    }
     
      public void testAddRepeatingElement() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.add(1);
        instance.add(1);
    }

    public void testAddRepeatingElementToPlace() throws RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToPlace(2, 3);
        instance.addToPlace(2, 4);
        instance.addToPlace(2, 4);
    }
    
     @Test(expected = ElementNotFound.class)
     public void testDeleteNotFoundElement() throws ElementNotFound, RepeatingElement {
        UniqueList instance = new UniqueList();
        instance.addToEnd(1);
        instance.deleteElement(2);
    }
}
