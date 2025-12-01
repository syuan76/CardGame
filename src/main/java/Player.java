import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    // Instance variables
    private String name;
    private ArrayList<Card> hand;
    private int points;

    // Constructor that takes in a name
    public Player(String name) {
        this.name = name;
        points = 0;
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

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    // Method work in progress
    public Card playCard(Card card) {
        Scanner sc = new Scanner(System.in);
        System.out.println(name + ", please choose a card to play (enter the index of a card in your hand): ");
        return card;
    }

    public String toString() {
        return name + " has " + points + "\n" + name + "'s cards: " + hand;
    }
}
