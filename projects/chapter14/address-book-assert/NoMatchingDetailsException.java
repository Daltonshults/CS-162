
/**
 * Write a description of class NoMatchingDetailsException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NoMatchingDetailsException extends Exception
{
    // instance variables - replace the example below with your own
    private String key;
    
    /**
     * Constructor for objects of class NoMatchingDetailsException
     */
    public NoMatchingDetailsException(String key)
    {
        // initialise instance variables
        this.key = key;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getKey()
    {
        return key;
    }
    
    @Override
    public String toString() {
        return "Details were matching: " + getKey() + " don't do that";
    }
}
