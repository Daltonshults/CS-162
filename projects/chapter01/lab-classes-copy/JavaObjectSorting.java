import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
 
public class JavaObjectSorting {
    /**
     * This class shows how to sort primitive arrays,
     *    Wrapper classes and Object Arrays
     * https://www.journaldev.com/780/comparable-and-comparator-in-java-example
     */
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
    }
   
    public static void exampleOne() {
        //sort primitives array like int array
        int[] intArr = {5,9,1,10};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
       
        //sorting String array
        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
       
        //sorting list of objects of Wrapper classes
        List<String> strList = new ArrayList<String>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList);
        System.out.println(strList);
        System.out.println();
    }
   
    public static void exampleTwo() {
        //sorting object array
        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);
       
        //sorting employees array using Comparable interface implementation
        Arrays.sort(empArr);
        System.out.println("Default Sorting of Employees list:\n"
                            + Arrays.toString(empArr));
        System.out.println();
    }
   
    public static void exampleThree() {
        //sorting object array
        Employee[] empArr = new Employee[6];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Erun", 32, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Aankaj", 32, 50000);
        empArr[4] = new Employee(2, "Beth", 32, 60000);
        empArr[5] = new Employee(3, "Terri", 42, 60000);
       
        //sort employees array using a Comparator by Salary
        Arrays.sort(empArr, Employee.salaryComparator);
        System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));
       
        //sort employees array using a Comparator by Age
        Arrays.sort(empArr, Employee.ageComparator);
        System.out.println("Employees list sorted by Age:\n"+Arrays.toString(empArr));
       
        //sort employees array using a Comparator by Name
        Arrays.sort(empArr, Employee.nameComparator);
        System.out.println("Employees list sorted by Name:\n"+Arrays.toString(empArr));
 
        // Sort employees array using a Comparator by Age then Name
        // Comparator<Employee> ageNameSort = new AgeNameCompare();
        // Arrays.sort(empArr, ageNameSort);
        //Arrays.sort(empArr, new AgeNameCompare());
        //System.out.println("Employees list sorted by Age then Name:\n"
        //              + Arrays.toString(empArr));
        System.out.println("Employees list sorted by Age then Name:");
        for (Employee e : empArr) {
           System.out.println("\t" + e);
        }
        System.out.println();
    }
}