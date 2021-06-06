
/**
 * Write a description of class Ex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Ex
     */
    public Ex()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public static long ack(long m, long n) {
        if (m == 0) {
            return n + 1;
        }
        if(n == 0) {
            return ack(m-1, 1);
        }
        return ack(m-1, ack(m, n - 1));
    }
    
    public static long fib(int f) {
        if (f < 2) {
            return f;
        }
        return fib(f-1) + fib(f-2);
    }
}
