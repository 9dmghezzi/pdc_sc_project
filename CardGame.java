
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Card Game Abstract Class
 * PDC Project 2
 */
import java.util.ArrayList;

public abstract class CardGame {

    protected ArrayList<Player> players; // list of players
    protected int currentTurn; // index of current player
    protected Pile stock; // stock pile where players pick up from

    public CardGame(ArrayList<Player> players) {
        this.players = players;
        currentTurn = 0; // start at first player
        stock = new Pile();
        stock.newDeck(); // file stock pile with new deck of 52 cards
    }

    public void setCurrentTurn(int player) {
        currentTurn = player;
    }

    public Pile getStock() {
        return stock;
    }

    public Player getCurrentPlayer() {
        return players.get(currentTurn);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerTurn() {
        return (currentTurn + 1);
    }

    public String getCurrentPlayerCards() {
        return (this.getCurrentPlayer().getHand().toString());
    }

    public String showPlayerNames() {
        String playerString = "";

        for (int i = 1; i <= players.size(); i++) {
            playerString += ("Player " + i + " (" + players.get(i - 1).toString() + ")  ");
        }

        return playerString;
    }

    // go to next Player's turn, in ascending order
    public void nextPlayer() {
        currentTurn++;
        if (currentTurn >= players.size()) { // start back from 0 when all players have had a turn
            currentTurn = 0;
        }
    }

    // abstract method to deal cards
    public abstract void dealCards();
}
