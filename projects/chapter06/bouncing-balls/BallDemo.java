import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> storeBalls;
    private ArrayList<BoxBall> storeBox;
    private static Random rand = new Random();
    private ArrayList<Color> colors;
    private int ground;
    private static final int GROUND = 200;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 500;
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", WINDOW_WIDTH, WINDOW_HEIGHT, GROUND);
        storeBalls = new ArrayList<>();
        storeBox = new ArrayList<>();
        colors = new ArrayList<>();
        initColors(); 
 
    }
    
    /**
     * Initializes the  ArrayList<> colors.
     */
    private void initColors() {
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);       
    }
    
    /**
     * Simulate two bouncing balls
     * @param int ballcount is the amount of balls you would like in your image. 
     */
    public void bounce(int ballCount)
    { 
        //array list of color, load it up with colors, and use a rand int to choose colors.
        createBalls(ballCount);
        myCanvas.erase();
        myCanvas.drawGround();
        boolean stillMoving =  true;
        boolean ballMoved = false;
        
        while (stillMoving) {
            ballMoved = false;
            
            for (BouncingBall ball : storeBalls) {
                                
                if (ball.getXPosition() <= WINDOW_WIDTH - 50) {
                    ball.draw();
                    ball.move();

                    ballMoved = true;
                }                
            }           

            stillMoving = ballMoved;
            myCanvas.wait(50);
        }
    }
    
    /**
     * Makes a rectangular box that the balls bounce around in.
     *@param int ballCount is how many balls you have.  
     */
        public void boxBounce(int ballCount) {
        createBoxBalls(ballCount);
        myCanvas.erase();
        myCanvas.drawBox();
        boolean stillMoving = true;
        boolean ballMoved = false;
        
        while(stillMoving) {
            ballMoved = false;
            
            for(BoxBall ball : storeBox) {
                
                //if(ball.getXSpeed() <= 0 && ball.getXSpeed() <= 0) {
                    ball.draw();
                    ball.move();
                    
                    ballMoved = true;
                //}
            }
            
            stillMoving = ballMoved;
            myCanvas.wait(50);
        }
 
    }
    
    /**
     * populates ArrayList<BallCount>.
     * @param int how many balls you would like to make. 
     */
    private void createBalls(int ballCount) {
        storeBalls.clear();
        BouncingBall ball;
        
        for(int i = 0; i < ballCount; i++) {
            int randXLoc = rand.nextInt(100)+5;
            int colorIndex = rand.nextInt(colors.size());
            Color randColor = colors.get(colorIndex);
            ball = new BouncingBall(randXLoc, 50, 16, randColor, GROUND, myCanvas);
            storeBalls.add(ball);
        }
            
    }
    
        /**
     * populates ArrayList<BallCount>.
     * @param int how many balls you would like to make. 
     */
    private void createBoxBalls(int ballCount) {
        storeBalls.clear();
        BoxBall ball;
        
        for(int i = 0; i < ballCount; i++) {
            int randXLoc = rand.nextInt(100) + 25;
            int randYLoc = rand.nextInt(100) + 375;
            int randXSpeed = rand.nextInt(10) + 1;
            int colorIndex = rand.nextInt(colors.size());
            Color randColor = colors.get(colorIndex);
            ball = new BoxBall(randXLoc, 50, 16, randColor, 475, 25, 575, myCanvas, randXSpeed);
            storeBox.add(ball);
        }            
    }
}
