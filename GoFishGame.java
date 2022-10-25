
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Go Fish Main Method
 * PDC Project 2
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame {

    public static int GoFishGame() {

        System.out.println("GO FISH GAME\nEnter q at any time to quit\n");
        Scanner userInput = new Scanner(System.in);
        String input = "";
        GoFish goFishGame = null;
        while (!input.equalsIgnoreCase("q")) { // repeat until user enters, y, n, or q
            System.out.println("Would you like to resume the previous game? Y/N");
            input = userInput.nextLine();
            if (input.equalsIgnoreCase("q")) { // if user enters "q" skip to end and quit game
                System.out.println("Game Ending...");
                break;
            } else if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("Please enter either \"Y\" or \"N\"");
        }
        if (input.equalsIgnoreCase("n")) { // if user enters n, create new go fish game
            ArrayList<Player> players = new ArrayList<>();
            int numberOfPlayers = 0;

            while (!input.equalsIgnoreCase("q")) { // repeat until user enters, q, or an integer between 2 and 5 (inclusive)
                try {
                    System.out.println("How many players are there?");
                    input = userInput.nextLine();
                    if (input.equalsIgnoreCase("q")) {
                        System.out.println("Game Ending...");
                        break;
                    }
                    numberOfPlayers = Integer.parseInt(input);
                    if (numberOfPlayers >= 2 && numberOfPlayers <= 5) {
                        break;
                    }
                    System.out.println("There can be 2 players minimum, and 5 players maximum");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter an integer value");
                }
            }
            if (!input.equalsIgnoreCase("q")) { // skip if user entered q
                for (int i = 0; i < numberOfPlayers; i++) { // for each player
                    System.out.println("Player " + (i + 1) + " name: "); // ask for player name
                    input = userInput.nextLine();
                    if (input.equalsIgnoreCase("q")) {
                        System.out.println("Game Ending...");
                        break;
                    }
                    GoFishPlayer player = new GoFishPlayer(input);
                    if (PlayerIO.checkForExistingUser(player)) { // check if enter user exists
                        System.out.println("User Found! Total Wins loaded: " + player.getWins()); // if they exist, load their wins
                    } else {
                        System.out.println("New user has been created"); // if the don't, create new user
                    }
                    players.add(player); // add to list of players
                }
            }
            if (!input.equalsIgnoreCase("q")) { // skip if user entered q
                goFishGame = new GoFish(players); // create new game with entered players

                goFishGame.dealCards(); // deal cards to all players
                for (Player player : goFishGame.getPlayers()) { // for each player
                    if (goFishGame.checkForBook(((GoFishPlayer) player))) { // check if a matching book was dealt to them
                        System.out.println("LUCKY!");
                        System.out.println("Player " + goFishGame.getCurrentPlayerTurn() + " has collected a book of " + goFishGame.getDiscarded().checkTop().toString() + "s");
                    }
                    goFishGame.nextPlayer();
                }
            }
        } else { // if user enters y to load game state, load game state
            goFishGame = GameFileIO.loadGoFishGameState(); // attempt to load game state
            if (goFishGame == null) { // if loading game state fails
                System.out.println("Error loading Game State"); 
                return 0; // exit game and return to main menu
            }
        }
        if (!input.equalsIgnoreCase("q")) { // if user has entered "q" skip game
            while (!goFishGame.roundFinished()) { // repeat until round is finished or all cards are discarded
                int fishFromPlayer = 0;
                int fishCard = 0;
                int oldCardCount = goFishGame.getCurrentPlayer().cardCount(); // card count of current player as round starts

                System.out.println("\nPlayer " + goFishGame.getCurrentPlayerTurn() + " (" + goFishGame.getCurrentPlayer().toString() + ") Turn:");
                System.out.println("Your Hand:\n" + goFishGame.getCurrentPlayerCards()); // display current players hand
                while (!input.equalsIgnoreCase("q")) { // repeat until user enters q or a valid integer
                    try {
                        System.out.println("Which card do you want to fish for?");
                        input = userInput.nextLine();
                        if (input.equalsIgnoreCase("q")) {
                            System.out.println("Game Ending...");
                            break;
                        }
                        fishCard = Integer.parseInt(input);
                        if (fishCard >= 1 && fishCard <= goFishGame.getCurrentPlayer().cardCount()) { // if a valid integer is entered or card in hand is chosen, continue
                            break;
                        }
                        System.out.println("Please enter a card from your hand (enter integer from 1 to " + goFishGame.getCurrentPlayer().cardCount() + ")");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter an integer value");
                    }
                }
                while (!input.equalsIgnoreCase("q")) { // repeat until user enters q or a valid integer
                    try {
                        System.out.println(goFishGame.showPlayerNames());
                        System.out.println("What player do you want to fish from?");
                        input = userInput.nextLine();
                        if (input.equalsIgnoreCase("q")) {
                            System.out.println("Game Ending...");
                            break;
                        }
                        fishFromPlayer = Integer.parseInt(input);
                        if (fishFromPlayer != goFishGame.getCurrentPlayerTurn()) { // if user enters a player other than themselves
                            if (fishFromPlayer >= 1 && fishFromPlayer <= goFishGame.getPlayers().size()) { // if user enters a user currently in the game , continue
                                break;
                            } else {
                                System.out.println("Please enter a valid player (enter integer from 1 to " + goFishGame.getPlayers().size() + ")");
                            }
                        } else {
                            System.out.println("Please enter a player other than yourself");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter an integer value");
                    }
                }
                if (!input.equalsIgnoreCase("q")) { // skip if user entered q
                    if (goFishGame.fishFromPlayer(goFishGame.getPlayers().get(fishFromPlayer - 1), goFishGame.getCurrentPlayer().getHand().getCards().get(fishCard - 1))) { // attempt to fish chosen card from chosen player
                        System.out.println("Caught " + (goFishGame.getCurrentPlayer().cardCount() - oldCardCount) + " " + goFishGame.getCurrentPlayer().getHand().getCards().get(fishCard - 1).getRanking().toString() + "s from player " + fishFromPlayer); // if fish was successful display how many cards were caught
                    } else { // if fish was unsuccessful, attempt to draw card from stock pile
                        System.out.println("GO FISH!");
                        goFishGame.goFish();
                        if (goFishGame.getStock().getPile().empty()) { // if stock pile is empty
                            System.out.println("Stock Pile is empty");
                        } else { // if card was picked up, display picked up card
                            System.out.println("Picked up " + goFishGame.getCurrentPlayer().getHand().getCards().get(goFishGame.getCurrentPlayer().cardCount() - 1).toString());
                        }
                    }

                    if (goFishGame.checkForBook(goFishGame.getCurrentPlayer())) { // check player hand for any matching books
                        // if matching books was found, display of which ranking, and how many books the player currently has
                        System.out.println("Book of " + goFishGame.getDiscarded().getPile().peek().getRanking().toString() + "s has been collected");
                        System.out.println("You now have " + ((GoFishPlayer) goFishGame.getCurrentPlayer()).getBooks() + " Books");
                    }
                    System.out.println("Your Hand is now:\n" + goFishGame.getCurrentPlayerCards()); // display new hand of current player

                    goFishGame.nextPlayer(); // move onto next player
                } else { // if user entered q
                    while (true) { // repeat until y or n is enterd
                        System.out.println("Would you like to save the current game? Y/N");
                        input = userInput.nextLine();
                        if (input.equalsIgnoreCase("y")) { // if y was entered, attempt to save game state
                            if (GameFileIO.saveGoFishGameState(goFishGame) == true) {
                                System.out.println("Game saved successfully");
                            } else {
                                System.out.println("Could not save game");
                            }
                            break;
                        } else if (input.equalsIgnoreCase("n")) { // if n was entered, skip to end
                            break;
                        }
                        System.out.println("Please enter either \"Y\" or \"N\"");
                    }
                    break;
                }
            }
        }
        if (!input.equalsIgnoreCase("q")) { // skip if user entered q
            if (goFishGame.roundFinished()) { // if game's round finished
                System.out.println("Round finished");
                GoFishPlayer highestPlayer = goFishGame.checkHighestBooks(); // check for player with highest amount of books
                PlayerIO.updateUserWins(goFishGame.getPlayers()); // update player wins
                System.out.println(highestPlayer.getName() + " has won with " + highestPlayer.getBooks() + " books!"); // display winning player
            }
        }
        System.out.println("Returning to main menu...");
        return 1; // return to main menu
    }

}
