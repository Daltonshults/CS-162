import java.util.List;
import java.util.Random;

/**
 * Abstract class Animal - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Animal extends Actor
{
    private boolean alive;

    private Field field;

    private Location location;

    private int age;

    private static final Random rand = Randomizer.getRandom();

    public Animal(Field field, Location location) {
        alive = true;
        this.field = field;
        this.age = 0;
        setLocation(location);
    }
    
    
    public void act(List<Animal> newActors, int in){}

    public boolean isActive() {
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

    //abstract protected void giveBirth(List<Animal> newAnimals);

    protected boolean canBreed() {
        return age >= getBreedingAge();    
    }

    abstract protected int getBreedingAge();

    abstract protected double getBreedingProb();

    abstract protected int getMaxLitSize();

    protected int getAge() {
        return age;    
    }

    protected void setAge(int age) {
        this.age = age;    
    }

    protected void incAge() {
        age += 1;    
    }

    protected int breed() {
        int births = 0;

        if(canBreed() && rand.nextDouble() <= getBreedingProb()) {
            births = rand.nextInt(getMaxLitSize());
        }

        return births;
    }

    protected void giveBirth(List<Actor> newAnimals) {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = getNewAnimal(true, field, loc);
            newAnimals.add(young);
        }
    }

    abstract protected Animal getNewAnimal(boolean tf, Field field, Location loc);

}
