

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class NodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NodeTest
{
    private Node<Integer> node1;
    private Node<Integer> node2;
    private Node<Integer> node3;

    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        node1 = new Node<Integer>(1);
        node2 = new Node<Integer>(2);
        node3 = new Node<Integer>(3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void setNextTest()
    {
        node2.setNext(node3);
        assertEquals(3, node2.getNext().getData());
    }
    
    @Test
    public void setPrevTest()
    {
        node2.setPrev(node3);
        assertEquals(3, node2.getPrev().getData());
    }
    
    @Test
    public void setDataTest()
    {
        node2.setData(100);
        assertEquals(100, node2.getData());
    }
    
    @Test
    public void hasNextTest()
    {
        node2.setNext(node3);
        assertEquals(true, node2.hasNext());
    }
}

