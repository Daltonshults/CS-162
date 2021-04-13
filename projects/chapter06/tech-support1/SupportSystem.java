import java.util.Random;
import java.util.HashMap; 
import java.util.HashSet;

/**
 * This class implements a technical support system. It is the top level class 
 * in this project. The support system communicates via text input/output 
 * in the text terminal.
 * 
 * This class uses an object of class InputReader to read input from the user,
 * and an object of class Responder to generate responses. It contains a loop
 * that repeatedly reads input and generates output until the users wants to 
 * leave.
 * 
 * @author     Dalton Shults
 * @version    0.2 (2021.02.25)
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;
    
    /**
     * Creates a technical support system.
     * Initializes reader and responder
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }


    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            HashSet<String> input = reader.getInput();
            if(input.contains("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse2(input);
                System.out.println(response);
            }
        }

        printGoodbye();
    }
    
    /**
     * Main method used for calling without creating an instance. 
     */
    public static void main() {
        var sup = new SupportSystem();
        sup.start();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Nice talking to you. Bye...");
    }
    
    /**
     * Prints a random int between 0 and 10.
     * @return int returns a random integer. 
     */
    public int randomInt() {
        Random y = new Random();        
        return y.nextInt(11);    
    }
}
