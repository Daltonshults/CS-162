import java.util.HashMap;
import java.util.HashSet;


/**
 * Write a description of class MapTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapTester
{
    // initializing a hashmap 
    private HashMap<String, String> contactsList;
    
    /**
     * Constructor for objects of class MapTester
     */
    public MapTester()
    {
        contactsList = new HashMap();
        addContacts(); // adding contacts so you don't have to every time
    }

    /**
     * Adds contacts to the contactsList HashMap
     */
    private void addContacts()
    {
        contactsList.put("Charles Ngueyen", "(531)939-4789");
        contactsList.put("Lisa Jones", "(541)389-3263");
        contactsList.put("Amber Lee", "(541)648-1327");
        contactsList.put("William Smith", "(541)808-8008");
        contactsList.put("Kayla Snell", "(415)280-2564");
        contactsList.put("Gina Dunkdunk", "(645)546-9863");
        contactsList.put("Hiko Theif", "(479)565-5656");
        contactsList.put("Boom Bot", "(654)848-6593");
        contactsList.put("Sova Bolt", "(132)123-1234");
    }
    
    /**
     * Add a contact to contactsList
     * @param name type String
     * @param number type String
     */
    public void enterNumber(String name, String number) {
        contactsList.put(name, number);   
    }
    
    /**
     * Search for a phone number from a contact name. 
     * @param name type String
     * @return type String if contact if found. 
     */
    public String lookupNumber(String name) {
        String searchContact = contactsList.get(name);
        return searchContact;
    }
    
    /**
     * Prints the Keys for the hash map contactList
     */
    public void printKeys() {
        System.out.println(contactsList.keySet());    
    }
    
    public boolean containsKey(String enterKey) {
        boolean contained = false;
        if(contactsList.containsKey(enterKey)) {
            contained = true;
        }
        return contained;
    }
    


}
