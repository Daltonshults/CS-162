import java.util.List;
import java.util.Random;

/**
 * A simple model of a SQUIRREL.
 * squirrels age, move, breed, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public class Squirrel extends Animal
{
    // Characteristics shared by all squirrels (class variables).

    // The age at which a squirrel can start to breed.
    private static final int BREEDING_AGE = 14;
    // The age to which a squirrel can live.
    private static final int MAX_AGE = 47;
    // The likelihood of a squirrel breeding.
    private static final double BREEDING_PROBABILITY = .145;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    // Individual characteristics (instance fields).
    
    // The squirrel's age.
    //private int age;

    /**
     * Create a new squirrel. A squirrel may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the squirrel will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Squirrel(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        super.setAge(0);
        if(randomAge) {
            super.setAge(rand.nextInt(MAX_AGE));
        }
    }
    
    /**
     * This is what the squirrel does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newsquirrels A list to return newly born squirrels.
     */
    public void act(List<Actor> newsquirrels)
    {
        super.incAge(); //incrementAge();
        
        if(isActive()) {
            super.giveBirth(newsquirrels);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }
    
    protected double getBreedingProb() {
        return BREEDING_PROBABILITY;    
    }
    
    protected int getMaxLitSize() {
        return MAX_LITTER_SIZE;    
    }
    
    protected Animal getNewAnimal(boolean tf, Field field, Location loc) {
        return new Squirrel(tf, field, loc);    
    }
}
