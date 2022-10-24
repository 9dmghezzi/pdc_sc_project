
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Evome
 */
public class Player {

    private String name;
    private Hand hand;
    private int wins;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
        try {
            name = name.trim();
            BufferedReader inStream = new BufferedReader(new FileReader("./resources/player_log.txt")); // buffered reader to read text file
            String line = ""; // string to hold each line of read file
            while (true) { // while the end of the file has not been reached
                line = inStream.readLine(); // read each line from text file
                if (line != null) {
                    String str[] = line.split(" ");
                    if (str[0].contentEquals(name)) { // if exisiting user has been found, load user and their score
                        this.name = str[0];
                        wins = Integer.parseInt(str[1]);
                        break;
                    }
                } else { // if the the name has not been found, create new user with a score of zero
                    this.name = name;
                    wins = 0;
                    break;
                }
            }
            inStream.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading from file player_log.txt");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
    
    public void IncrementWins() {
        wins++;
    }

    public void drawCard(Pile pile) {
        hand.addCard(pile.draw());
    }

    public void drawCards(Pile pile, int numCards) {
        for (int i = 0; i < numCards; i++) {
            hand.addCard(pile.draw());

        }
    }

    public void takeCard(Player opponent, Card card) {
        opponent.getHand().removeCard(card);
        hand.addCard(card);
    }

    public void takeCards(Player opponent, Collection<Card> cards) {
        opponent.getHand().removeCards(cards);
        hand.addCards(cards);
    }

    public void discardCard(Pile pile, Card card) {
        hand.removeCard(card);
        pile.addCard(card);
    }

    public void discardCards(Pile pile, Collection<Card> cards) {
        hand.removeCards(cards);
        pile.addCards(cards);
    }

    public void storeUserScore() {
        // A hashmap for storing <name, score> pairs, where name is the key, and score is the value.
        HashMap<String, Integer> list = new HashMap();
        try {
            // Initialize the BufferedReader, which is used to read contents from scores.txt.
            BufferedReader inStream = new BufferedReader(new FileReader("./resources/player_log.txt"));
            String line = "";
            while ((line = inStream.readLine()) != null) {
                // Split the content of a line by using a white space. E.g., if the content is 'Tom 103', it returns ['Tom','103'].
                String str[] = line.split(" ");
                // Put the pair to the hashmap.
                list.put(str[0], Integer.parseInt(str[1]));
            }
            inStream.close();
            list.put(name, wins); // add new user or update existing user to hash map
            PrintWriter outStream = new PrintWriter(new FileWriter("./resources/player_log.txt"));
            // Iterate all key-value pairs of records, and write them to scores.txt.
            for (Map.Entry<String, Integer> entry : list.entrySet()) {
                outStream.println(entry.getKey() + " " + entry.getValue());
            }
            outStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading from file player_log.txt");
        }

    }

    public int cardCount() {
        return (hand.getCards().size());
    }
    
    @Override
    public String toString() {
        return(name);
    }
}
