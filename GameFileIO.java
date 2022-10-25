
/**
 * Dylan Ghezzi 19078169
 * 24/10/2022
 * Game File IO Class
 * PDC Project 2
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class GameFileIO {

    // loads state of previous go fish game
    public static GoFish loadGoFishGameState() {
        try {
            BufferedReader inStream = new BufferedReader(new FileReader("./resources/previous_game_state.txt")); // buffered reader to read text file
            int numPlayers = Integer.parseInt(inStream.readLine()); // read number of players in game
            ArrayList<Player> players = new ArrayList<>(); // create new list of players
            for (int i = 0; i < numPlayers; i++) { // for each player
                players.add(loadPlayer(inStream.readLine(), inStream.readLine())); // read player details and add to list of players
            }
            GoFish game = new GoFish(players); // create new go fish game with loaded players
            inStream.readLine(); // skip line
            loadGameEnvironment(game, inStream.readLine(), inStream.readLine(), inStream.readLine()); // set current turn, fill discarded and stock piles
            inStream.close(); // close stream
            return game; // return go fish game
        } catch (Exception e) {
            System.out.println("Error reading from file previous_game_state.txt");
        }
        return null; // if error reading file, return null
    }

    // gets players attributes from text file create player object with it
    private static Player loadPlayer(String nameAndBooks, String cards) {
        String nameBooks[] = nameAndBooks.split(", "); // read player name and their amount of books
        GoFishPlayer player = new GoFishPlayer(nameBooks[0]); // create new player with name
        player.setBooks(Integer.parseInt(nameBooks[1])); // set their books
        player.setHand(new Hand(getListOfCards(cards))); // adds previous cards to player's hand
        PlayerIO.checkForExistingUser(player); // check for existing user
        return player; // return player
    }

    // gets list of cards from a string of cards
    private static ArrayList<Card> getListOfCards(String line) {
        String cardString[] = line.split(", "); // split into separate cards
        ArrayList<Card> cards = new ArrayList<>(); // new list of cards
        for (String card : cardString) { //  for each card
            if(!card.isEmpty()) {
            String cardParam[] = card.split("_"); // split into suit and ranking
            cards.add(new Card(Suit.valueOf(cardParam[0]), Ranking.valueOf(cardParam[1]))); // create new card of suit and ranking and add to list
            }
        }

        return cards; // return list of cards
    }

    // sets up parameters of go fish game from various strings
    private static void loadGameEnvironment(GoFish game, String currentTurn, String stockPile, String discardedPile) {
        game.setCurrentTurn(Integer.parseInt(currentTurn)); // set current turn of game
        game.getStock().setPile(getListOfCards(stockPile)); // adds previous cards to stock pile
        game.getDiscarded().addCards(getListOfCards(discardedPile)); // adds previous cards to discarded pile

    }

    // saves state of game to previous_game_state.txt
    public static boolean saveGoFishGameState(GoFish game) {
        try {
            PrintWriter outStream = new PrintWriter(new FileWriter("./resources/previous_game_state.txt"));
            outStream.println(game.getPlayers().size()); // save number of players
            for (Player player : game.getPlayers()) { // save each player
                outStream.println(player.getName() + ", " + ((GoFishPlayer) player).getBooks()); // save name of player and their books
                outStream.println(cardsToString(player.getHand().getCards())); // save players cards in hand
            }
            outStream.println(""); // skip a line

            outStream.println(game.getCurrentPlayerTurn() - 1); // save current turn
            outStream.println(cardsToString(game.getStock().getPile())); // save cards in stock pile
            outStream.println(cardsToString(game.getDiscarded().getPile())); // save cards in discarded pile
            outStream.close(); // close stream
            return true; // return true if successful
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading from file player_log.txt");
        }
        return false; // return false if unsuccessful
    }

    // takes a collection of cards and converts them to a string
    public static String cardsToString(Collection<Card> cards) {
        String cardString = "";
        for (Card card : cards) { // for each card
            cardString += card.getSuit().toString() + "_" + card.getRanking().toString() + ", "; // save its suit and its ranking
        }
        if (!cardString.isEmpty()) {
            cardString = cardString.substring(0, cardString.length() - 2);
        }
        return cardString; // return string of all cards
    }

    public static void main(String[] args) {
        GoFish game = loadGoFishGameState();
        System.out.println(game.showPlayerNames());
        System.out.println(game.getCurrentPlayer().getWins());
        System.out.println(game.getCurrentPlayer().getHand().toString());
        System.out.println(((GoFishPlayer) game.getCurrentPlayer()).getBooks());
        System.out.println(game.getDiscarded().toString());
        System.out.println(game.getDiscarded().checkTop().toString());
        System.out.println(game.getStock().toString());
        System.out.println(game.getStock().checkTop().toString());
    }
}
