import java.util.*;
import static java.lang.Math.min;
public class functions {
    private Map<String,ArrayList<String>>artistSongs;
    private String artistName;
    private String songName;
    public functions() {
        artistSongs = new HashMap<>();
        this.artistName=null;
        this.songName=null;
    }
    public  void Add(String artistName,String songName )
    {
        ArrayList<String> songs = artistSongs.getOrDefault(artistName, new ArrayList<>());
        songs.add(songName);
        artistSongs.put(artistName,songs);
    }
    public void displaySongs() {
        System.out.println("\nSongs by Artists:");
        for (Map.Entry<String, ArrayList<String>> entry : artistSongs.entrySet()) {
            String artistName = entry.getKey();
            List<String> songs = entry.getValue();

            System.out.println(artistName + "'s Songs:");
            for (String song : songs) {
                System.out.println("- " + song);
            }
        }
    }
    public void top10(Map<String,Integer>SongFreq){
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()  // Comparator to create a max-heap by frequency
        );

        // Add all map entries to the max-heap
        maxHeap.addAll(SongFreq.entrySet());

        // Print the sorted entries by frequency
        System.out.println("Words sorted by frequency (highest first):");
        Integer c=0;
        while (c<=min(10,maxHeap.size())) {
            Map.Entry<String, Integer> entry = maxHeap.poll();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            c++;
        }
    }
    public void lookSong(String artistName,String songName){
        char continueAdding;
        Scanner scanner = new Scanner(System.in);
        // Loop to keep adding songs until the user decides to stop
        do {
            // Ask the user to input the artist name
            System.out.print("Enter artist's name: ");
            artistName = scanner.nextLine();
            if(artistName!=null){
                this.artistName=artistName;
            }
            // Ask the user to input the song name
            System.out.print("Enter song name: ");
            songName = scanner.nextLine();
            if(artistName!=null){
                this.artistName=artistName;
            }
            if(artistName)
            // Ask the user if they want to add another song
            System.out.print("Do you want to search another song? (y/n): ");
            continueAdding = scanner.nextLine().charAt(0); // Read the first character

        } while (continueAdding == 'y' || continueAdding == 'Y');

        // Close the scanner
        scanner.close();
    }

}