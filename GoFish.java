
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Go Fish Game Class
 * PDC Project 2
 */
import java.util.ArrayList;

public class GoFish extends CardGame {

    private Pile discarded; // discarded pile for books of cards to be put away

    public GoFish(ArrayList<Player> players) throws IllegalArgumentException {
        super(players);
        if (players.size() >= 2 && players.size() <= 5) { // if amount of players are within bounds
            discarded = new Pile();
        } else { // if there are less than two players or more than 5
            throw new IllegalArgumentException(); // throw exception
        }
    }
    
    public Pile getDiscarded() {
        return discarded;
    }

    // deal cards to all players
    @Override
    public void dealCards() {
        stock.shuffle(); // shuffle stock pile
        switch (this.getPlayers().size()) {
            case 2, 3 -> { // if there are two or three players
                for (int i = 0; i < 7; i++) { // give each player seven cards from the deck
                    for (Player player : players) {
                        player.drawCard(stock);
                    }
                }
            }
            case 4, 5 -> { // if there are four or five players
                for (int i = 0; i < 5; i++) { // give each player five cards from the deck
                    for (Player player : players) {
                        player.drawCard(stock);
                    }
                }
            }
        }
    }

    // moves all cards back to stock pile so that all players have empty hands and discarded pile is empty
    public void resetGame() {
        for (Player player : players) { // for each player in the game
            player.discardCards(stock, player.getHand().getCards()); // put all cards in stock pile
            ((GoFishPlayer) player).setBooks(0); // reset amount of books to zero
        }
        stock.addCards(discarded.drawAll()); // move cards in discarded pile to stock pile
    }

    // attempt to fish cards from opponent
    public boolean fishFromPlayer(Player opponent, Card card) {
        boolean fishSuccess = false; // assume unsuccessful fish
        ArrayList<Card> matching = new ArrayList<>(); // list of matching cards

        for (Card opponentCard : opponent.getHand().getCards()) { // for each card in the opponents hand
            if (opponentCard.getRanking().equals(card.getRanking())) { // if the ranking of the opponent's card equals the desired card's ranking
                fishSuccess = true; // set success to true
                matching.add(opponentCard); // add card to list of matching cards
            }
        }
        if (fishSuccess) { // if fish was successful
            this.getCurrentPlayer().takeCards(opponent, matching); // take matching cards from opponent
        }

        return fishSuccess; // return the success of fish
    }

    // take a card from the stock pile if it is not empty
    public void goFish() {
        if (!stock.getPile().empty()) {
            this.getCurrentPlayer().drawCard(stock);
        }
    }

    // check players hand for a book of four cards
    public boolean checkForBook(Player player) {
        boolean bookFound = false;
        ArrayList<Card> matching = new ArrayList<>(); // list of matching cards

        for (Ranking ranking : Ranking.values()) { // for each ranking of card
            for (Card card : player.getHand().getCards()) { // for each card in the player's hand
                if (card.getRanking().equals(ranking)) { // if the ranking matches
                    matching.add(card); // add the list of matching cards
                }
            }
            if (matching.size() >= 4) { // if the amount of cards with the same rank is four
                bookFound = true; // set book found to true
                player.discardCards(discarded, matching); // discard matching cards to discarded pile
                ((GoFishPlayer) player).incrementBooks(); // increase the amount of books for the player to 1
                break; // stop checking and return true
            }
            matching.clear(); // clear list of matching cards and repeat for next card rank
        }

        return bookFound;
    }

    // round is finished when all cards end up in the discarded pile
    public boolean roundFinished() {
        return (discarded.size() >= 52);
    }

    // check which player has the highest amount of books
    public GoFishPlayer checkHighestBooks() {
        int highest = ((GoFishPlayer) players.get(0)).getBooks(); // set highest books to first player
        Player highestPlayer = players.get(0);

        for (Player player : players) { // for each player
            if (((GoFishPlayer) player).getBooks() > highest) { // if the player has more books than the previous highest
                highest = ((GoFishPlayer) player).getBooks(); // make player the new highest books
                highestPlayer = player;
            }
        }

        highestPlayer.IncrementWins(); // increase the wins of the highest player by one
        return (GoFishPlayer) highestPlayer;
    }
}
