
/**
 * Dylan Ghezzi 19078169
 * 29/10/2022
 * Player Sign Up Class
 * PDC Project 2
 */
import java.util.HashMap;

public class PlayerSignUp {

    private static PlayerSignUp playerSignUp; // single static instance
    private HashMap<String, Integer> players; // hash map of players
    private Object playerNames[]; // array of player names

    private PlayerSignUp() {
        players = PlayerIO.playersToHashMap(); // attempt to get players from player_log.txt
        if (players != null) {
            playerNames = players.keySet().toArray(); // get array of player names
        }
    }
    
    // get PlayerSignUp instance, only one may be created at any time (Singleton Pattern)
    public static synchronized PlayerSignUp getInstance() {
        if(playerSignUp == null) { // if no instance has been created yet
            playerSignUp = new PlayerSignUp(); // create new instance
        }  // if instance already exists, do not create another
        
        return playerSignUp;
    }

    public HashMap<String, Integer> getPlayers() {
        return players;
    }
    
    public Object[] getPlayerNamesArray() {
        return playerNames;
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
    public String getPlayerListString() {
        String playerList = "";
        for (int i = 0; i < playerNames.length; i++) { // display each player and their wins
            playerList += (i + 1 + ". " + playerNames[i] + ", " + players.get((String) playerNames[i]) + " wins\n");
        }
        return playerList;
    }
    
    // do not allow cloning of class
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
