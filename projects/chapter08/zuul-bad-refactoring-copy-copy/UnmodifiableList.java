import java.util.AbstractList;
import java.util.Set;

/**
 * Write a description of class unmodifiableList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UnmodifiableList<T> extends AbstractList<T>
{
    // instance variables - replace the example below with your own
    //private int size;
    private T[] array;

    /**
     * Constructor for objects of class unmodifiableList
     */
    public UnmodifiableList(T[] array)
    {
        // initialise instance variables
        this.array = array;
        //size = array.length;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public T get(int y)
    {
        return array[y];
    }
    
    public int size() {
        return array.length;    
    }
}
