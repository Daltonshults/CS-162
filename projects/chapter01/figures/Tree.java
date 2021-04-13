
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree
{
    // instance variables - replace the example below with your own
    private Triangle leaves;
    private Square trunk;

    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
        leaves = new Triangle();
        trunk = new Square();
    }
    
    public void setup()
    {
        trunk.makeVisible();
        trunk.changeSize(40);
        trunk.moveHorizontal(-10);
        
        leaves.makeVisible();
        leaves.moveHorizontal(110);
        leaves.moveVertical(-60);
        leaves.changeSize(70, 70);
        

    }
    
}
