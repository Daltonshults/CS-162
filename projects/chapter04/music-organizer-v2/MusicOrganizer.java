import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * prints a list of all files 
     */
    public void listAllFiles()
    {
        for (int i = 0; i < files.size(); i += 1) {
            System.out.println("Index: " + i);
            System.out.println("Name of File: " + files.get(i));
            System.out.println("");
        }
    }

    /**
     * Searches the list of the file names and prints matching names.
     */

    public void listMatching(String searchString)
    {
        boolean matchFound = false;

        for(String filename : files) {
            if(filename.contains(searchString)) {
                System.out.println(filename);
                matchFound = true;
            }
        }

        if(!matchFound) {
            System.out.println("Your search came up with no results");
        }
    }

    public void playAllBy(String artist)
    {
        for(String filename : files) {
            if(filename.contains(artist)) {
                player.playSample(filename);    
            }
        }
    }

    public int findFirst(String searchString) 
    {
        int index = 0;
        
        boolean searching = true;
        
        int onlyOnce = files.size();
        
        while(searching && index < onlyOnce) {
            String filename = files.get(index);
            if(filename.contains(searchString)) {
                searching = false;    
            }
            else {
                index++;
            }
        }
        if(searching) {
            return -1;   
        }
        else{ 
            return index;    
        }                
    }
    
    public void sum(int a, int b)
    {
        int index = a;
        int total = 0;

        
        while(a <= index && b >= index) {
            total = total + index;
            System.out.println("index: " + index);
            if(index == b) {
                System.out.println("Sum: " + total);    
            }
            index = index + 1;
        }
    }
    
    

    public boolean isPrime(int n)
    {
        int start = 2;
        boolean foo = true;
        
        while(2 <= start && n - 1 >= start) {
            if(n % start == 0) {
                foo = false;     
            }
            start = start + 1;
        }
        
        if(foo) {
            return true;    
        }else {
            return false;    
        }
    }
}