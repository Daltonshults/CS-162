import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class SortingTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortingTest
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> myList;

    /**
     * Constructor for objects of class SortingTest
     */
    public SortingTest()
    {
        // initialise instance variables
        myList = new ArrayList<Integer>();
        addToList();
    }
    
    private void addToList() {
        myList.add(10);
        myList.add(17);
        myList.add(80);
        myList.add(560);
        myList.add(101);
        myList.add(103);
        myList.add(104);
        myList.add(145);
        myList.add(10);
        myList.add(310);
        myList.add(910);
        myList.add(810);
        myList.add(1110);
        myList.add(2010);
    }
    
    
    /**
     * Prints the list in order from least to greatest
     * @param list of type ArrayList<Integer> 
     */
    public void printOrderedList(ArrayList<Integer> list) {
       Collections.sort(list);
       System.out.println(list);    
    }
    
    /**
     * An emyListample of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of myList and y
     */
    public int sampleMethod(int y)
    {
        return 0;
    }    
}

