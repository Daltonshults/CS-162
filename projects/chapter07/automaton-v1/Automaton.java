import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29 - version 1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells + 1];
        // Seed the automaton with a single 'on' cell in the middle.
        state[numberOfCells / 2] = 1;
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update()
    {
        // Build the new state in a separate array.
        //int[] nextState = new int[state.length];
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        int left = 0;
        int center = state[0];
        int centerSaved = center;
        
        for (int i = 0; i < numberOfCells; i++) {
            centerSaved = center;
            int right = state[i + 1];
            state[i] = calculateNextState(left, center, right);
            left = centerSaved;
            center = right;            
        }
        
    }
    
    /**
     * Caculates the value for where it will be placed on the state array
     * @param int left is the value for the state of the left cell
     * @param int center is the value for the state of the center cell
     * @param int right is the value for the state of the right cell
     */
    private int calculateNextState(int left, int center, int right) {
        return (left + center + right) % 2;
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 2] = 1;
            
    }
}
