import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class RandomRooms here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomRooms
{
    // instance variables - replace the example below with your own
    private ArrayList<Room> roomList;
    private Random ran;
    /**
     * Constructor for objects of class RandomRooms
     */
    public RandomRooms()
    {
        ran = new Random();
        roomList = new ArrayList();
    }
    
    public void add(Room room) {
        roomList.add(room);    
    }
    
    public Room randomRoom() {
        int x = ran.nextInt(roomList.size());
        return roomList.get(x);
    }
}
