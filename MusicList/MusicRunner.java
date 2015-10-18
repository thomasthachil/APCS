import java.util.*;
import java.lang.String;

public class MusicRunner
{
  public static String Clean(String str)
  {
   return str.substring(1, str.length()- 1).trim(); 
  }
  
  public static void main (String[] args)
  {
    Song song;
    int count = 0;
    MusicReader mr = new MusicReader();
    MusicLibrary ml = new MusicLibrary();
    
    mr.open("musiclist.csv");
    
    String[] data = mr.getSongData();
    
    // First line contains all the fields - We don't want to save this anywhere but we can
    // print it for now to see what information we have.
    System.out.println(Arrays.toString(data));
    data = mr.getSongData();  // Get next line of song data
    
    // if data is null then we were unable to read a line of song data, so
    // this loop will continue to read lines of song data as long as there
    // IS song data available
    while (data != null)
    {
      // You probably will comment this out but for now print out the line so you can see what is there
      //System.out.println(Arrays.toString(data));
      //System.out.println("Running");
      // Let's try to create a Song object
      
      if (data[2].compareTo("\"song\"") == 0)
      {
        int year = Integer.parseInt(Clean(data[3]));
        double score = Double.parseDouble(Clean(data[4]));
        
        ml.addSong(new Song(Clean(data[0]), Clean(data[1]), year, score, Clean(data[16])));  // data[0] is the artist and data[1] is the name
        count++;
      }
      
      if (count >= 10)  // For now only read ONE song
        break;
      
      data = mr.getSongData();  // Get next line of song data
    }
    System.out.println("Size: " + ml.songs.size());
    for (int i = 0; i < ml.songs.size(); i++)
    {
      System.out.println(ml.songs.get(i).name);
    }
    
    mr.close();
  }
}