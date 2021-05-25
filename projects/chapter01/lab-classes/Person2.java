import java.util.Comparator;

/**
 * Write a description of class Person2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person2 implements Comparable<Person2>
{
    private int id;
    
    private String name;

    /**
     * Constructor for objects of class ex
     */
    public Person2(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public String getName() {
        return name;    
    }
    
    public int getId() {
        return id;    
    }

    @Override
    public int compareTo(Person2 other) {
        return this.id - other.id;
    }
    
    @Override
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + "]";
    }

    public static final Comparator<Person2> nameComparator = new Comparator<>() {
        
        @Override
        public int compare(Person2 p1, Person2 p2) {
           return p1.getName().compareTo(p2.getName()); 
        }
    };
        
}

