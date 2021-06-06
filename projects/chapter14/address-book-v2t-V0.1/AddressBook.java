import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Objects;

/**
 * A class to maintain an arbitrary number of contact details.
 * Details are indexed by both name and phone number.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class AddressBook
{
    // Storage for an arbitrary number of details.
    private TreeMap<String, ContactDetails> book;
    private int numberOfEntries;

    /**
     * Perform any initialization for the address book.
     */
    public AddressBook()
    {
        book = new TreeMap<>();
        numberOfEntries = 0;
    }
    
    /**
     * Look up a name or phone number and return the
     * corresponding contact details.
     * @param key The name or number to be looked up.
     * @return The details corresponding to the key.
     * @throws IllegalArgumentException if the key is invalid yo!
     */
    public ContactDetails getDetails(String key)
    {   
        // if(key == null) {
            // throw new IllegalArgumentException("null key in getDetails");   
        // }
        if(key.trim().length() == 0) {
            throw new IllegalArgumentException(
                                        "Empty key passed to getDetails");
        }
        Objects.requireNonNull(key, "null key passed to getDetails");
        
        return book.get(key);
    }

    /**
     * Return whether or not the current key is in use.
     * @param key The name or number to be looked up.
     * @return true if the key is in use, false otherwise.
     */
    public boolean keyInUse(String key)
    {
        Objects.requireNonNull(key, "null key passed to keyInUse");
        if(key.isEmpty()){
            throw new IllegalArgumentException("key passed to keyInUse was empty");   
        }
        return book.containsKey(key);
    }

    /**
     * Add a new set of details to the address book.
     * @param details The details to associate with the person.
     * @throws requireNonNull if null is passed into details
     */
    public boolean addDetails(ContactDetails details)
    {
        Objects.requireNonNull(details, "null details passed to addDetails");
        
        if(book.get(details.getName()) == null){
            
            if(details != null) {
                book.put(details.getName(), details);
                book.put(details.getPhone(), details);
                numberOfEntries++;
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Change the details previously stored under the given key.
     * @param oldKey One of the keys used to store the details.
                     This should be a key that is currently in use.
     * @param details The replacement details.
     * @throws requireNonNull if old key is null
     * @throws requireNonNull if details is null
     */
    public void changeDetails(String oldKey,
                              ContactDetails details)
    {
        Objects.requireNonNull(oldKey, "null oldKey passed to changeDetails");
        Objects.requireNonNull(details, "null details passed to changeDetails");
        
        if(keyInUse(oldKey) && details != null) {
            removeDetails(oldKey);
            addDetails(details);
        }
    }
    
    /**
     * Search for all details stored under a key that starts with
     * the given prefix.
     * @param keyPrefix The key prefix to search on. This may be
     *                  of zero length, but must not be null.
     * @return An array of those details that have been found.
     * @throws requireNonNull if keyPrefix is null
     */
    public ContactDetails[] search(String keyPrefix)
    {
        // Build a list of the matches.
        Objects.requireNonNull(keyPrefix, "null keyPrefix passed to getDetails");
        
        List<ContactDetails> matches = new LinkedList<>();
        
        if(keyPrefix != null) {
            
            // Find keys that are equal-to or greater-than the prefix.
            SortedMap<String, ContactDetails> tail = book.tailMap(keyPrefix);
            Iterator<String> it = tail.keySet().iterator();
            
            // Stop when we find a mismatch.
            boolean endOfSearch = false;
            
            while(!endOfSearch && it.hasNext()) {
                String key = it.next();
                
                if(key.startsWith(keyPrefix)) {
                    matches.add(book.get(key));
                }
                else {
                    endOfSearch = true;
                }
                
            }
            
        }
        
        ContactDetails[] results = new ContactDetails[matches.size()];
        matches.toArray(results);
        return results;
    }

    /**
     * Return the number of entries currently in the
     * address book.
     * @return The number of entries.
     */
    public int getNumberOfEntries()
    {
        return numberOfEntries;
    }

    /**
     * Remove the entry with the given key from the address book.
     * The key should be one that is currently in use.
     * @param key One of the keys of the entry to be removed.
     * @throws requireNonNull if key is null
     */
    public void removeDetails(String key)
    {
        Objects.requireNonNull(key, "null key passed to removeDetails");
        
        if(keyInUse(key)) {
            ContactDetails details = book.get(key);
            book.remove(details.getName());
            book.remove(details.getPhone());
            numberOfEntries--;
        }
    }

    /**
     * Return all the contact details, sorted according
     * to the sort order of the ContactDetails class.
     * @return A sorted list of the details.
     */
    public String listDetails()
    {
        // Because each entry is stored under two keys, it is
        // necessary to build a set of the ContactDetails. This
        // eliminates duplicates.
        StringBuilder allEntries = new StringBuilder();
        Set<ContactDetails> sortedDetails = new TreeSet<>(book.values());
        for(ContactDetails details : sortedDetails) {
            allEntries.append(details).append("\n\n");
        }
        return allEntries.toString();
    }
}
