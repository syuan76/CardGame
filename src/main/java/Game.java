// Crazy 8's Card Game by Serena Yuan

import java.util.Scanner;

public class Game {
    // Instance variables
    private Player player1;
    private Player player2;
    private Deck deck;
    private Card topCard;

    private GameView window;

    // Constructor
    public Game() {
        // CONTENT STANDARD: Declare, initialize and assign a value to a variable, be it a primitive or object.
        this.player1 = new Player("1");
        this.player2 = new Player("2");

        this.window = new GameView(this);

        String[] ranks = {"A", "2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] values   = {2,3,4,5,6,7,8,9,10,10,10,10,11};

        this.deck = new Deck(ranks, suits, values);
    }

    public void playGame() {
        printInstructions();
        this.deck.shuffle();
        getPlayerNames();
        dealCards();
        topCard = deck.deal();

        while (true) {
            takeTurn(player1);
            if (ifGameOver()) {
                break;
            }
            takeTurn(player2);
            if (ifGameOver()) {
                break;
            }
        }

        printWinner();
    }

    private void printInstructions() {
        printSeparator();
        System.out.println("CRAZY 8'S");
        printSeparator();
        System.out.println("INSTRUCTIONS: Try to get rid of all your cards! This is a two-player card game. To start, each player is dealt 7 cards.");
        System.out.println("- You can play any card of the same suit as the Top Card.");
        System.out.println("- You can play any card of the same rank as the Top Card.");
        System.out.println("- You can always play an 8, and then you can change the suit to whatever you want.");
        System.out.println("- If you have no valid card to play, you can draw up to 3 cards from the deck. You can't draw if you have any cards that you can play in your hand. If you've drawn 3 cards and still can't play you must pass and the next player plays.");
        System.out.println("- If the deck is empty and neither player can make anymore progress, the game is over and the winner is determined by the player with the least amount of cards in their hand.");
        System.out.println("First to get rid of all their cards wins. Good luck, and have fun!");
        printSeparator();
    }

    private void printSeparator() {
        System.out.println("******************************");
    }

    public void getPlayerNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1, please enter your name: ");
        this.player1.setName(sc.nextLine());
        System.out.println("Player 2, please enter your name: ");
        this.player2.setName(sc.nextLine());
    }

    // To start the game, each player is dealt 7 cards
    public void dealCards() {
        for (int i = 0; i < 7; i++) {
            player1.addCard(deck.deal());
            player2.addCard(deck.deal());
        }
    }

    // Returns true if the card "matches" the top card or if its rank is 8
    public boolean isValid(Card card) {
        return card.getRank().equals("8") || card.getSuit().equals(topCard.getSuit()) || card.getRank().equals(topCard.getRank());
    }

    // Prints the current player's hand and displays corresponding indexes
    public void showHand(Player p) {
        System.out.println(p.getName() + "'s hand:");
        for (int i = 0; i < p.getHand().size(); i++) {
            System.out.println("[" + i + "] " + p.getHand().get(i));
        }
    }

    // Checks if the player's hand contains a valid card to play
    public boolean containsValidCard(Player p) {
        for (int i = 0; i < p.getHand().size(); i++) {
            if (isValid(p.getHand().get(i))) {
                return true;
            }
        }
        return false;
    }

    // Method for the player to draw a card from the deck
    public void drawCard(Player p) {
        p.getHand().add(deck.deal());
    }

    // Method for when the player plays an 8 (wildcard)
    public void playEight() {
        // CONTENT STANDARD: Can use if, while, and for.
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Since you have played an 8, you may choose to change the suit. Change the suit to Hearts, Clubs, Diamonds, or Spades (case sensitive!): ");
            String input = sc.nextLine();
            if (input.equals("Hearts") || input.equals("Clubs") || input.equals("Diamonds") || input.equals("Spades")) {
                topCard.setSuit(input);
                topCard.setRank("8");
                return;
            } else {
                System.out.println("Please enter a valid suit.");
            }
        }
    }

    public void takeTurn(Player p) {
        Scanner sc = new Scanner(System.in);

        printSeparator();
        System.out.println(p.getName() + "'s Turn");
        System.out.println("Top card: " + topCard);
        showHand(p);
        String input;
        // numDraws keeps track of how many times a player has drawn in one round
        int numDraws = 0;
        int index;
        Card chosen;
        // CONTENT STANDARD: Can use if, while, and for.
        while (!containsValidCard(p)) {
            if (numDraws == 3) {
                System.out.println("You have now drawn 3 times in a row, so we will skip your turn.");
                return;
            }
            System.out.println("You do not have any valid cards in your hand to play. Please type 'd' to draw from the deck.");
            input = sc.nextLine();
            if (input.equals("d")) {
                if (!deck.isEmpty()) {
                    drawCard(p);
                    numDraws++;
                } else {
                    System.out.println("The deck has run out of cards to draw.");
                    p.setFailedDraw(true);
                    return;
                }
            } else {
                continue;
            }
            System.out.println("Top Card: " + topCard);
            showHand(p);
        }
        while (true) {
            System.out.println("Enter the index of the card you would like to play: ");
            index = sc.nextInt();
            if (index < 0 || index >= p.getHand().size()) {
                System.out.println("Invalid index. Try again!");
                continue;
            }
            chosen = p.getHand().get(index);
            if (chosen.getRank().equals("8")) {
                playEight();
                break;
            } else if (!isValid(chosen)) {
                System.out.println("You cannot play this card. Choose a matching suit or rank.");
            } else {
                topCard = chosen;
                break;
            }
        }
        p.getHand().remove(index);
    }

    public boolean ifGameOver() {
        return player1.getHand().isEmpty() || player2.getHand().isEmpty() || player1.isFailedDraw() && player2.isFailedDraw();
    }

    public void printWinner() {
        if (player1.getHand().isEmpty()) {
            System.out.println(player1.getName() + " won!");
        } else if (player2.getHand().isEmpty()) {
            System.out.println(player2.getName() + " won!");
        } else if (deck.isEmpty()) {
            System.out.println("The deck is empty and neither player can make progress anymore! The winner will be the one with the smallest number of cards in their hand.");
            if (player1.getHand().size() > player2.getHand().size()) {
                System.out.println(player1.getName() + " won!");
            } else if (player2.getHand().size() > player1.getHand().size()) {
                System.out.println(player2.getName() + " won!");
            } else {
                System.out.println("Tie!");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
