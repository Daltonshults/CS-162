import java.util.ArrayList;
/**
 * Player within the game holds objects and player location.
 *
 * @Dalton
 * @version .01
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Room currentRoom;
    
    private ArrayList<Item> bag;
    
    private int weight;
    
    private int maxWeight;
    
    private int energy;
    
    private Room beamer;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        bag = new ArrayList<>();
        weight = 0;
        maxWeight = 10;
        energy = 30; //set one higher than the desired ammount of moves. 
    }
    
    /**
     * Prints the current location information. Where you are in the game. 
     */
    public void printLocationInfo() {
        System.out.println("You are " + currentRoom.getLongDescription());        
    }

    /**
     * Changes the room the player is in
     */
    public void changeRoom(Room roomName) {
        energy -= 1;
        currentRoom = roomName;    
    }
    
    /**
     * Returns the current room that the player is in
     * @return the room that the player is currently in
     */
    public Room currentRoom() {
        return currentRoom;    
    }
    
    /**
     * Adds items to the bag ArrayList if the weight is not too much
     */
    public void addToBag(Item bagItem) {

        if (maxWeight > weight + bagItem.getWeight()) {
            bag.add(bagItem);
            currentRoom.removeItem(bagItem);
            weight += bagItem.getWeight();
        } else {
            System.out.println("That item is too heavy you cannot pick it up!");    
        }
        
    }
    
    /**
     * returns the bag ArrayList
     * @return the bag ArrayList
     */
    public ArrayList<Item> getBag() {
        return bag;   
    }
    
    /**
     * removes an item from the bag inventory
     */
    public void removeFromBag(Item bagItem) {
        bag.remove(bagItem);
        currentRoom.addDroppedItem(bagItem);
        weight -= bagItem.getWeight();
    }
    
    /**
     * increases max weight
     */
    public void addMaxWeight() {
        maxWeight += 10;    
    }
    
    public int getWeight() {
        return weight;    
    }
    
    public int getMaxWeight() {
        return maxWeight;   
    }
    
    public int getEnergy() {
        return energy;     
    }
    
    public String playerGetDescription() {
        return "Weight: " + weight + "\n" + "Energy Remaining: " + energy;   
    }
    
    public Room getBeamer() {
     return beamer;    
    }
    
    public void setBeamer() {
        beamer = currentRoom;    
    }
    
    public void fireBeamer() {
        currentRoom = beamer;    
    }
}
