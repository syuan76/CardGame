import java.util.ArrayList;

public class Player {
    // Instance variables
    private String name;
    private ArrayList<Card> hand;
    private int points;
    // failedDraw will be true when the player has attempted to draw from an empty deck. When failedDraw is true for both players, I will end the game because that means neither player can make progress anymore.
    private boolean failedDraw;

    // Constructor that takes in a name
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        points = 0;
        failedDraw = false;
    }

    // Constructor that takes in a name and hand of cards
    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public boolean isFailedDraw() {
        return failedDraw;
    }

    public void setFailedDraw(boolean failedDraw) {
        this.failedDraw = failedDraw;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public String toString() {
        return name + " has " + points + "\n" + name + "'s cards: " + hand;
    }
}
