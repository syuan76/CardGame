public class Card {
    // Instance variables
    private String suit;
    private String rank;
    private int value;

    // Constructor
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
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

    public String toString() {
        return rank + " of " + suit;
    }
}
