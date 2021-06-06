import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Write a description of class sortCompare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class sortCompare
{

    private static final Random rand = new Random();
    
    /**
     * Constructor for objects of class sortCompare
     */
    public sortCompare()
    {

    }

    public static void main(String args[]) {

        intCompare[] sort = new intCompare[12];
        for (int i = 0; i < 12; i++) {
            //sort[i] = new intCompare(rand.nextInt(100));
        }
        System.out.println("Before sort: ");
        for(intCompare i: sort) {
            System.out.println(i.getID());    
        }
        System.out.println();
        Arrays.sort(sort, intCompare.idComparator);
        System.out.println("After sort: ");
        for(intCompare i: sort) {
            System.out.println(i.getID());    
        }
        
        TreeSet<intCompare> tree = new TreeSet<>(intCompare.idComparator);
        
    }

}
