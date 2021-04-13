import java.util.Random;
/**
 * Write a description of class testClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testClass
{
    // instance variables - replace the example below with your own

    private static Random rand;

    /**
     * Constructor for objects of class testClass
     */
    public testClass()
    {
        rand = new Random();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void count()
    {
        long startMil = System.currentTimeMillis(); 
        
        for(int i = 1; i <= 10000; i++) {
            
        }
        
        long endMil = System.currentTimeMillis();
        
        System.out.println("Milliseconds: " + (endMil - startMil));
    }
    
    public static int randomInt() {
        return rand.nextInt(100);    
    }
    
    public int randomNonStatInt() {
        int x;
        x = randomInt();
        return x;
    }
    
    public static int anotherInt() {
        int x;
        x = randomNonStatInt();
        return x;
    }
}
