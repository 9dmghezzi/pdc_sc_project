
/**
 * Dylan Ghezzi 19078169
 * 29/10/2022
 * Player Sign Up Class
 * PDC Project 2
 */

public class PlayerSignUp {

    private PlayerDB playerDatabase;
    private static PlayerSignUp playerSignUp; // single static instance
    private Object playerNames[]; // array of player names

    private PlayerSignUp() {
        playerDatabase = new PlayerDB();
        playerNames = playerDatabase.getNameArray(); // get array of player names
    }
    
    // get PlayerSignUp instance, only one may be created at any time (Singleton Pattern)
    public static synchronized PlayerSignUp getInstance() {
        if(playerSignUp == null) { // if no instance has been created yet
            playerSignUp = new PlayerSignUp(); // create new instance
        }  // if instance already exists, do not create another
        
        return playerSignUp;
    }
    
    public Object[] getPlayerNamesArray() {
        return playerNames;
    }
    
    public PlayerDB getPlayerDatabase() {
        return playerDatabase;
    }
    
    // attempt to add new player
    public boolean addNewPlayer(String name) {
        if (playerDatabase.getUserWins(name) == -1) { // if player is not already in the map
            playerDatabase.createNewUser(name); // add player with desired name and 0 wins
            playerNames = playerDatabase.getNameArray(); // update player name array
            return true;
        }
        // if player already exists, do nothing
        return false;
    }

    // attempt to remove exisiting player
    public boolean removePlayer(String name) {
        if (playerDatabase.getUserWins(name) != -1) { // if player is in the map
            playerDatabase.removeUser(name); // remove player from list
            playerNames = playerDatabase.getNameArray(); // update player name array
            return true;
        } // if player is not in the map, do nothing
        return false;
    }

    // get String representation of players and their wins
    public String getPlayerListString() {
        String playerList = "";
        for (int i = 0; i < playerNames.length; i++) { // display each player and their wins
            playerList += (i + 1 + ". " + playerNames[i] + ", " + playerDatabase.getUserWins((String) playerNames[i]) + " wins\n");
        }
        return playerList;
    }
    
    // do not allow cloning of class
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
