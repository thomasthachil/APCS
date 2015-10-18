
import java.util.Comparator;

public class Song implements Comparable<Song>{
  
  public String artist;//shouldn't these be private tanczos?
  public String name;
  public int year;
  public double score;
  public String notes;
  // More fields here
  
  // Default constructor.. you'll need to modify this
  public Song(String artist, String name, int year, double score, String notes) {
    this.artist = artist;
    this.name = name;
    this.year = year;
    this.score = score;
    this.notes = notes;
  }
  
  /* ADD YOUR CODE HERE */
  @Override //not sure why this is needed - something to do with not being an abstract class?
  public int compareTo(Song s1)
  {
    String compare=((Song)s1).name;
        /* For Ascending order*/
    return this.name.compareTo(compare);
  }

  public static Comparator<Song> artistField = new Comparator<Song>()
  {

    public int compare(Song s1, Song s2) {

      String compareArtist1 = s1.artist;
      String compareArtist2 = s2.artist;

      //ascending order
      return compareArtist1.compareTo(compareArtist2);
    }

  };
}
