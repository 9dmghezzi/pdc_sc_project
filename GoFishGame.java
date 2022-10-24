
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Evome
 */
public class GoFishGame {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("GO FISH GAME");
        ArrayList<Player> players = new ArrayList<>();
        int numberOfPlayers;
        while (true) {
            try {
                System.out.println("How many players are there?");
                numberOfPlayers = userInput.nextInt();
                if (numberOfPlayers >= 2 && numberOfPlayers <= 5) {
                    break;
                }
                System.out.println("There can be 2 players minimum, and 5 players maximum");
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer value");
                userInput.next();
            }
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + (i + 1) + " name: ");
            String name = userInput.next();
            players.add(new Player(name));
        }

        GoFish goFishGame = new GoFish(players);
        goFishGame.dealCards();
        for (int i = 0; i < goFishGame.getNumberOfPlayers(); i++) {
            if (goFishGame.checkForBook(goFishGame.getCurrentPlayer())) {
                System.out.println("LUCKY!");
                System.out.println("Player " + goFishGame.getCurrentPlayerTurn() + " has collected a book of " + goFishGame.getDiscardedPile().getPile().peek() + "s");
            }
            goFishGame.nextPlayer();
        }

        while (!goFishGame.roundFinished()) {
            int fishFromPlayer;
            int fishCard;
            int oldCardCount = goFishGame.getCurrentPlayer().cardCount();

            System.out.println("\nPlayer " + goFishGame.getCurrentPlayerTurn() + " (" + goFishGame.getCurrentPlayer().toString() + ") Turn:");
            System.out.println("Your Hand:\n" + goFishGame.getCurrentPlayerCards());
            while (true) {
                try {
                    System.out.println("Which card do you want to fish for?");
                    fishCard = userInput.nextInt();
                    if (fishCard >= 1 && fishCard <= goFishGame.getCurrentPlayer().cardCount()) {
                        break;
                    }
                    System.out.println("Please enter a card from your hand (enter integer from 1 to " + goFishGame.getCurrentPlayer().cardCount() + ")");
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer value");
                    userInput.next();
                }
            }

            System.out.println(goFishGame.currentPlayersToString());
            while (true) {
                try {
                    System.out.println("What player do you want to fish from?");
                    fishFromPlayer = userInput.nextInt();
                    if (fishFromPlayer != goFishGame.getCurrentPlayerTurn()) {
                        if (fishFromPlayer >= 1 && fishFromPlayer <= goFishGame.getNumberOfPlayers()) {
                            break;
                        } else {
                            System.out.println("Please enter a valid player (enter integer from 1 to " + goFishGame.getNumberOfPlayers() + ")");
                        }
                    } else {
                        System.out.println("Please enter a player other than yourself");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer value");
                    userInput.next();
                }
            }

            if (goFishGame.fish(fishFromPlayer, fishCard)) {
                System.out.println("Caught " + (goFishGame.getCurrentPlayer().cardCount() - oldCardCount) + " " + goFishGame.getCurrentPlayer().getHand().getCards().get(fishCard - 1).getRanking().toString() + "s from player " + fishFromPlayer);
            } else {
                System.out.println("GO FISH!");
                if(goFishGame.getStockPile().getPile().empty())
                    System.out.println("Stock Pile is empty");
                else
                    System.out.println("Picked up " + goFishGame.getCurrentPlayer().getHand().getCards().get(goFishGame.getCurrentPlayer().cardCount() - 1).toString());
            }

            if (goFishGame.checkForBook(goFishGame.getCurrentPlayer())) {
                System.out.println("Book of " + goFishGame.getDiscardedPile().getPile().peek().getRanking().toString() + "s has been collected");
                System.out.println("You now have " + goFishGame.getCurrentPlayerBooks() + " Books");
            }
            System.out.println("Your Hand is now:\n" + goFishGame.getCurrentPlayerCards());

            goFishGame.nextPlayer();
        }
        
        goFishGame.checkHighestBooks();
        goFishGame.storeUserScores();
    }
}
