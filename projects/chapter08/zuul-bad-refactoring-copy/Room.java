import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> itemList;
    private Random rand;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        rand = new Random();
        this.description = description;
        exits = new HashMap<>();
        itemList = new ArrayList<>(addItems());
        // int x = rand.nextInt(2) + 1;
        
        // for (int i = 0; i < x; i += 1) {
             // addItem();    
        // }

    }
    
    private ArrayList<Item> addItems() {
        int x = rand.nextInt(2) + 1;
        ArrayList<Item> dupeSet = new ArrayList();
        
        for (int i = 0; i < x; i += 1) {
            Item item = new Item();
            dupeSet.add(item);
        }
        //removeDupes(dupeSet);
        
        return dupeSet;
    }
    
    private void removeDupes(ArrayList<Item> dupeSet) {
        ArrayList<Item> removeSet = new ArrayList<>(dupeSet);
        
        for (Item i: removeSet) {
            
            for (Item x : removeSet) {
                
                if (i.getName().equals(x.getName())) {
                    dupeSet.remove(x);
                }
            }
        }
    }

    
    /**
     * creates an item for the room
     */
    private void addItem() {
        Item newItem = new Item();
        itemList.add(newItem);
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String roomItems = "";
        
        for (Item items : itemList) {
            roomItems += items.getDescription();        
        }
        
        return "You are " + description + ".\n" + getExitString() + ".\n" +
                roomItems;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }


    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * retrieves the items within the room
     * @return an ArrayList of Item that is all the items contained within the room
     */
    public ArrayList<Item> getItems() {
        return itemList;    
    }
    
    /**
     * adds a dropped item to the item list
     */
    public void addDroppedItem(Item addItem) {
        itemList.add(addItem);
    }
    
    /**
     * removes an item that was picked up from the itemList
     */
    public void removeItem(Item removeItem) {
        itemList.remove(removeItem);    
    }
}

