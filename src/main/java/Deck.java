import javax.swing.*;
import java.util.ArrayList;

public class Deck {
    // Instance variables
    private ArrayList<Card> cards;
    private int cardsLeft;

    // Constructor
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();

        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cards.add(new Card(ranks[i], suits[j], values[j]));
            }
        }

        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).setImage(new ImageIcon("src/main/resources/" + (i+1) + ".png").getImage());
        }
        cardsLeft = cards.size();
    }

    public boolean isEmpty() {
        if (cardsLeft == 0) {
            return true;
        }
        return false;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card deal() {
        if (cards.isEmpty()) {
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }

    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            // CONTENT STANDARD: Can use Math class, especially Math.random().
            int r = (int)(Math.random()*(i+1));
            Card placeholder = cards.get(r);
            cards.set(r, cards.get(i));
            cards.set(i, placeholder);
        }
    }
}
