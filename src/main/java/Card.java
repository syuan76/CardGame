import java.awt.*;

public class Card {
    // Instance variables
    private String suit;
    private String rank;
    private int value;
    private Image image;

    // Constructor
    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    // Getters
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public Image getImage() {
        return image;
    }

    // Setters
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
