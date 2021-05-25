

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
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
    public void authorTest()
    {
        Comment comment1 = new Comment("Bill", "Should be Bill", 5);
        assertEquals("Bill", comment1.getAuthor());
    }

    @Test
    public void upvoteTest()
    {
        Comment comment1 = new Comment("Bill", "Bike", 100);
        comment1.upvote();
        comment1.upvote();
        assertEquals(2, comment1.getVoteCount());
    }

    @Test
    public void downvoteTest()
    {
        Comment comment1 = new Comment("Bill", "Bike", 5);
        comment1.downvote();
        comment1.downvote();
        assertEquals(-2, comment1.getVoteCount());
    }

    @Test
    public void ratingTest()
    {
        Comment comment1 = new Comment("Bill", "Bike", 5);
        assertEquals(5, comment1.getRating());
    }

    @Test
    public void detailsTest()
    {
        Comment comment1 = new Comment("Bill", "Bike", 5);
        assertEquals("Bike", comment1.shortDescription());
    }

    @Test
    public void getRating()
    {
        Comment comment1 = new Comment("Comment", "Rude", 5);
        assertEquals(5, comment1.getRating());
    }
}







