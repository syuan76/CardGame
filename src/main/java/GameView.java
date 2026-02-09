import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int TITLE_BAR_HEIGHT = 23;

    private Game backend;
    private Image[] cardImages;

    public GameView(Game backend) {
        this.backend = backend;

        // TODO: upload images and add to cardImages

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Crazy 8's");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
}
