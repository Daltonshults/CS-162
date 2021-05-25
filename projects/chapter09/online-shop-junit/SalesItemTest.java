import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    private SalesItem salesIte1;
    private SalesItem salesIte2;

    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        salesIte1 = new SalesItem("Bill", 100);
        salesIte2 = new SalesItem("bob", 100);
        salesIte1.addComment("Bill", "Bob", 1);
        salesIte1.addComment("Bob", "Bill", 2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }

    @Test
    public void addComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
        assertEquals(true, salesIte1.addComment("Fred", "Great - I perform brain surgery every week now!", 4));
    }

    @Test
    public void testTwoComments()
    {
        SalesItem salesIte1 = new SalesItem("Bike", 120);
        assertEquals(true, salesIte1.addComment("Bill", "Great bike!", 5));
        assertEquals(true, salesIte1.addComment("Charlie", "Amazing bike!", 4));
        assertEquals(2, salesIte1.getNumberOfComments());
    }

    @Test
    public void sameAuthor()
    {
        SalesItem salesIte1 = new SalesItem("Bike", 100);
        assertEquals(true, salesIte1.addComment("Bill", "Great bike!", 5));
        assertEquals(false, salesIte1.addComment("Bill", "Great bike!", 5));
    }

    @Test
    public void outsideRatingRange()
    {
        SalesItem salesIte1 = new SalesItem("Bike", 100);
        assertEquals(false, salesIte1.addComment("Bill", "Bike", 6));
        assertEquals(false, salesIte1.addComment("Bike", "Book", 0));
    }
    
    @Test
    public void bestComment() {
        SalesItem salesIte1 = new SalesItem("Bike", 100);
        assertEquals(true, salesIte1.addComment("Bill", "Great bike!", 5));
        assertEquals(true, salesIte1.addComment("Katie", "Great bike!", 5));
        assertEquals(true, salesIte1.addComment("Mike", "Great bike!", 5));
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(1);
        assertEquals(salesIte1.getComments().get(1), salesIte1.findMostHelpfulComment());
    }

    @Test
    public void getCommentByAuthor()
    {
        Comment comment1 = salesIte1.findCommentByAuthor("Bill");
        assertEquals(comment1, salesIte1.getComments().get(0));
    }

    @Test
    public void ratingInvalid()
    {
        assertEquals(false, salesIte1.addComment("Book", "Bill", -2));
        assertEquals(false, salesIte1.addComment("Braks", "Poo", 1510));
    }

    @Test
    public void removeComment()
    {
        salesIte1.removeComment(0);
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    @Test
    public void removeEmptyComment()
    {
        salesIte2.removeComment(0);
        assertEquals(0, salesIte2.getNumberOfComments());
    }
}












