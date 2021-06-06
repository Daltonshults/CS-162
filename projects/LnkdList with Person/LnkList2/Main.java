
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
    public static void main(String[] args)
    {
        LnkdList<Person> pl = new LnkdList<>();
        
        Person amy = new Person("Amy", "M");
        Person mary = new Person("Mary", "M");
        Person maryb = new Person("Mary", "B");
        Person dan = new Person("Dan", "M");
        Person donadd = new Person("Don", "add");
        
        pl.add(amy);
        pl.add(mary);
        pl.add(maryb);
        pl.add(dan);
        
        boolean willContain = pl.contains(mary);
        
        boolean wontContain = pl.contains(donadd);
        
        System.out.println("willContain should be true: " + willContain);
        
        System.out.println("\nwontContain should be false: " + wontContain);
    }

}
