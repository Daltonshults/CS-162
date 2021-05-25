import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * Write a description of class PersonList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonList
{
    /**
     * Constructor for objects of class PersonList
     */
    public PersonList()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public void sampleMethod()
    {
        Person2[] pl = new Person2[5];
        pl[0] = new Person2(35, "Bob");
        pl[1] = new Person2(28, "Ashlie");
        pl[2] = new Person2(65, "Peter");
        pl[3] = new Person2(96, "Caleb");
        pl[4] = new Person2(65, "Cale");        
        
        for(Person2 p: pl) {
            System.out.println("Before sort: " + p.getName());    
        }
        System.out.println("End \n");
        //var x = new NameComparator();
        Arrays.sort(pl, Person2.nameComparator);
        
        for(Person2 p: pl) {
            System.out.println("After sort: " + p.getName());    
        }
    }
}
