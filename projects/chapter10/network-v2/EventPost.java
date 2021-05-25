
/**
 * Write a description of class EventPost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EventPost extends Post
{
    // instance variables - replace the example below with your own
    private String eventType;

    /**
     * Constructor for objects of class EventPost
     */
    public EventPost(String author, String eventType)
    {
        super(author);
        this.eventType = eventType;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println();
        System.out.println("Event Type: " + eventType);
    }
}
