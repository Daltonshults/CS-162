/**
 * Provide a textual interface to an AddressBook.
 * Different commands provide access to the data in the address book.
 *
 *      One to search the address book.
 *
 *      One to allow a set of contact details to be entered.
 *
 *      One to show all the entries in the book.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class AddressBookTextInterface
{
    // The address book to be viewed and manipulated.
    private AddressBook book;
    // A parser for handling user commands.
    private Parser parser;
    
    /**
     * Constructor for objects of class AddressBookTextInterface
     * @param book The address book to be manipulated.
     */
    public AddressBookTextInterface(AddressBook book)
    {
        this.book = book;
        parser = new Parser();
    }
    
    /**
     * Read a series of commands from the user to interact
     * with the address book. Stop when the user types 'quit'.
     */
    public void run()
    {
        System.out.println("Address Book.");
        System.out.println("Type 'help' for a list of commands.");
        
        String command;
        do{
            command = parser.getCommand();
            if(command.equals("add")){ 
                add();
            }
            else if(command.equals("get")){
                get();
            }
            else if(command.equals("list")){
                list();
            }
            else if(command.equals("search")){
                find();
            }
            else if(command.equals("help")){
                help();
            }
            else{
                // Do nothing.
            }
        } while(!(command.equals("quit")));

        System.out.println("Goodbye.");
    }
    
    /**
     * Add a new entry.
     */
    private boolean add()
    {
        System.out.print("Name: ");
        String name = parser.readLine();
        System.out.print("Phone: ");
        String phone = parser.readLine();
        System.out.print("Address: ");
        String address = parser.readLine();
        boolean tf = book.keyInUse(name);
        book.addDetails(new ContactDetails(name, phone, address));
        //boolean tf = book.addDetails(new ContactDetails(name, phone, address));
        if(tf == true) {
            System.out.println("Not added already in the address book.");
        } else {
            System.out.println("Added");
        }
        
        return tf;
    }
    
    /**
     * Find an entry matching a key.
     */
    private void get()
    {
        System.out.println("Type the key of the entry.");
        String key = parser.readLine();
        ContactDetails result = book.getDetails(key);
        System.out.println(result);
    }
    
    /**
     * Find entries matching a key prefix.
     */
    private void find()
    {
        System.out.println("Type a prefix of the key to be found.");
        String prefix = parser.readLine();
        ContactDetails[] results = book.search(prefix);
        if(results.length == 0) {
            System.out.println("Not found.");
        }
        
        for(int i = 0; i < results.length; i++){
            System.out.println(results[i]);
            System.out.println("=====");
        }
    }
    
    /**
     * List the available commands.
     */
    private void help()
    {
        parser.showCommands();
    }
    
    /**
     * List the address book's contents.
     */
    private void list()
    {
        System.out.println(book.listDetails());
    }
}
