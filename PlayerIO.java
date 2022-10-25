
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Player I/O
 * PDC Project 2
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerIO {

    // checks if users exist in player_log.txt and loads their wins if found
    public static boolean checkForExistingUser(Player player) {
        try {
            String name = player.getName();
            BufferedReader inStream = new BufferedReader(new FileReader("./resources/player_log.txt")); // buffered reader to read text file
            String line; // string to hold each line of read file
            while ((line = inStream.readLine()) != null) { // while the end of the file has not been reached
                String str[] = line.split(", "); // split into name and wins
                if (str[0].contentEquals(name)) { // if exisiting user has been found, load wins and return true
                    player.setWins(Integer.parseInt(str[1]));
                    inStream.close(); // close reader
                    return true;
                }
            } // else if player is not found
            inStream.close(); // close reader
            return false; // return false
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading from file player_log.txt");
        }
        return false; // if error reading, return false
    }

    // checks if users exist in player_log.txt and loads theirs wins if found
    public static boolean checkForExistingUser(ArrayList<Player> players) {
        boolean existing = true; // assume true
        for (Player player : players) { // for each player
            existing = checkForExistingUser(player); // check if player exists in player_log.txt
            if(existing == false) { // if one player does not exists
                break; // return false
            }
        }
        return existing;
    }

    // update user's wins in player_log.txt file
    public static boolean updateUserWins(Player player) {
        HashMap<String, Integer> list = playersToHashMap(); // hashMap of all players in player_log.txt
        list.put(player.getName(), player.getWins()); // add new user or update existing user to hash map
        return updateUsers(list);
    }

    // update multiple users' wins in player_log.txt file
    public static boolean updateUserWins(ArrayList<Player> players) {
        HashMap<String, Integer> list = playersToHashMap(); // hashMap of all players in player_log.txt
        for (Player player : players) { // for each player
            list.put(player.getName(), player.getWins()); // add new user or update existing user to hash map
        }
        return updateUsers(list);
    }

    // updates users saved in player_log.txt 
    public static boolean updateUsers(HashMap<String, Integer> players) {
        try {
            PrintWriter outStream = new PrintWriter(new FileWriter("./resources/player_log.txt"));
            // Iterate all key-value pairs of records, and write them to player_log.txt.
            for (Map.Entry<String, Integer> entry : players.entrySet()) {
                outStream.println(entry.getKey() + ", " + entry.getValue());
            }
            outStream.close(); // close stream
            return true; // return true if successful
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading from file player_log.txt");
        }
        return false; // return false if unsucessful
    }

    // takes all player entries from player_log.txt and puts into a hashMap
    public static HashMap<String, Integer> playersToHashMap() {
        // A hashmap for storing <name, wins> pairs, where name is the key, and wins is the value.
        HashMap<String, Integer> list = new HashMap();
        try {
            // Initialize the BufferedReader, which is used to read contents from player_log.txt.
            BufferedReader inStream = new BufferedReader(new FileReader("./resources/player_log.txt"));
            String line = "";
            while ((line = inStream.readLine()) != null) {
                // Split the content of a line by using a white space. E.g., if the content is 'Tom 103', it returns ['Tom','103'].
                String str[] = line.split(", ");
                // Put the pair to the hashmap.
                list.put(str[0], Integer.parseInt(str[1]));
            }
            inStream.close();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading from file player_log.txt");
        }
        return null;
    }
}
