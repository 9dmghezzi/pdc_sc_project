
/**
 * Dylan Ghezzi 19078169
 * 31/10/2022
 * Player database Class
 * PDC Project 2
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerDB {

    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    public PlayerDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    //create player database if it does not already exist
    public void connectPlayerDB() {
        try {
            this.statement = conn.createStatement();
            String tableName = "playerWins";
            if (!checkTableExisting(tableName)) { // if table does not exist
                statement.executeUpdate("CREATE TABLE " + tableName + " (name VARCHAR(20), wins INT)"); // create new table
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // check if table exists in database
    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            if (rsDBMeta != null) { // check each table in database
                while (rsDBMeta.next()) {
                    String tableName = rsDBMeta.getString("TABLE_NAME");
                    if (tableName.compareToIgnoreCase(newTableName) == 0) { // table matches inputted name
                        System.out.println(tableName + "  is there");
                        flag = true; // return true
                    }
                }
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }

    // returns the wins of the inputted user in database
    public int getUserWins(String username) {
        try {
            ResultSet rs = dbManager.queryDB("SELECT name, wins FROM playerWins "
                    + "WHERE name = '" + username + "'");
            if (rs.next()) {
                return rs.getInt("wins"); // return wins of player
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; // if player is not in database, return -1
    }

    // create new user in database
    public void createNewUser(String username) {
        dbManager.updateDB("INSERT INTO playerWins "
                    + "VALUES('" + username + "', 0)"); // create new user with inputted name and wins of 0
    }

    // remove inputted user
    public void removeUser(String username) {
        dbManager.updateDB("DELETE FROM playerWins "
                    + "WHERE name='" + username + "'");
    }

    // updates the wins of the inputted user
    public void updateUserWins(int wins, String username) {
        dbManager.updateDB("UPDATE playerWins SET wins=" + wins + " WHERE name='" + username + "'");
    }

    // return object array of all player names in database
    public Object[] getNameArray() {
        try {
            ArrayList<String> players = new ArrayList<>();
            ResultSet rs = dbManager.queryDB("SELECT name, wins FROM playerWins");
            while (rs.next()) { // for each player in databse
                players.add(rs.getString("name")); // add name to list
            }
            return players.toArray(); // return as object array
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void closeConnection() {
        this.dbManager.closeConnections();
    }
}
