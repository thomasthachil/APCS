import java.util.*;

public class MusicLibraryRunner
{
  public static String clean(String str)
  {
   return str.substring(1, str.length()- 1).trim(); 
  }
  
  public static void main (String[] args)
  {
    Song song;
    int count = 0;
    MusicReader mr = new MusicReader();
    MusicLibrary ml = new MusicLibrary();
    
    mr.open("src/musiclist.csv");//if using intelliJ IDEA, need to put use src/ reference
    
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
        int year = Integer.parseInt(clean(data[3]));
        double score = Double.parseDouble(clean(data[4]));
        
        ml.addSong(new Song(clean(data[0]), clean(data[1]), year, score, clean(data[16])));  // data[0] is the artist and data[1] is the name
        count++;
      }
      
      if (count >= 10)  // Changed to 10 songs
        break;
      
      data = mr.getSongData();  // Get next line of song data
    }
    System.out.println("Size: " + ml.songs.size());
    for (int i = 0; i < ml.songs.size(); i++)
    {
      System.out.println(ml.songs.get(i).name);
    }
    System.out.println(" ");

    ml.Sort();
    for (int i = 0; i < ml.songs.size(); i++)
    {
      System.out.println(ml.songs.get(i).name);
    }
    System.out.println(" ");

    System.out.println("Enter a number from 0-9");
    Scanner scanner = new Scanner(System.in);
    System.out.println(ml.getSong(scanner.nextInt()).notes);

    mr.close();
  }
}