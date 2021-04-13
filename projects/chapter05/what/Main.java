import java.util.ArrayList;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {

    }


    public void tester() {
        Location f1 = new Location();
        Location f2 = new Location(3 , -9);
        f1.setA(8);
        f1.setB(8);
        int sum = f2.getA() + f2.getB();    
        var survey = new ArrayList<Location>();
        System.out.println("f2 has an 'a' value of: " + f2.getA() +
                           " f2 has an 'b' value of: " + f2.getB());
    }
}
