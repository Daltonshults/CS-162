
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LnkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LnkdListTest
{
    private LnkdList<Integer> list;

    /**
     * Default constructor for test class LnkedListTest
     */
    public LnkdListTest()
    {
        list = new LnkdList<>();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        list.addFirst(12); list.addFirst(10); list.addFirst(454);
        list.addFirst(123); list.addFirst(4878);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        list = null;
    }

    
    @Test
    public void testAddFirst() {
        assertTrue(list.size() == 5);    
    }

    @Test
    public void testAddFirstLastObject() {
        int x = list.get(list.size() - 1);
        assertTrue(x == 12);    
    }

    @Test
    public void testGetFirst() {
        assertEquals(4878, list.getFirst());
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(1);
        int x = list.get(0);
        assertTrue(x == 1);
    }


    @Test 
    public void testAddLast() {
        list.addLast(11);
        list.addLast(10);
        int x = list.get(list.size() - 1);
        assertTrue(x == 10);
    }

    
    /**
     * Tests all the edge cases for removeFirst including when start is null
     * and when the next field within start is null. 
     */
    @Test
    public void testRemoveFirstAgain()
    {
        assertEquals(4878, list.removeFirst());
        assertEquals(123, list.removeFirst());
        assertEquals(454, list.removeFirst());
        assertEquals(10, list.removeFirst());
        assertEquals(12, list.removeFirst());
        assertEquals(null, list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveLast() {
        list.addLast(132);
        list.addLast(456);
        assertEquals(456, list.removeLast());
    }

    @Test
    public void testRemoveLastAgain()
    {
        assertEquals(12, list.removeLast());
        assertEquals(10, list.removeLast());
        assertEquals(454, list.removeLast());
        assertEquals(123, list.removeLast());
        assertEquals(4878, list.removeLast());
    }

    @Test
    public void testGetLast()
    {
        assertEquals(12, list.getLast());
    }

    @Test
    public void testClear()
    {
        list.clear();
        assertEquals(0, list.size());
        assertEquals(null, list.getLast());
    }

    @Test
    public void testAddIndex()
    {
        list.add(4, 666);
        assertEquals(666, list.get(4));
    }

    @Test
    public void testAddIndexAtZero()
    {
        list.add(0, 666);
        assertEquals(666, list.get(0));
    }

    @Test
    public void testingFirstIndex()
    {
        list.add(1, 1854);
        assertEquals(1854, list.get(1));
    }

    @Test
    public void testingContains()
    {
        assertEquals(true, list.contains(454));
    }
    
    @Test
    public void negTestContains()
    {
        assertEquals(false, list.contains(0));
    }

    @Test
    public void testRemove()
    {
        assertEquals(123, list.remove(1));
        assertEquals(false, list.contains(123));
    }
}







