import java.util.*;

/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person implements Comparable<Person>
{
    private String firstName;
    private String lastName;
    private int intID;
    private static final Random rnd = new Random();
    
    /**
     * Constructor for objects of class Person
     */
    public Person(String firstName, String lastName)
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
    public int compareTo(Person t) {
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
        ArrayList<Person> il = new ArrayList<>();
        Person a = new Person("Bob", "Billy"); Person b = new Person("Ashley", "Adams");
        Person c = new Person("Ashley", "Bore"); Person d = new Person("Zander", "Yolo");
        il.add(a); il.add(b); il.add(c); il.add(d);
        
        System.out.println("Before sort");
        
        il.stream()
            .forEach(x -> System.out.print(x + " "));
            
        System.out.println();
        
        System.out.println("\nAfter sort");
        
        Collections.sort(il);
        il.stream()
            .forEach(x -> System.out.print(x + " "));
            
        Collections.sort(il, Person.firstNameComparator);
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
    
    
    public static final Comparator<Person> firstNameComparator = new Comparator<>() {
        @Override
        public int compare(Person i1, Person i2) {
            return i1.getFirstName().compareTo(i2.getFirstName());
        }
    };
    
    public static final Comparator<Person> lastNameComparator = new Comparator<>() {
        @Override
        public int compare(Person i1, Person i2) {             
            return i1.getLastName().compareTo(i2.getLastName());    
        }
    };
    
    public static final Comparator<Person> idComparator = new Comparator<>() {
        @Override
        public int compare(Person i1, Person i2) {             
            return i1.getID() - i2.getID();    
        }
    };

}
