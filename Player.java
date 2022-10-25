
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Abstract Player Class
 * PDC Project 2
 */
import java.util.Collection;

public abstract class Player {

    private String name;
    private Hand hand;
    private int wins;

    public Player(String name) {
        this.name = name;
        wins = 0;
        hand = new Hand();
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

    // craw card from pile
    public void drawCard(Pile pile) {
        hand.addCard(pile.draw());
    }

    // draw many cards from pile
    public void drawCards(Pile pile, int numCards) {
        for (int i = 0; i < numCards; i++) {
            this.drawCard(pile);
        }
    }

    // take card from opponent
    public void takeCard(Player opponent, Card card) {
        opponent.getHand().removeCard(card);
        hand.addCard(card);
    }

    // take many cards from opponent
    public void takeCards(Player opponent, Collection<Card> cards) {
        opponent.getHand().removeCards(cards);
        hand.addCards(cards);
    }

    // discard card to pile
    public void discardCard(Pile pile, Card card) {
        hand.removeCard(card);
        pile.addCard(card);
    }

    // discard many cards to pile
    public void discardCards(Pile pile, Collection<Card> cards) {
        hand.removeCards(cards);
        pile.addCards(cards);
    }

    // get number of cards in player's hand
    public int cardCount() {
        return (hand.getCards().size());
    }

    @Override
    public String toString() {
        return (name);
    }
}
