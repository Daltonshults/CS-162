/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    //Used to create random log files
    private LogfileCreator createFiles;
    
    


    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
        
        analyzeHourlyData();


    }
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String logfile)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        
        //creates a logFileCreator so random files can be generated. 
        createFiles = new LogfileCreator();
        
        //populates the new file created. 
        createFiles.createFile(logfile, 25);
        
        // Create the reader to obtain the data.
        reader = new LogfileReader(logfile); 


    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        
        while (hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour += 1;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
    * Print all the values in the marks array that are
    * greater than mean.
    * @param marks An array of mark values.
    * @param mean The mean (average) mark.
    */
    public void printGreater(double[] marks, double mean)
    {
        for(int index = 0; index <= marks.length; index++) {
            if(marks[index] > mean) {
                System.out.println(marks[index]);
            }
        }
    }
    
    /**
    * Return the number of accesses recorded in the log file.
    */
    public int numberOfAccesses()
    {
        int total = 0;
        // Add the value in each element of hourCounts to
        // total.
        for (int index = 0; index < hourCounts.length ; index += 1) {
            total = total + hourCounts[index];            
        }
        return total;
    }
    
    /**
     * Returns the busiuest hour.
     * @return int hourHolder is the busiest hour. 
     */
    
    public int busiestHour() {
        //initializing the variable used for returning the hour
        int hourHolder = 0;
        //initializing the variable used for comparing number of times accessed
        int countHolder = 0;
        
        //itterating over hourCounts
        for (int index = 0; index < hourCounts.length; index +=1) {
            
            if (countHolder < hourCounts[index]) {
                hourHolder = index;
                countHolder = hourCounts[index];
            }                
        }
        
        return hourHolder;    
    }
    
        /**
     * Returns the busiuest hour.
     * @return int hourHolder is the busiest hour. 
     */
    
    public int quietestHour() {
        //initializing the variable used for returning the hour
        int hourHolder = 0;
        //initializing the variable used for comparing number of times accessed
        int countHolder = Integer.MAX_VALUE;
        
        //itterating over hourCounts
        for (int index = 0; index < hourCounts.length; index +=1) {
            
            if (countHolder > hourCounts[index]) {
                hourHolder = index;
                countHolder = hourCounts[index];
            }                
        }
        
        return hourHolder;    
    }
}
