

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import org.junit.Assert;

/**
 * The test class FileExTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FileExTest
{
    /**
     * Default constructor for test class FileExTest
     */
    public FileExTest()
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
    
    public void testEverything() {
        try
        {
            FileEx.writeText("int.txt"); //Creates 10 random ints and saves them to int.txt
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        System.out.println("Before Doubling: ");
        LnkdList<Integer> list1 = FileEx.read("int.txt"); //create a LnkdList from the int.txt file created form writeText()
        var tmp2 = list1.getStart(); //getting a tmp variable to hold start
        
        do {
            System.out.println(tmp2.getData()); //printing the list before doubling
            tmp2 = tmp2.getNext();            
        } while (tmp2 != list1.getStart());
        
        System.out.println("\nAfter Doubling: ");
        LnkdList<Integer> list = FileEx.readAndDouble("int.txt");
        var tmp = list.getStart();
        do {
            System.out.println(tmp.getData()); //printing the list after doubli
            tmp = tmp.getNext();
        } while (tmp != list.getStart());
        
        System.out.println(tmp2.getData() * 2 == tmp.getData());
        int tint = tmp2.getData() * 2;
        int tint2 = tmp.getData();
        assertEquals(true, tint == tint2);
    }
}
