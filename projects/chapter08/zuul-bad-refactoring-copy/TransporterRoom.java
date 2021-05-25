import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class TransporterRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TransporterRoom extends Room
{
    // instance variables - replace the example below with your own
    private int x;
    private Random ran;
    private RandomRooms rndRooms;
    

    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(String description, RandomRooms rndRooms)
    {
        super(description);
        this.rndRooms = rndRooms;
        ran = new Random();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Room getExit(String direction)
    {
        return rndRooms.randomRoom();
    }
    
    private Room findRandomRoom() {
        return null;       
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        super.setExit(direction, neighbor);
    }
}
