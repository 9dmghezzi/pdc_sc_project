
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Hand Class
 * PDC Project 2
 */
import java.util.ArrayList;
import java.util.Collection;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addCards(Collection<Card> cards) {
        this.cards.addAll(cards);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public Card removeCard(int index) {
        return (cards.remove(index));
    }

    public void removeCards(Collection<Card> cards) {
        this.cards.removeAll(cards);
    }

    @Override
    public String toString() {

        String cardList = "";

        for (int i = 0; i < cards.size(); i++) {
            cardList += ((i + 1) + "." + cards.get(i).toString() + "  ");
        }

        return cardList;
    }
}
