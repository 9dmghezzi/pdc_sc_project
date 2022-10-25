
/**
 * Dylan Ghezzi 19078169
 * 18/10/2022
 * Go Fish Player Class
 * PDC Project 2
 */
public class GoFishPlayer extends Player {

    private int books; // amount of matching books player has collected

    public GoFishPlayer(String name) {
        super(name);
        books = 0; // initially set to zero
    }

    public void incrementBooks() {
        books++;
    }

    public int getBooks() {
        return books;
    }
    
    public void setBooks(int books) {
        this.books = books;
    }
}
