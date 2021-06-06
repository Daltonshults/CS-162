import java.util.*;

/**
 * Write a description of class intCompare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class intCompare implements Comparable<intCompare>
{
    private String firstName;
    private String lastName;
    private int intID;
    private static final Random rnd = new Random();
    
    /**
     * Constructor for objects of class intCompare
     */
    public intCompare(int id, String firstName, String lastName)
    {
        intID = createID();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getID() {
        return intID;    
    }
    
    public int createID() {
        return rnd.nextInt(1000000000) +  + 100000000;
    }
    
    public String getFirstName() {
        return firstName;    
    }
    
    public String getLastName() {
        return lastName;
    }
    
    @Override
    public String toString() {
        return  getLastName() + "  " + getFirstName()+ " " + getID() + " ";
    }
    
    @Override
    public int compareTo(intCompare t) {
        // int result = this.getID() - t.getID();
        
        // if (result == 0) {
            // result = this.getFirstName().compareTo(t.getFirstName());
        // }
        
        // if (result == 0) {
            // result = this.getLastName().compareTo(t.getLastName());       
        // }
        
        int result = this.getLastName().compareTo(t.getLastName());
        
        if (result == 0) {
            result = this.getFirstName().compareTo(t.getFirstName());
        }
        
        if (result == 0) {
            result = this.getID() - t.getID();      
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<intCompare> il = new ArrayList<>();
        intCompare a = new intCompare(4, "Bob", "Billy"); intCompare b = new intCompare(3, "Ashley", "Adams");
        intCompare c = new intCompare(2, "Ashley", "Bore"); intCompare d = new intCompare(1, "Zander", "Yolo");
        il.add(a); il.add(b); il.add(c); il.add(d);
        
        System.out.println("Before sort");
        
        il.stream()
            .forEach(x -> System.out.print(x + " "));
            
        System.out.println();
        
        System.out.println("\nAfter sort");
        
        Collections.sort(il);
        il.stream()
            .forEach(x -> System.out.print(x + " "));
            
        Collections.sort(il, intCompare.firstNameComparator);
        System.out.println();
        
        System.out.println("\nAfter first name sort");        
        il.stream()
            .forEach(x-> System.out.print(x + " "));
        System.out.println();
        
        System.out.println("\nAfter ID sort");
        Collections.sort(il, idComparator);
        il.stream()
            .forEach(x-> System.out.print(x + " "));
    }
    
    
    public static final Comparator<intCompare> firstNameComparator = new Comparator<>() {
        @Override
        public int compare(intCompare i1, intCompare i2) {
            return i1.getFirstName().compareTo(i2.getFirstName());
        }
    };
    
    public static final Comparator<intCompare> lastNameComparator = new Comparator<>() {
        @Override
        public int compare(intCompare i1, intCompare i2) {             
            return i1.getLastName().compareTo(i2.getLastName());    
        }
    };
    
    public static final Comparator<intCompare> idComparator = new Comparator<>() {
        @Override
        public int compare(intCompare i1, intCompare i2) {             
            return i1.getID() - i2.getID();    
        }
    };

}
