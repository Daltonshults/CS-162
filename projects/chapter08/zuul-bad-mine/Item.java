import java.util.Random;

/**
 * Write a description of class Item here.
 *
 * @author Dalton
 * @version .01
 */
public class Item
{
    // weight of the item
    private int weight;
    // description of the item. 
    private String description;
    //random object
    private Random rand;

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        rand = new Random();
        description = randDescription();
        weight = generateWeight();
    }
 
    /**
     * Generates a random description for the item in the room.
     * @return description of the item
     */
    private String randDescription() {
        String[] desc = new String[5]; 
        desc[0] = "Sword";
        desc[1] = "Medkit";
        desc[2] = "Purple Potion";
        desc[3] = "Poison";
        desc[4] = "Armor";
        
        return desc[rand.nextInt(5)];
    }
    
    /**
     * Generates a random weight for an item from 1-10.
     */
    private int randWeight() {
        return rand.nextInt(10) + 1;    
    }
    
    private int generateWeight() {
        int ranWeight = 2; 
        
        if (description.equals("Sword")) {
            ranWeight = rand.nextInt(6) + 5;                
        } else if (description.equals("Armor")) {
            ranWeight = rand.nextInt(5) + 1;    
        }
        
        return ranWeight;
    }
    
    public String getDescrition() {
        return "Item: " + description + " : " + "Weight: " + weight + ".\n";    
    }
}
