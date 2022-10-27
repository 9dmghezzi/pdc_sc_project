
/**
 * Dylan Ghezzi 19078169
 * 25/10/2022
 * Card Game Main Menu -  main method
 * PDC Project 2
 */
import java.util.Scanner;

public class CardGameMainMenu {

    public static void main(String[] args) {
        System.out.println("CARD GAME MAIN MENU\n");
        Scanner menuInput = new Scanner(System.in);
        while (true) { // repeat until valid input is given
            try {
                System.out.println("Please enter an option");
                System.out.println("1. Player Sign-up\n2. Go Fish Game\n3. Quit");
                Integer input = Integer.parseInt(menuInput.nextLine());
                switch (input) {
                    case 1: // if 1 is entered
                        PlayerSignUp signUp = new PlayerSignUp();
                        signUp.main(); // enter player sign-up
                        break;
                    case 2: // if 2 is entered
                        GoFishGame.GoFishGame(); // enter go fish game
                        break;
                    case 3: // if 3 is entered
                        System.out.println("Quitting.."); // quit menu
                        System.exit(0); // exit program
                    default:
                        System.out.println("Please enter a valid integer"); // if integer is not valid (within range)
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer value"); // if an integer is not given
            }
        }
    }
}
