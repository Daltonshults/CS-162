
/**
 * Write a description of class Heater here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heater
{
    // instance variables - replace the example below with your own
    private double temperature;
    private double min;
    private double max;
    private double increment;

    /**
     * Constructor for objects of class Heater
     */
    public Heater(double setMax, double setMin)
    {
        temperature = 15.0;
        min = setMin;
        max = setMax;
        increment = 5.0;
    }

    public void warmer()
    {
        if((temperature + increment) <= max){
            temperature = temperature + increment;
        }
    }

    public void cooler()
    {
        if((temperature - increment) >= min){
            temperature = temperature - increment;
        }
    }

    public double getTemp()
    {
        return temperature;
    }
    
    public double getIncrement()
    {
        return increment;
    }
    
    public void setIncrement(double incrementAmount)
    {
        if(incrementAmount > 0){
            increment = incrementAmount;
        }
        else{
            increment = 1;
        }
    }
}
