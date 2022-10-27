
/**
 * Dylan Ghezzi 19078169
 * 24/10/2022
 * Player Sign Up Class
 * PDC Project 2
 */
import java.util.HashMap;
import java.util.Scanner;

public class PlayerSignUp {

    HashMap<String, Integer> players;
    Object playerNames[];

    public PlayerSignUp() {
        players = PlayerIO.playersToHashMap(); // attempt to get players from player_log.txt
    }

    public int main() {
        if (players != null) { // if players are successfully retrieved
            System.out.println("PLAYER SIGN-UP\n");
            Scanner userInput = new Scanner(System.in);
            Integer input = 0;

            while (input != 4) { // repeat until user enters 4
                try {
                    System.out.println("Please enter an option\n1. Display all players\n2. Player Sign-up\n3. Remove Player\n4. Return");
                    input = Integer.parseInt(userInput.nextLine());
                    switch (input) {
                        case 1: // if user enters 1
                            System.out.println("\nPlayer List:");
                            System.out.println(this.getPlayerList());
                            System.out.println("");
                            break;
                        case 2: // if user enters 2
                            while (true) { // repeat until r is entered or input is not blank
                                System.out.println("Please enter name of new player (enter \"r\" to return)");
                                String name = userInput.nextLine();
                                if (name.equalsIgnoreCase("r")) { // if r is entered
                                    break; // return
                                } else if (!name.isBlank()) { // if input is not blank
                                    if (!players.containsKey(name)) { // if player exists in list
                                        players.put(name, 0); // add new player to list with zero wins
                                        System.out.println(name + " has been signed up");
                                    } else { // if player already exists, do nothing
                                        System.out.println("Player already exists");
                                    }
                                    break;
                                } else { // if input is blank
                                    System.out.println("Please enter a valid name");
                                }
                            }
                            break;
                        case 3: // if user enters 3
                            while (true) { // repeat until user enters r or input is not blank
                                System.out.println("Enter the name of the player you would like to remove (enter \"r\" to return)");
                                String name = userInput.nextLine();
                                if (name.equalsIgnoreCase("r")) { // if r is entered
                                    break; // return
                                } else if (!name.isBlank()) { // if input is not blank
                                    System.out.println("Are you sure you want to remove " + name + " from list of players? Y/N");
                                    while (true) { // repeated until y or n is entered
                                        String option = userInput.nextLine();
                                        if (option.equalsIgnoreCase("y")) { // if user enters y
                                            if (players.containsKey(name)) { // if player exists in list
                                                players.keySet().remove(name); // remove player from list
                                                System.out.println(name + " was removed from list of players");
                                            } else { // if player does not exists, do nothing
                                                System.out.println(name + " could not be found in list");
                                            }
                                            break;
                                        } else if (option.equalsIgnoreCase("n")) { // if user enters n, do nothing
                                            break;
                                        } else {
                                            System.out.println("please enter either \"Y\" or \"N\"");
                                        }
                                    }
                                } else {
                                    System.out.println("Please enter a valid name");
                                }
                            }
                            break;
                        case 4: // if user enters 4
                            System.out.println("Exiting Sign-up..."); // exit sign up
                            break;
                        default: // if user enters an invalid option (not between 1 and 4 inclusive)
                            System.out.println("Please enter a valid integer");
                            break;
                    }
                } catch (NumberFormatException e) { // if an integer is not entered
                    System.out.println("Please enter an integer value");
                }
            }
            PlayerIO.updateUsers(players); // update user list to player_log.txt
        } else {
            System.out.println("Players could not be retrieved");
        }
        System.out.println("Returning to Main Menu...");
        return 0; // return to main menu
    }

    public String getPlayerList() {
        playerNames = players.keySet().toArray(); // get array of player names
        String playerList = "";
        for (int i = 0; i < players.size(); i++) { // display each player and their wins
            playerList += (i + 1 + ". " + playerNames[i] + ", " + players.get((String) playerNames[i])+" wins\n");
        }
        
        return playerList;
    }
}
