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
    private String logfileHolder;
    
    


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

        analyzeHourlyData();
        
        logfileHolder = logfile;

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
    
    public void analyzeAccess() {
        reader = new LogfileReader(logfileHolder);
        int[] counts = new int[3];
        final int A200 = 0, A403 = 1, A404 = 2;
        
        while (reader.hasNext()) {
            LogEntry entry = reader.next();
            int access = entry.getAccess();
            
            switch (access) {
                case 200:
                    counts[A200] ++;
                    break;
                case 403:
                    counts[A403] ++;
                    break;
                case 404:
                    counts[A404] ++;
                    break;
                default:
                    System.out.println("Bad Data");
            }        
        }
        
        System.out.println("200 log returns: " + counts[A200]);
        System.out.println("403 log returns: " + counts[A403]);
        System.out.println("404 log returns: " + counts[A404]);
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
    
    /**
     * Returns the first hour of the two busiest consecutive hours. 
     * @return int of the first hour of the two busiest consecutive hours. 
     */
    public int twoHour() {
        int hourHolder = 0;
        int twoHourPer = 0;
        int twoHourComp = 0;
        int prevI = 0;
        
        int countHolder = 0;
        
        for (int i = 0; i < hourCounts.length; i += 1) {
            twoHourPer = prevI + hourCounts[i];            
            prevI = hourCounts[i];
            if (twoHourPer > twoHourComp) {
                twoHourComp = twoHourPer;
                hourHolder = i - 1;
            }
        }
        
        return hourHolder;
    }
    
    
    /**
     * Returns the amount of times the site was accessed in a year
     * @return int number of times site was accessed in a year
     * @param int which year you  are searching for
     */
    public int returnYearlyAccesses(int year) {
        int x = reader.supplyYear(year);
        return x;    
    }
    
    
    /**
     * Returns the amount of times the site was accessed in a day
     * @return int number of times site was accessed in a day
     * @param int which day you  are searching for
     */
    public int returnDailyAccesses(int day) {
        int x = reader.supplyDay(day);
        return x;    
    }
}
