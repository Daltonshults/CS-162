import java.util.Random;

/**
 * Write a description of class Beamer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Beamer extends Item  

{
    // instance variables - replace the example below with your own
    private Room beamer;
    // // weight of the item
    // private int weight;
    // // name of the item. 
    // private String name;
    // //random object
    // private Random rand;
    // //description of the item
    // private String description;

    /**
     * Constructor for objects of class Beamer
     */
    public Beamer() {
        super("Beamer");
        beamer = null;
        //Random ran = new Random(); // created in Item
        weight = generateWeight();
        description = "You have found the beamer";
        //name = "Beamer";
    }
    
    public Room getBeamer() {
     return beamer;    
    }
    
    public void setBeamer(Room enterRoom) {
        beamer = enterRoom;
    }
}
