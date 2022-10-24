
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Evome
 */
public class GoFish {

    private ArrayList<Player> currentPlayers;
    private int[] playerBooks;
    private Pile stock;
    private Pile discarded;
    private int currentTurn;

    public GoFish(ArrayList<Player> players) {
        currentPlayers = players;
        playerBooks = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            playerBooks[i] = 0;
        }
        currentTurn = 0;
        stock = new Pile();
        discarded = new Pile();
        for (Ranking r : Ranking.values()) {
            for (Suit s : Suit.values()) {
                stock.addCard(new Card(s, r));
            }
        }
    }

    public void dealCards() {
        stock.shuffle();

        switch (currentPlayers.size()) {
            case 2, 3 -> {
                for (int i = 0; i < 7; i++) {
                    for (Player player : currentPlayers) {
                        player.drawCard(stock);
                    }
                }
            }
            case 4, 5 -> {
                for (int i = 0; i < 5; i++) {
                    for (Player player : currentPlayers) {
                        player.drawCard(stock);
                    }
                }
            }
            default -> {
                break;
            }

        }
    }

    public void reset() {
        stock.addCards(discarded.drawAll());
    }

    public void nextPlayer() {
        currentTurn++;
        if (currentTurn >= currentPlayers.size()) {
            currentTurn = 0;
        }
    }

    public boolean fish(int opponent, int card) {

        boolean fishSuccess = false;

        ArrayList<Card> matching = new ArrayList<>();

        for (Card opponentCard : currentPlayers.get(opponent - 1).getHand().getCards()) {
            if (opponentCard.getRanking().equals(currentPlayers.get(currentTurn).getHand().getCards().get(card-1).getRanking())) {
                fishSuccess = true;
                matching.add(opponentCard);
            }
        }

        if (fishSuccess) {
            currentPlayers.get(currentTurn).takeCards(currentPlayers.get(opponent - 1), matching);
        } else {
            if (!stock.getPile().empty()){
                currentPlayers.get(currentTurn).drawCard(stock);
            }
        }

        return fishSuccess;
    }

    public boolean checkForBook(Player player) {

        boolean bookFound = false;
        ArrayList<Card> matching = new ArrayList<>();

        for (Ranking ranking : Ranking.values()) {
            for (Card card : player.getHand().getCards()) {
                if (card.getRanking().equals(ranking)) {
                    matching.add(card);
                }
            }
            if (matching.size() >= 4) {
                bookFound = true;
                player.discardCards(discarded, matching);
                playerBooks[currentPlayers.indexOf(player)]++;
                break;
            }
            matching.clear();
        }
        
        return bookFound;
    }

    public boolean roundFinished() {
        return (discarded.size() >= 52);
    }

    public int getCurrentPlayerTurn() {
        return (currentTurn + 1);
    }

    public String getCurrentPlayerCards() {
        return (currentPlayers.get(currentTurn).getHand().toString());
    }
    
    public String currentPlayersToString() {
        String players = "";
        
        for(int i = 1; i <= currentPlayers.size(); i++) {
            players += ("Player "+i+" ("+currentPlayers.get(i-1).toString()+")  ");
        }
        
        return players;
    }

    public int getNumberOfPlayers() {
        return currentPlayers.size();
    }

    public Player getCurrentPlayer() {
        return currentPlayers.get(currentTurn);
    }
    
    public int getCurrentPlayerBooks() {
        return playerBooks[currentTurn];
    }
    
    public Pile getDiscardedPile() {
        return discarded;
    }
    
    public Pile getStockPile() {
        return stock;
    }
    
    public void checkHighestBooks() {
        int highest = playerBooks[0];
        Player highestPlayer = currentPlayers.get(0);
        
        for(int i=0; i < playerBooks.length; i++) {
            if(playerBooks[i] > highest) {
                highest = playerBooks[i];
                highestPlayer = currentPlayers.get(i);
            }
        }
        
        highestPlayer.IncrementWins();
    }
    
    public void storeUserScores() {
        for(Player player: currentPlayers) {
            player.storeUserScore();
        }
    }
}
