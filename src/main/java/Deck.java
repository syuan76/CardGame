import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards;
    int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] values) {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                cards.add(new Card(suits[i], ranks[j], values[j]));
            }
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

    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            int r = (int)(Math.random()*(i+1));
            Card placeholder = cards.get(r);
            cards.set(r, cards.get(i));
            cards.set(i, placeholder);
        }
    }
}
