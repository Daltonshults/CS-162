import java.util.Comparator;

/**
 * Write a description of class intCompare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class intCompare implements Comparable<intCompare>
{
    private String name;
    private int intID;
    /**
     * Constructor for objects of class intCompare
     */
    public intCompare(int id, String name)
    {
        intID = id;
        this.name = name;
    }
    
    public int getID() {
        return intID;    
    }
    
    public String getName() {
        return name;    
    }
    
    @Override
    public int compareTo(intCompare t) {
        return this.intID - t.intID;
    }
    
    public static final Comparator<intCompare> idComparator = new Comparator<>() {
        @Override
        public int compare(intCompare i1, intCompare i2) {
            int result = i1.getName().compareTo(i2.getName());
            
            if(re
            //result = i1.intID - i2.intId;
            
            return result;    
        }
    };

}
