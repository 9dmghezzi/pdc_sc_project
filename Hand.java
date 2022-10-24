
import java.util.ArrayList;
import java.util.Collection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Evome
 */
public class Hand {

    private ArrayList<Card> cards;
    
    public Hand() {
        cards = new ArrayList<>();
    }
    
    public ArrayList<Card> getCards()
    {
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
        return(cards.remove(index));
    }
    
    public void removeCards(Collection<Card> cards) {
        this.cards.removeAll(cards);
    }
    
    @Override
    public String toString() {
        
        String cardList = "";
        
        for(int i = 0; i < cards.size(); i++) {
            cardList += ((i+1)+"."+cards.get(i).toString()+"  ");
        }
        
        return cardList;
    }
}
