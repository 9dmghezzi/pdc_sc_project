
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Evome
 */
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
        
        int pileSize = pile.size();
        for(int i = 0; i < pileSize; i++) {
            drawedCards.add(pile.pop());
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

    public void shuffle() {
        Collections.shuffle(pile);
    }

    public int size() {
        return pile.size();
    }
}
