import java.util.Iterator;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Write a description of class ex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ex
{
    // instance variables - replace the example below with your own
    //private Iterator it;
    private ArrayList<Integer> al;
    

    /**
     * Constructor for objects of class ex
     */
    public ex()
    {
         al = new ArrayList<>();   
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        ex ex = new ex();
        ex.al.add(1); ex.al.add(2); ex.al.add(3); ex.al.add(4); ex.al.add(5); ex.al.add(6); ex.al.add(7);
        
        for (Integer i: ex.al) {
            System.out.println(i);
        }
        Iterator<Integer> intI = ex.al.iterator();
        
        
        
        while (intI.hasNext()) {
            var i = intI.next();
            //System.out.println(i);
            if(i == 1 || i == 4) {
                intI.remove();
            }
        }
        System.out.println("After removal");
        
        for (Integer i: ex.al) {
            System.out.println(i);
        }
        
        //System.out.println("After removal");
    }
}
