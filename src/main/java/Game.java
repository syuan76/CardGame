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
        topCard = deck.getCards().get(0);
        getPlayerNames();
        dealCards();

        while (!ifGameOver()) {
            takeTurn(player1);
            takeTurn(player2);
        }

        printWinner();
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

    public void showHand(Player p) {
        System.out.println(p.getName() + "'s hand:");
        for (int i = 0; i < p.getHand().size(); i++) {
            System.out.println("[" + i + "] " + p.getHand().get(i));
        }
    }

    public boolean containsValidCard(Player p) {
        for (int i = 0; i < p.getHand().size(); i++) {
            if (p.getHand().get(i).getSuit().equals(topCard.getSuit()) || p.getHand().get(i).getRank().equals(topCard.getRank())) {
                return true;
            }
        }
        return false;
    }

    public void drawCard(Player p) {
        p.getHand().add(deck.deal());
    }

    public void takeTurn(Player p) {
        Scanner sc = new Scanner(System.in);

        System.out.println(p.getName() + "'s Turn");
        System.out.println("Top card: " + topCard);
        showHand(p);
        String input;
        int numDraws = 0;
        int index;
        Card chosen;
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
            System.out.println("Choose a card index to play: ");
            index = sc.nextInt();
            if (index < 0 || index >= p.getHand().size()) {
                System.out.println("Invalid index. Try again!");
                continue;
            }
            chosen = p.getHand().get(index);
            if (!isValid(chosen)) {
                System.out.println("You cannot play this card. Choose a matching suit or rank.");
            } else {
                break;
            }
        }
        p.getHand().remove(index);
        topCard = chosen;
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
