import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (imperative)
 */
public class AnimalMonitor 
{
    // Records of all the sightings of animals.
    private ArrayList<Sighting> sightings; // sets up the ArrayList object as a feild 

    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>(); //assigns sightings to a new ArrayList
        addTestSightings();
    }

    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    public void addSightings(String filename)
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings(filename));
    }
    
    public void addTestSightings()
    {
        addSightings("sightings.csv");    
    }

    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        sightings.forEach(record -> System.out.println(record.getDetails()));      
    }

    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        sightings.stream()
            .filter(s -> animal.equals(s.getAnimal()))
            .forEach(s -> System.out.println(s.getDetails()));
    }

    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter)
    {
        sightings.stream()
            .filter(sighting -> sighting.getSpotter() == spotter)
            .map(sighting -> sighting.getDetails())
            .forEach(System.out::println);
    }
    
    /**
     * Returns the number of the sights of a certain animal.
     * @param the name of the animal.
     */
    public int provideNumberOfAnimal(String animal)
    {
        return sightings.stream()
            .filter(sighting -> sighting.getAnimal().equals(animal))
            .map(sighting -> sighting.getCount())
            .reduce(0, (total, count) -> total + count);
    }
    
    /**
     * Print all the sightings of a certian animal.
     * @param the name of the animal.
     */
    public void printSightingsOfAnimal(String animal) {
        System.out.println(provideNumberOfAnimal(animal));
    }

    /**
     * Print a list of the types of animal considered to be endangered.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(int dangerThreshold)
    {
        sightings.stream()
            .filter(sighting -> sighting.getCount() < dangerThreshold)
            .map(sighting -> sighting.getDetails())
            .forEach(details -> System.out.println(details));
    }

    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        return sightings.stream()
            .filter(sighting -> animal.equals(sighting.getAnimal()))
            .map(sighting -> sighting.getCount())
            .reduce(0, (total, count) -> total + count);
    }
    
    /**
     * Returns the largest count of a certain animal
     * @param animalName the animal you are searching for
     * @return the number of sightings of the animal you are searching for
     */
    public long recordsBy(int spotterID) {
        return sightings.stream()
            .filter(s -> s.getSpotter() == spotterID)
            .map(s -> s.getCount())
            .count();   
    }
    
    /**
     * Returns the largest count of a certain animal
     * @param animalName the animal you are searching for
     * @return the number of sightings of the animal you are searching for
     */
    public int largestCount(String animalName) {
        return sightings.stream()
            .filter(s -> s.getAnimal().equals(animalName))
            .mapToInt(s -> s.getCount())
            .max().getAsInt();
    }
    
    /**
     * 
     */
    public int largestCount2(String animalName) {
        return sightings.stream()
            .filter(s -> s.getAnimal().equals(animalName))
            .map(s -> s.getCount())
            .max(Integer::compare).get();
    }
    
    
    /**
     * Returns the first method matching the animalName and spotterId
     * @param animalName the name of the animal
     * @param spotterId the id of the spotter we are searching for
     * return Sighting the first sighting object that matching what was searched for
     */
    public Sighting nameIdSighting(String animalName, int spotterId) {
        return sightings.stream()
            .filter(s -> s.getAnimal().equals(animalName))
            .filter(s -> s.getSpotter() == spotterId)
            .findFirst().get();            
    }
    
    
    /**
     * Prints the sightings after the given index
     */
    public void printSightingsAfter(long index) {
        sightings.stream()
            .skip(index)
            .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Prints the sightings after the given index
     */
    public void printSightingsBefore(long index) {
        sightings.stream()
            .limit(index)
            .forEach(s -> System.out.println(s.getDetails()));
    }
    
    
    
    /**
     * 
     */
    public int smallestCount(String animalName) {
        return sightings.stream()
            .filter(s -> s.getAnimal().equals(animalName))
            .mapToInt(s -> s.getCount())
            .min().getAsInt();
    }
    
    /**
     * Remove the all 0 counts from the sightings list.
     */
    public void removeIf(){
        sightings.removeIf(sighting -> sighting.getCount() == 0);        
    }
    
    /**
     * Remove all the sights from a certain spotter
     * @param spotter the spotter you would like to remove from the list
     */
    public void removeSpotter(int spotterID) {
        sightings.removeIf(sighting -> sighting.getSpotter() == spotterID);    
    }
    
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        Iterator<Sighting> it = sightings.iterator();
        while(it.hasNext()) { //iterates over an iterator
            Sighting record = it.next();
            if(record.getCount() == 0) {
                it.remove();
            }
        }
    }


    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    public ArrayList<Sighting> getSightingsInArea(String animal, int area)
    {
        ArrayList<Sighting> records = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                if(record.getArea() == area) {
                    records.add(record);
                }
            }
        }
        return records;
    }

    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public ArrayList<Sighting> getSightingsOf(String animal)
    {
        ArrayList<Sighting> filtered = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                filtered.add(record);
            }
        }
        return filtered;
    }
    
    /**
     * Prints a list of all the animals sighted on a particular dayID
     * @param spotted of the type Integer.
     */
    public void sightedOn(Integer spotted) {
        sightings.stream()
            .filter(s -> spotted.equals(s.getPeriod()))
            .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Prints a list of all the animals sighted on a particular dayID
     * with a particular name
     * @param spotted of the type Integer.
     */
    public void nameAndSighted(Integer spotted, String name) {
        sightings.stream()
            .filter(s -> spotted.equals(s.getPeriod()))
            .filter(s -> name.equals(s.getAnimal()))
            .forEach(s -> System.out.println(s.getDetails()));
    }

    /**
     * Returns the value of of the count of an animal spotted on a specific day by a specific spotter.
     * @param spotterID of the type int.
     * @param dayID of the type int.
     * @param animal of the type String
     */
    public int idSpotterDay(int spotterID, int dayID, String animal) {
        return sightings.stream()
            .filter(s -> spotterID == s.getSpotter()) //filters for ID
            .filter(s -> dayID == s.getPeriod()) // filters for period
            .filter(s -> s.getAnimal().equals(animal)) // filters for animal name
            .map(s -> s.getCount()) //maps value to a new stream
            .reduce(0, (total,count) -> total + count); // gives us the int value for count.
    }
    
    
    /**
     * Returns a string of animals spotted on a certain day if the count is greater than 0, by a certain spotter 
     * @param  spotterID the id number of the spotter
     * @param dayID the day the animal was spotted
     * @return a String of the names of the animals spotted
     */
    public String spotterDayAnimal(int spotterID, int dayID) {
        return sightings.stream()
            .filter(s -> s.getCount() > 0)
            .filter(s -> spotterID == s.getSpotter())
            .filter(s -> dayID == s.getPeriod())
            .map(s -> s.getAnimal())
            .reduce("", (total, count) -> count + " " + total);
    }
    
    /**
     * Prints 1-10
     */
    public void oneToTen() {
        int i = 1;
        
        do {
            
            System.out.println(i);
            i ++;
        }while(i<=10);    
    }
    
    public void checkTop(int topVar) {
        int k = topVar;
        int top = 0;
        int m = 3;
        
        if(k > 0 && k > m) {
            top = k;    
        } else {
             top = m;        
        }
    }
    
    public void printBill(String name, int age) {
        System.out.println("Hello " + name + ", you are " + age + " years old.");    
    }
}
