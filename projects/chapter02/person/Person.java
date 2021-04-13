
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private int age;

     /**
     * Constructor for objects of class Person
     */
    public Person(String myName, int myAge)
    {
        age = myAge;
        name = myName;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }
    
    public int setAge(int setAge)
    {
        age = setAge;
        return age;
    }
    
    public void printDetails()
    {
        System.out.println("The name of the person is " + name);
    }
}
