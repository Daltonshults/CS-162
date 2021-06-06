import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Write a description of class PopulationGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PopGen
{
    // instance variables - replace the example below with your own
    private  final double FOX_CREATION_PROBABILITY = 0.02;
    private  final double RABBIT_CREATION_PROBABILITY = 0.08;
    private final double SQUIRREL_CREATION_PROBABILITY = 0.09;
    private final double HUNTER_CREATION_PROBABILITY = .08;
    
    
    private ArrayList<Actor> animals;

    /**
     * Constructor for objects of class PopulationGenerator
     */
    public PopGen()
    {
        animals = new ArrayList<>();
    }

    /**
     * Randomly populate the field with foxes and rabbits.
     */
    public void populate(Field field)
    {
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    animals.add(fox);
                }else if(rand.nextDouble() <= SQUIRREL_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Squirrel squirrel = new Squirrel(true, field, location);
                    animals.add(squirrel);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    animals.add(rabbit);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Hunter hunter = new Hunter(field, location);
                    animals.add(hunter);
                }
                // else leave the location empty.
            }
        }
    }
    
    public void stepPop() {
        // Provide space for newborn animals.
        List<Actor> newAnimals = new ArrayList<>();
        
        // Let all rabbits act.
        for(Iterator<Actor> it = animals.iterator(); it.hasNext(); ) {
            Actor animal = it.next();
            animal.act(newAnimals);
            
            if(! animal.isActive()) {
                it.remove();
            }
        }
               
        // Add the newly born foxes and rabbits to the main lists.
        animals.addAll(newAnimals);  
    }
    
    public void clear() {
        animals.clear();    
    }
}
