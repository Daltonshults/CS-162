import java.math.BigInteger; //imports BigInteger

public class Location
{
    private int a; //initializing a and b
    private int b;

    /**
     * Constructor sets the value of a and b to 0.
     */
    public Location()
    {
        a = 0;
        b = 0;
    }
    
    /**
     * Constructor sets the value of a and b to the paramters given.
     * @param a type int
     * @param b type int
     */
    public Location(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    
    
    /**
     * Sets the value of a
     * @param int type setting value of a
     */
    public void setA(int a) {
        this.a = a;    
    }
    
    /**
     * Sets the value of b
     * @param int type setting value of b
     */
    public void setB(int b) {
        this.b = b;    
    }
    
    /**
     * Returns the value of a
     */
    public int getA() {
        return a;     
    }
    
    /**
     * Returns the value of b
     */
    public int getB() {
        return b;     
    }
    
    /**
     * Returns a string value for a and b.
     */    
    public String toString(){
        String str = "Value of a is: " + a + " Value of b is: " + b;
        return str;
    }
    
    
    /**
     * prints the value returned by the toString method.
     */
    public void printToString() {
        String str = toString();
        System.out.println(str);    
    }
}
