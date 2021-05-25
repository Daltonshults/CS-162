

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BrickTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BrickTest
{
    private Brick brick1;

    /**
     * Default constructor for test class BrickTest
     */
    public BrickTest()
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
        brick1 = new Brick(5, 10, 2);
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
    public void testVolume()
    {
        assertEquals(100, brick1.getVolume(), 0.1);
    }

    @Test
    public void testSurfaceArea()
    {
        assertEquals(160, brick1.getSurfaceArea(), 0.1);
    }
}


