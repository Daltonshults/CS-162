import java.util.List;
import java.util.Iterator;

/**
 * Write a description of class Hunter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hunter implements Actor
{
    // instance variables - replace the example below with your own
    private boolean active;
    
    private Field field;
    
    private Location location;

    /**
     * Constructor for objects of class Hunter
     */
    public Hunter(Field field, Location location)
    {
        this.field = field;
        this.location = location;
        active = true;
    }
    
    public void act(List<Actor> newActors) { 
        if(isActive()) {
            Location newLocation = findAnimals();
            
            if(newLocation == null) {
                newLocation = getField().freeAdjacentLocation(getLocation());    
            }
            
            if(newLocation != null) {
                setLocation(newLocation);    
            } 
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isActive()
    {
        return active;
    }
    
    public Location findAnimals() {
        Field field = getField();
        
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                
                if(rabbit.isActive()) { 
                    rabbit.setDead();
                    return where;
                }
            }
            
            if(animal instanceof Squirrel) {
                Squirrel squirrel = (Squirrel) animal;
                
                if(squirrel.isActive()) { 
                    squirrel.setDead();
                    return where;
                }
            }
        }
        
        return null;    
    }
    
    public Field getField() {
        return field;    
    }
    
    public Location getLocation() {
        return location;    
    }
    
    public void setLocation(Location newLocation) {
        if(location != null) {
            field.clear(location);    
        }

        location = newLocation;

        field.place(this, newLocation);
    }
}
