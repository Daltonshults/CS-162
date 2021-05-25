import java.util.Comparator;

public class NameComparator implements Comparator<Person2> {
        
        public int compare(Person2 p1, Person2 p2) {
           return p1.getName().compareTo(p1.getName()); 
        }
        
}
