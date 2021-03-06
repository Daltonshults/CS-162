import java.util.List;

/**
 * Abstract class Animal - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Animal
{
    private boolean alive;
    
    private Field field;
    
    private Location location;
    
    public Animal(Field field, Location location) {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    public void act(List<Animal> newAnimals) {}
    
    protected boolean isAlive() {
        return alive;    
    }
    
    protected void setDead() {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    protected Location getLocation() {
        return location;    
    }
    
    protected void setLocation(Location newLocation) {
        if(location != null) {
            field.clear(location);    
        }
        
        location = newLocation;
        
        field.place(this, newLocation);
    }
    
    protected Field getField() {
        return field;    
    }
    
    abstract protected void giveBirth(List<Animal> newAnimals);
    
    public boolean canBreed() {
        return age >= getBreedingAge();    
    }
    
    abstract protected int getBreedingAge();
}
