import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);
        square(pen);
    }
    
    public void drawTriangle() {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.GREEN);
        
        triangle(pen);
    }
    /**
     * Draws my own drawing it's beautiful.
     *
     */
    public void myDrawing() {
        Color shapeColor = new Color(255, 0, 0);
        Color shapeColor2 = new Color(255, 0, 255);
        myCanvas.setForegroundColor(shapeColor);
        myCanvas.fillRectangle(200, 150, 100, 100);
        myCanvas.setForegroundColor(shapeColor2);
        myCanvas.fillCircle(100, 100, 50);
        shapeColor2 = new Color(100, 50, 100);
        myCanvas.setBackgroundColor(shapeColor2);
        int b = 0;
        int c = 500;
        for( int i = 0; i < 100; i++) { 
            myCanvas.drawString("Dalton", b, c);
            myCanvas.drawString("COMPUTERS", c, b);
            b = b + 5;
            c = c - 5;
        }
    }
    
    /**
     * Draws a spiral
     */
    public void drawSpiral() {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.DARK_GRAY);
        int length = 0;
        for(int i = 0; i<10; i++) {
            pen.move(length);
            pen.turn(90);
            length = length + 25;
        }
    }
    /**
     * Draws a pentagon on myCanvas. 
     */
    public void drawPentagon() {
        Pen pen = new Pen(50, 50, myCanvas);
        pen.setColor(Color.cyan);
        
        pentagon(pen);
    }
    
    /**
     * Draws a polygon based with the number of sides given
     * @param int number of sides for the shape
     */
    public void drawPolygon(int n) {
        Pen pen = new Pen(175, 175, myCanvas);
        pen.setColor(Color.RED);
        
        polygon(pen, n);
    }
    
    /**
     * Draws shape based off input given through drawPolygon method 
     */
    private void polygon(Pen pen, int n) {
        for(int i = 0 ; i < n; i++) {
            pen.move(100);
            pen.turn(360/n);
        }
    }
    
    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }
    
    /**
     * Draw a pentagon in the pen's color at the pen's location.
     */
    private void pentagon(Pen pen)
    {
        for (int i=0; i<5; i++) {
            pen.move(100);
            pen.turn(72);
        }
    }
    
    /**
     * Draw a triangle in the pen's color at the pen's location.
     */
    private void triangle(Pen pen)
    {
        for (int i=0; i<3; i++) {
            pen.move(100);
            pen.turn(120);
        }
    }
    
    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
