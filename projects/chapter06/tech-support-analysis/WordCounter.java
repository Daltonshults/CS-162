import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/**
 * Keep a record of how many times each word was
 * entered by users.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2016.02.29)
 */
public class WordCounter
{
    // Associate each word with a count.
    private HashMap<String, Integer> counts;

    /**
     * Create a WordCounter
     */
    public WordCounter()
    {
        counts = new HashMap<>();
    }
    
    /**
     * Update the usage count of all words in input.
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input)
    {
        for(String word : input) {
            int counter = counts.getOrDefault(word, 0);
            counts.put(word, counter + 1);
        }
    }
    
    
    /**
     * Prints the count of all the words used besides Keywords used for responses.
     * @param HashMap<String, String> input used for creating list of keys so they can be removed from counts.
     */
    public void printWordCounter(HashMap<String, String> input) {
        var x = input.keySet(); //creates a Set of String elements
        for(String i : x) { //iterate over the set
            counts.remove(i); //remove i from counts
        }
        System.out.println(counts); //print counts
    }
}
