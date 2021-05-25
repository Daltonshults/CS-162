import java.util.Comparator;
 
public class Employee implements Comparable<Employee> {
 
    private int id;
    private String name;
    private int age;
    private long salary;
 
    public int getId() {  
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
 
    public long getSalary() {
        return salary;
    }
 
    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
   
    /*
     * The Employee class implements Comparable therefore it must implement
     *   the compareTo() method. This becomes the default method for
     *   comparing two Employee objects.
     */
    @Override
    public int compareTo(Employee other) {
        // sort the Employee based on an id in ascending order
        // returns a negative integer, zero, or positive integer as this Employee id
        // is less than, equal to, or greater than the 'other' object.
        // return this.name.compareTo(other.name);
        return (this.id - other.id);
    }
   
    /*
     * Static Comparator objects for comparing Person objects on different
     *   fields. These are public static fields available via the Employee
     *   class name.
     *   EX: 'Employee.salaryComparator' is a Comparator object
     */
   
    /**
     * Comparator to sort employees list or array in order of Salary
     * Anonymous class alert
     */


    public static final Comparator<Employee> salaryComparator = new Comparator<>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };
 
    /**
     * Comparator to sort employees list or array in order of Age
     * Anonymous class alert
     */
    public static final Comparator<Employee> ageComparator = new Comparator<>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getAge() - e2.getAge();
        }
    };
 
    /**
     * Comparator to sort employees list or array in order of Name
     * Anonymous class alert
     */

    private static class NameComparator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    }

    public static final Comparator<Employee> getNameCompare() {
        return new NameComparator();
    }

    public static final Comparator<Employee> nameComparator = new Comparator<>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
 
    @Override  
    //this is overridden to print the user-friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }
}