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
        // TODO: redefine values
        int[] values   = {2,3,4,5,6,7,8,9,10,10,10,10,11};

        this.deck = new Deck(suits, ranks, values);
    }

    public void playGame() {
        printInstructions();
        Scanner sc = new Scanner(System.in);
        this.deck.shuffle();
    }

    private void printInstructions() {
        System.out.println("INSTRUCTIONS: Crazy 8's");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
