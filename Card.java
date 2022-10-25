/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Card Class
 * PDC Project 2
 */
public class Card {

    private final Suit suit;
    private final Ranking ranking;
    
    public Card(Suit suit, Ranking ranking)
    {
        this.suit = suit;
        this.ranking = ranking;
    }

    public Suit getSuit() {
        return suit;
    }

    public Ranking getRanking() {
        return ranking;
    }
    
    @Override
    public String toString() {
        return (ranking.toString()+" of "+suit.toString());
    }
}
