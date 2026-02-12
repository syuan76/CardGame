import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int TITLE_BAR_HEIGHT = 23;

    private Game backend;

    public GameView(Game backend) {
        this.backend = backend;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Crazy 8's");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        if (backend.getState() == Game.STATE_INSTR) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.drawString("INSTRUCTIONS: CRAZY 8'S", 150, 100);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 25));
            g.drawString("- Try to get rid of all your cards! This is a two-player card game. To start, each player is dealt 7", 20, 150);
            g.drawString("  cards.", 20,180);
            g.drawString("- You can play any card of the same suit as the Top Card.", 20, 220);
            g.drawString("- You can play any card of the same rank as the Top Card.", 20, 260);
            g.drawString("- You can always play an 8, and then you can change the suit to whatever you want.", 20, 300);
            g.drawString("- If you have no valid card to play, you can draw up to 3 cards from the deck. You can't draw", 20, 340);
            g.drawString("  if you have any cards that you can play in your hand. If you've drawn 3 cards and still can't", 20, 370);
            g.drawString("  play you must pass and the next player plays.", 20, 400);
            g.drawString("- If the deck is empty and neither player can make anymore progress, the game is over and the", 20, 440);
            g.drawString("  winner is determined by the player with the least amount of cards in their hand.", 20, 470);
            g.drawString("- First to get rid of all their cards wins. Good luck, and have fun!", 20, 510);
        }
    }
}
