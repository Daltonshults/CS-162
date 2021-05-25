

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CalcEngineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalcEngineTest
{
    private CalcEngine calcEngi1;

    /**
     * Default constructor for test class CalcEngineTest
     */
    public CalcEngineTest()
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
        calcEngi1 = new CalcEngine();
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
    public void testAll() {
        testPlus();
        testMinus();
    }

    @Test
    public void testPlus()
    {
        calcEngi1.numberPressed(5);
        calcEngi1.plus();
        calcEngi1.numberPressed(5);
        calcEngi1.equals();
        assertEquals(10, calcEngi1.getDisplayValue());
    }



    @Test
    public void testMinus()
    {
        calcEngi1.numberPressed(10);
        calcEngi1.minus();
        calcEngi1.numberPressed(5);
        calcEngi1.equals();
        assertEquals(5, calcEngi1.getDisplayValue());
    }
}




