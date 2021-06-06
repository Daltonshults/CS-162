import java.awt.Color;

/**
 * Write a description of class TextView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextView implements SimulatorView
{
    private FieldStats stats;

    /**
     * Constructor for objects of class TextView
     */
    public TextView()
    {

    }

    public void setColor(Class<?> animalClass, Color color){}
    
    public boolean isViable(Field field){return true;}
    
    public void showStatus(int step, Field field) {}
    
    public void reset(){}
}
