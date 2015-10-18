import java.util.*;

public class MusicLibrary {
  
  public ArrayList<Song> songs;// = new ArrayList<Song>();
  private int currentSortField = 0;  // Unsorted
  
  
  public MusicLibrary() { 
    songs = new ArrayList<Song>();
  }
  
  /* 
   * Add song to songs ArrayList
   */
  public void addSong (Song song)
  {
    songs.add(song);
  }
  
  /*
   * Retrieve a song by number
   * Return null if song index num is out of bounds
   */
  public Song getSong (int num)
  {
    
    if (num > songs.size() || num < 0)
    return null;
    return songs.get(num);
  }
  
  /*
   * Sort song list by title
   */
  public void Sort ()
  {
      
  }
  
  /*
   * Sort song list by a specific field
   * 
   * 1 = title
   * 2 = artist
   */
  public void Sort (int field)
  {
    currentSortField = field;
  }
  
  /*
   * Shuffle song list
   */
  public void Shuffle ()
  {
    long seed = System.nanoTime();
    Collections.shuffle(songs, new Random(seed));
  }
}
