
/**
 * Dylan Ghezzi 19078169
 * 29/10/2022
 * Player Sign Up Class
 * PDC Project 2
 */
import java.util.HashMap;

public class PlayerSignUp {

    HashMap<String, Integer> players; // hash map of players
    Object playerNames[]; // array of player names

    public PlayerSignUp() {
        players = PlayerIO.playersToHashMap(); // attempt to get players from player_log.txt
        if (players != null) {
            playerNames = players.keySet().toArray(); // get array of player names
        }
    }

    // attempt to add new player
    public boolean addNewPlayer(String name) {
        if (!players.containsKey(name)) { // if player is not already in the map
            players.put(name, 0); // add player with desired name and 0 wins
            playerNames = players.keySet().toArray(); // update player name array
            return true;
        }
        // if player already exists, do nothing
        return false;
    }

    // attempt to remove exisiting player
    public boolean removePlayer(String name) {
        if (players.containsKey(name)) { // if player is in the map
            players.keySet().remove(name); // remove player from list
            playerNames = players.keySet().toArray(); // update player name array
            return true;
        } // if player is not in the map, do nothing
        return false;
    }

    // get String representation of players and their wins
    public String getPlayerList() {
        String playerList = "";
        for (int i = 0; i < playerNames.length; i++) { // display each player and their wins
            playerList += (i + 1 + ". " + playerNames[i] + ", " + players.get((String) playerNames[i]) + " wins\n");
        }
        return playerList;
    }
}
