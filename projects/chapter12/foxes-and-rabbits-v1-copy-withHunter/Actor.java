import java.util.List;

/**
 * Abstract class Actor - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public interface Actor
{
    void act(List<Actor> newActors);
    boolean isActive();
}

