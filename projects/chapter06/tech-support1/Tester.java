import java.util.HashSet;
import java.util.ListIterator;


/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    private HashSet<String> practiceSet;
    private static int howManyInst = 0;

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        practiceSet = new HashSet<>();
        addToHash();
        increment();
    }
    
    public static void increment() {
        howManyInst = howManyInst + 1;    
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addToHash()
    {
        practiceSet.add("Bob");
        practiceSet.add("Bill");
        practiceSet.add("Song");
        practiceSet.add("Dong");
        practiceSet.add("Bing");
        practiceSet.add("Bong");
        practiceSet.add("Long");
        practiceSet.add("Pong");
        practiceSet.add("Rong");
        practiceSet.add("Tong");
    }
    
    public boolean searchHash(String search){
        boolean isItThere = false;
        var x = practiceSet.iterator();
        while(x.hasNext()) {
            if(x.next() == search) {
                System.out.println("" + search);
                isItThere = true;
            }
        }
        return isItThere;
    }
    
    public static void one() {
        int[] nums = {3,6,4,8,7,9,5,6,4,3,4,6,9,}; 
        System.out.println(max(nums));
        int[] x = new int[nums.length];        
        System.out.println(java.util.Arrays.toString(x));
    }
    
    public static int max(int[] nums) {
        nums[0] = 99;
        return 0;    
    }
}
