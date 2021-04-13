import java.util.HashMap;
/**
 * Write a description of class Item1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item1
{
    // instance variables - replace the example below with your own
    private HashMap<String, Integer> itemMap;
    private String description;
    private int weight;

    /**
     * Constructor for objects of class Item1
     */
    public Item1()
    {
        itemMap = new HashMap<>();
        createMap();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void createMap()
    {
        itemMap.put("Sword", 10);
        
        itemMap.put("Potion", 2);
    }
    
    private void generateDesc() {
        var setOfItems = itemMap.keySet();
        
        
    }
}
