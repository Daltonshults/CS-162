import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections; 

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;
    //Tracking if a song is already playing
    private boolean isPlaying;
    // Creating a Random object
    private Random randTrack;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<>();
        player = new MusicPlayer();
        reader = new TrackReader();
        randTrack = new Random();
        isPlaying = false;
        readLibrary("../audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }

    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }

    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(isPlaying) {
            stopPlaying();              
        }

        if(indexValid(index)) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            isPlaying = true;
            track.incrementCount();
            System.out.println("Now playing: " + track.getArtist() 
                + " - " + track.getTitle());
        }
    }


    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext()) {
            Track t = it.next();
            System.out.println(t.getDetails());
        }
    }
    
    
    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks2() {
        tracks.stream()
            .forEach(s -> System.out.println(s.getDetails()));
    }

    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist2(String artist) {
        tracks.stream()
            .filter(s -> s.getArtist().equals(artist))
            .forEach(s -> System.out.println(s.getDetails()));            
    }

    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }

    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if(tracks.size() > 0) {
            player.startPlaying(tracks.get(0).getFilename());
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
        isPlaying = false;
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }

    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }

    public void deleteArtist(String deleted)
    {
        Iterator<Track> track = tracks.iterator();
        while(track.hasNext()) {
            Track t = track.next();
            String artist = t.getArtist();
            if(artist.contains(deleted)) {
                System.out.println("Deleted: " + artist);
                track.remove();
            }            
        }    
    }

    
    /**
     * Plays each track at random. 
     */
    public void randomPlay() {
        // creating local variable copy.
        ArrayList<Track> copy = new ArrayList<>();
        // copy original into copy list
        for(Track track : tracks) {
            copy.add(track);
            //int songIndex = randTrack.nextInt(tracks.size());
        }
        
        int index = getNumberOfTracks() - 1; // last index
        
        //shuffle
        while(index > 0) {
            int songIndex = randTrack.nextInt(copy.size());
            
            Track temp = copy.get(songIndex);
            copy.set(songIndex, copy.get(index)); 
            copy.set(index, temp); 
            
            //decrement the index
            index -= 1;
        }
        
        //prints the order of the tracks    
        for(Track track : copy) {
            System.out.println(track.getDetails());
        }
        
        // plays each track
        for(Track track : copy) {
            player.playSample(track.getFilename());
        }
    }
    
    /**
     * Plays all your favorite tracks
     */
    public void playFavorites() {
        for(Track track : tracks) { 
            if(track.getIsFavorite()) {
                player.playSample(track.getFilename());     
            }
        }
    }    
}
 

