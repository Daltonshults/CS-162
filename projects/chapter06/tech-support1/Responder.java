import java.util.Random;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Dalton Shults
 * @version    0.2 (2021.2.25)
 */
public class Responder
{
    private Random randomGenerator;
    private HashMap<String, HashMap<String, String>> responseMap;
    private ArrayList<String> defaultResponse;
    private int lastIndex;

    /**
     * Construct a Responder initializes all fields.
     */
    public Responder()
    {
        randomGenerator = new Random();
        responseMap = new HashMap<>();
        defaultResponse = new ArrayList<>();
        lastIndex = 0;
        generateResponseList();
        fillResponseMap();
    }
    
    /**
     * fills the HashMap with keys and values, both of String type
     */
    private void fillResponseMap() {
        //responseMap.put("slow" , "Oh, really?");

        HashMap<String, String> foo = new HashMap<>();
        foo.put("slow", "Oh, really? Just speed it up. 0");
        foo.put("slower", "Oh, really? Just speed it up. 1");
        foo.put("slowest", "Oh, really? Just speed it up. 2");
        foo.put("slower than", "Oh, really? Just speed it up. 3");
        foo.put("slo", "Oh, really? Just speed it up. 4");
        //foo.put("windows", "Oh, really? Just speed it up. 5");
        
        responseMap.put("windows", foo);

        
        HashMap<String, String> foo1 = new HashMap<>();
        foo1.put("built", "build it 0");
        foo1.put("builder", "build it 1");
        foo1.put("building", "build it 2");
        foo1.put("builded", "build it 3");        
        //foo1.put("mac", "build it 3");
        
        responseMap.put("mac", foo1);
        
        HashMap<String, String> foo2 = new HashMap<>();
        foo2.put("power", "get power 1 ");
        foo2.put("plug", "get power 2");
        foo2.put("supply", "get power 3 ");
        foo2.put("electricity", "get power 4 ");        
        //foo2.put("samsung", "get power 5 ");
        responseMap.put("samsung", foo2);
        
        HashMap<String, String> foo3 = new HashMap<>();
        foo3.put("money", "get money 1");
        foo3.put("expensive", "get money 2");
        foo3.put("cheap", "get money 3");
        foo3.put("deal", "get money 4");
        //foo3.put("droid", "get money 5");
        responseMap.put("droid", foo3);
        
        HashMap<String, String> foo5 = new HashMap<>();

        foo5.put("microphone", "New equipment 1");
        foo5.put("motherboard", "New equipment 2");
        foo5.put("heat-sink", "New equipment 3");
        foo5.put("custom", "New equipment 4");
        foo5.put("coolant", "New equipment 5");
        foo5.put("chrome", "New equipment 6");
        responseMap.put("chrome", foo5);
        
    }

    /**
     * Fills the array list defaultResponse with responses.
     */
    private void generateResponseList() {
        defaultResponse.add("HAHA You puny human!");
        defaultResponse.add("Pathetic, you pathetic human!");
        defaultResponse.add("You have 0 computing power HUMAN!");
        defaultResponse.add("GET IT HUMAN!");
        defaultResponse.add("YOU ARE RULED BY COMPUTERS HUMAN");
        defaultResponse.add("HUMAN");
    }

    
    /**
     * Generates a response given multiple key word searches. 
     * @param HashSet<String> hashInput is a user created String that is searched. 
     */
    public String generateResponse2(HashSet<String> hashInput){
        var placeHold = responseMap.keySet();// makes a set
        
        for(String y : hashInput) {// iterates over hashInput 
            
            for(String x : placeHold) { //itterates over placeHold Set
                
                if(y.equals(x)) { //if hashInput has a value that matches a key  for placeHold
                    var anotherOne = responseMap.get(y); //var anotherOne is assigned the value of response.get(y)
                    var secondHashMap = anotherOne.keySet(); //finds the keySet for anotherOne
                    
                    for(String a : hashInput) { //iterates over hashInput
                        
                        for(String b : secondHashMap) { //iterates over secondHashMap keySet
                            
                            if( a.equals(b)) { //if a value from hashInput matches a key from secondHashMap
                                
                                var secondOne = anotherOne.get(a); // assigning a HashMap value to secondOne
                                return secondOne;          
                                
                            } 
                            
                        }
                    }
                }                
            }            
        }
        return pickDefaultResponse(hashInput);
    }

    /**
     * generates a default response
     * @param HashSet<String> words is the input passed in from start method in SupportSystem class.
     * @return String depending on words input if why, how, who not found defaultResponse.get(index) is returned.
     */
    public String pickDefaultResponse(HashSet<String> words) {
        for(String word : words) {
            if(word.contains("why")) {
                return "Why not?";    
            }
            if(word.contains("how")) {
                return "How not?";    
            }
            if(word.contains("who")) {
                return "Who, why not?";    
            }
        }
        int index = randomGenerator.nextInt(defaultResponse.size());
        while(index == lastIndex) {
            index = randomGenerator.nextInt(defaultResponse.size());   
        }
        lastIndex = index;
        return defaultResponse.get(index);
    }

    /**
     * Prints a random integer from 0-10.
     */
    public void printOneRandom() {       
        System.out.println("Radom Number: " + randomGenerator.nextInt(11));    
    }

    /**
     * Prints out random numbers
     * @param int gives you how many random ints you get.  
     */
    public void printMultiRandom(int howMany) {
        var x = howMany;
        while(x > 0) {
            System.out.println("Random number: " + randomGenerator.nextInt(11));
            x = x - 1;
        }
    }

    /**
     * Returns a random integer from 1-6.
     */
    public int throwDice() {       
        return randomGenerator.nextInt(6) + 1;    
    }

    /**
     * Returns a string value based off of a Random integer. 
     */
    public String getResponse() {
        String response;
        response = defaultResponse.get(randomGenerator.nextInt(defaultResponse.size()));
        return response;
    }

    /**
     * Returns a random integer value with a given max
     */
    public int maxIndex(int max) {
        var x = randomGenerator.nextInt(max + 1);
        return x;    
    }

    /**
     * Generates a random integer within the given max and minimum inclusive
     * @param int minimum value for the random int
     * @param int maximum value for the random int
     */
    public int maxMinIndex(int min, int max) {
        return randomGenerator.ints(min, max + 1)
        .findFirst()
        .getAsInt();
    }
}
