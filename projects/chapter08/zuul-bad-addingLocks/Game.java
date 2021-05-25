import java.util.Stack;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    //private Room currentRoom;
    private Stack<Room> roomStack;
    
    private Player player;
    
    private Beamer beamer;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        roomStack = new Stack<>();
        player = new Player();
        createRooms();
        parser = new Parser();
        //beamer = new Beamer();
        //play();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, cellar, trap;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        cellar = new Room("in the cellar");
        trap = new Room("you are trapped!");
        
        outside.setExit("west", pub);
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        Item key = new Item("Key");
        outside.addDroppedItem(key);
        
        theater.setExit("west", outside);
        
        pub.setExit("east", outside);
        pub.lockRoom();
        
        lab.setExit("north", outside);
        lab.setExit("west", office);
        
        office.setExit("east", lab);
        office.setExit("down", cellar);
        Item cookie = new Item("Cookie");
        office.addDroppedItem(cookie);
        
        cellar.setExit("up", office);
        cellar.setExit("down", trap);
        beamer = new Beamer();
        cellar.addDroppedItem(beamer);

        player.changeRoom(outside);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        player.printLocationInfo();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {

                lockedRoom(command);        
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("look")) {
            look();    
        } else if (commandWord.equals("eat")) {
            eat();        
        } else if (commandWord.equals("back")) {
            back();
        } else if (commandWord.equals("take")) {
            take(command);    
        } else if (commandWord.equals("bag")) {
            bag();    
        } else if (commandWord.equals("drop")) {
            drop(command);    
        } else if (commandWord.equals("charge")) {
            chargeBeamer();     
        } else if (commandWord.equals("fire")) {
            fireBeamer();
        }
    

        return wantToQuit;
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Your command words are: ");
        parser.showCommands();
    }
    
    /**
     * Takes the player back to the previous room. 
     */
    private void back() {
        if (player.currentRoom().getShortDescription().equals("you are trapped!")) {
            System.out.println("You are trapped"); 
        } else if (!roomStack.empty()) {
            Room lastRoom = roomStack.pop();
            player.changeRoom(lastRoom);
            System.out.println(player.currentRoom().getLongDescription());
        } else {
            System.out.println("You can't go back any farther!");
            System.out.println();
            System.out.println(player.currentRoom().getLongDescription());
        }    
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.currentRoom().getExit(direction);
        
        if (nextRoom == null) {
            System.out.println("There is no door!");    
        } else {
            player.changeRoom(nextRoom);
            System.out.println(player.currentRoom().getLongDescription());
            System.out.println(player.playerGetDescription());
        }
    }
    
    
    /**
     * the current iteration of the go method when dealing with locked doors. 
     */
    private void lockedRoom(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        
        
        String direction =  command.getSecondWord();
        
        Room nextRoom = player.currentRoom().getExit(direction);
        System.out.println(player.hasKey());
        
        if (nextRoom.getIsLocked() && player.hasKey() ) {
            System.out.println("The door has been unlocked with a key");
            roomStack.push(player.currentRoom());
            goRoom(command);
            nextRoom.unlockRoom();
        } else if (nextRoom.getIsLocked() && !player.hasKey() ) {
            System.out.println("Door is locked.");    
        } else {
            roomStack.push(player.currentRoom());
            goRoom(command);    
        }
    }
    
    
    /**
     * Allows the player to take items within a room.
     */
    private void take(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }
        
        String item = command.getSecondWord();
        ArrayList<Item> itemList = new ArrayList<>(player.currentRoom().getItems());
        
        for (Item i : itemList) {
            
            if (i.getName().equals(item)) {
                player.addToBag(i);    
            }  
            
        }
        
    }
    
    /**
     * Allows the player to take drop items from their bag.
     */
    private void drop(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
        
        String item = command.getSecondWord();
        
        ArrayList<Item> tempBag = new ArrayList<>(player.getBag());
        
        for (Item i : tempBag) {
            
            if (i.getName().equals(item)) {
                player.removeFromBag(i);    
            }
        }
        
    }
    
    private void leaveRoom(String direction) {
        Room nextRoom = player.currentRoom().getExit(direction);
        player.changeRoom(nextRoom);
        System.out.println(player.currentRoom().getLongDescription());
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    
    /**
     * Allows player to look around the current room and prints the room description
     */
    private void look() {
        System.out.println(player.currentRoom().getLongDescription()); 
        System.out.println(player.playerGetDescription());
    }
    
    /**
     * Allows your player to eat. Currently does nothing to the player.
     */
    private void eat() {
        ArrayList<Item> eatList = new ArrayList<>(player.getBag());
        
        for (Item i: eatList) {
            
            if (i.getName().equals("Cookie")) {
                player.removeFromBag(i);
                player.addMaxWeight();
            }
        }
    }
    
    private void bag() {
        System.out.println("Max Carrying Weight: " + player.getMaxWeight());
        System.out.println("Current Bag Weight: " + player.getWeight());
        System.out.println("Remaining weight: " + (player.getMaxWeight() - player.getWeight()));
        System.out.println();
        System.out.println("The items in your bag are: ");

        for (Item i: player.getBag()) {
            System.out.println(i.getDescription());
        }
    }
    
    private void chargeBeamer() {
        
        for (Item i: player.getBag()) {
            
            if(i.getName().equals("Beamer")) {
                beamer.setBeamer(player.currentRoom());   
            }
        }
        
        System.out.println("Your beamer is now charged to teleport you to: " + beamer.getBeamer().getShortDescription());
    }
    
    private void fireBeamer() {
        
        if (beamer.getBeamer() != null) {
            
            for (Item i : player.getBag()) {
            
                if (i.getName().equals("Beamer")) {
                    player.changeRoom(beamer.getBeamer());
                }
            }
        
            System.out.println("You are now...");
            System.out.println(player.currentRoom().getLongDescription() + player.playerGetDescription());
            
        } else {
            System.out.println("Your beamer is not charged!");    
        }
    }

}
