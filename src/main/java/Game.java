// Crazy 8's Card Game by Serena Yuan

import java.util.Scanner;

public class Game {
    // Instance variables
    private Player player1;
    private Player player2;
    private Deck deck;
    private Card topCard;

    // Constructor
    public Game() {
        this.player1 = new Player("1");
        this.player2 = new Player("2");

        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        int[] values   = {2,3,4,5,6,7,8,9,10,10,10,10,11};

        this.deck = new Deck(suits, ranks, values);
    }

    public void playGame() {
        printInstructions();
        Scanner sc = new Scanner(System.in);
        this.deck.shuffle();
        getPlayerNames();
        dealCards();
    }

    private void printInstructions() {
        System.out.println("INSTRUCTIONS: Crazy 8's");
    }

    public void getPlayerNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1, please enter your name: ");
        this.player1.setName(sc.nextLine());
        System.out.println("Player 2, please enter your name: ");
        this.player2.setName(sc.nextLine());
    }

    // To start the game, each player is dealt 8 cards
    public void dealCards() {
        for (int i = 0; i < 8; i++) {
            player1.addCard(deck.deal());
            player2.addCard(deck.deal());
        }
    }

    // Returns true if the card "matches" the top card
    public boolean isValid(Card card) {
        return card.getSuit().equals(topCard.getSuit()) || card.getRank().equals(topCard.getRank());
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
