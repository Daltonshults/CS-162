
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Room currentRoom;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {

    }
    
    /**
     * Prints the current location information. Where you are in the game. 
     */
    public void printLocationInfo() {
        System.out.println("You are " + currentRoom.getLongDescription());
        //System.out.println(currentRoom.getExitString());
    }


}
