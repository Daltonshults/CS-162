import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 * Write a description of class timeTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimeTest
{
    private List<Integer> AList; // = new ArrayList<Integer>;
    private static final Random rand = new Random();
    private List<Integer> LList;
    /**
     * Constructor for objects of class timeTest
     */
    public TimeTest()
    {
        //Random rand = new Random();
        AList = new ArrayList<>();
        LList = new LinkedList<>();
    }
    
    public void testAdd(List list) {
        if(list instanceof ArrayList) {
            System.out.println("ARRAY LIST ADD");    
        }
        
        if(list instanceof LinkedList) {
            System.out.println("ARRAY LIST ADD");    
        }
        
        long x = System.currentTimeMillis();
        for (int i = 0; i < 100000; i ++) {
            list.add(rand.nextInt());
        }
        long y = System.currentTimeMillis();
        System.out.println("Time in milliseconds: " + (y-x));
    }
    
    public void testGet(List list) {
        
        if(list instanceof ArrayList) {
            System.out.println("ARRAY LIST GET");    
        }
        
        if(list instanceof LinkedList) {
            System.out.println("ARRAY LIST GET");    
        }
        long x = System.currentTimeMillis();
        list.get(0);
        list.get((list.size() - 1) / 2);
        list.get(list.size()-1);
        long y = System.currentTimeMillis();
        System.out.println("Time in milliseconds: " + (y-x));
    }
    
    public void testRemove(List list) {
        
        if(list instanceof ArrayList) {
            System.out.println("ARRAY LIST REMOVE");    
        }
        
        if(list instanceof LinkedList) {
            System.out.println("ARRAY LIST REMOVE");    
        }
        
        long x = System.currentTimeMillis();
        list.removeAll(list);
        long y = System.currentTimeMillis();
        
        System.out.println("Time in milliseconds: " + (y-x));
    }
    
    public List<Integer> getAList() {
        return AList;    
    }
    public List<Integer> getLList() {
        return LList;    
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String args[])
    {
        TimeTest timeTest = new TimeTest();        
        timeTest.testAdd(timeTest.getAList());
        timeTest.testAdd(timeTest.getLList());
        timeTest.testGet(timeTest.getAList());
        timeTest.testGet(timeTest.getLList());
        timeTest.testRemove(timeTest.getAList());
        timeTest.testRemove(timeTest.getLList());
    }
}
