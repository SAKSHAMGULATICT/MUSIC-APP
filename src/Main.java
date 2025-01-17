import java.util.*;
public class Main {
    public static void main(String[] args) {
        functions songManager = new functions();

        Scanner scanner = new Scanner(System.in);
        Map<String,Integer>SongFreq=new HashMap<>();
        String artistName;
        String songName;
        char continueAdding;

        // Loop to keep adding songs until the user decides to stop
        do {
            // Ask the user to input the artist name
            System.out.print("Enter artist's name: ");
            artistName = scanner.nextLine();

            // Ask the user to input the song name
            System.out.print("Enter song name: ");
            songName = scanner.nextLine();
            SongFreq.put(songName, SongFreq.getOrDefault(songName, 0) + 1);
            // Add the song for the artist
            songManager.Add(artistName,songName);

            // Ask the user if they want to add another song
            System.out.print("Do you want to add another song? (y/n): ");
            continueAdding = scanner.nextLine().charAt(0); // Read the first character

        } while (continueAdding == 'y' || continueAdding == 'Y');

        // Close the scanner
        scanner.close();

        // Display all songs by artists
        songManager.displaySongs();
        songManager.top10(SongFreq);
    }
}