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
    // name of the item. 
    private String name;
    //random object
    private Random rand;
    //description of the item
    private String description;

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        rand = new Random();
        name = randName();
        weight = generateWeight();
        description = genDescription();
    }
 
    /**
     * Generates a random description for the item in the room.
     * @return description of the item
     */
    private String randName() {
        String[] desc = new String[5]; 
        desc[0] = "Sword";
        desc[1] = "Medkit";
        desc[2] = "Purple Potion";
        desc[3] = "Poison";
        desc[4] = "Armor";
        
        int x = rand.nextInt(99);
        
        if (x < 9) {
            return desc[2];    
        } else if (x < 19) {
            return desc[3];
        } else if (x < 59) {
            return desc[4];    
        } else if (x < 89) {
            return desc[1];    
        } else {
            return desc[0];    
        }

    }
    
    private String genDescription() {
        if (name.equals("Sword")) {
            return "A shiny sword!";    
        } else if (name.equals("Medkit")) {
            return "A medkit for healing";    
        } else if (name.equals("Purple Potion")) {
            return "A potion that increases damage";    
        } else if (name.equals("Poison")) {
            return "A poison that slowly damages your enemies";    
        }else {
            return "Armor that increases your base health";    
        }
    }
    
    /**
     * Generates a random weight for an item from 1-10.
     */
    private int randWeight() {
        return rand.nextInt(10) + 1;    
    }
    
    private int generateWeight() {
        int ranWeight = 2; 
        
        if (name.equals("Sword")) {
            ranWeight = rand.nextInt(6) + 5;                
        } else if (name.equals("Armor")) {
            ranWeight = rand.nextInt(5) + 1;    
        }
        
        return ranWeight;
    }
    
    public String getDescrition() {
        return "Item: " + name + " Weight: " + weight +  " Description: " + description + ".\n";    
    }
}
