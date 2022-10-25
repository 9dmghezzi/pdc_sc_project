
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Pile Class
 * PDC Project 2
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Pile {

    private Stack<Card> pile;

    public Pile() {
        pile = new Stack<>();
    }

    public Pile(Stack deck) {
        pile = deck;
    }

    public Card draw() {
        return (pile.pop());
    }

    public Collection<Card> drawAll() {
        Stack drawedCards = new Stack();

        for (int i = 0; i < this.size(); i++) {
            drawedCards.push(pile.pop());
        }

        return drawedCards;
    }

    public void addCard(Card card) {
        pile.push(card);
    }

    public void addCards(Collection<Card> cards) {
        pile.addAll(cards);
    }

    public Stack<Card> getPile() {
        return pile;
    }

    public void setPile(Stack<Card> pile) {
        this.pile = pile;
    }

    public void setPile(ArrayList<Card> cards) {
        pile.clear();
        pile.addAll(cards);
    }

    public void shuffle() {
        Collections.shuffle(pile);
    }

    public int size() {
        return pile.size();
    }

    public Card checkTop() {
        return pile.peek();
    }

    // create new deck of 52 cards
    public void newDeck() {
        pile.clear(); // empty pile
        for (Ranking r : Ranking.values()) { // for each ranking
            for (Suit s : Suit.values()) { // for each suit
                this.addCard(new Card(s, r)); // add new card
            }
        }
    }

    @Override
    public String toString() {

        String cardList = "";

        for (int i = 0; i < pile.size(); i++) {
            cardList += ((i + 1) + "." + pile.get(i).toString() + "  ");
        }

        return cardList;
    }
}
