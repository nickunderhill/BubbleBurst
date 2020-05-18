import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameWindow extends JFrame {
    final String TITLE_OF_PROGRAM = "Bubble Burst";
    private static ArrayList<Bubble> bubbles;
    private static final int COUNT_BALLS = 100;
    static final int WINDOW_WIDTH = 800;
    static final int WINDOW_HEIGHT = 700;
    static final Color BACKGROUND_COLOR = Color.white;
    static final Color[] COLORS = {Color.red, Color.green, Color.blue, Color.cyan, Color.magenta};
    static Random random;

    public GameWindow() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        random = new Random();
        bubbles = new ArrayList<>();
        PaintBubbles gameField = new PaintBubbles(bubbles);
        gameField.setBackground(BACKGROUND_COLOR);
        gameField.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        // TODO: 18.05.2020 Replace with lambda expression
        gameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                gameField.deleteBubble(e.getX(), e.getY());
                gameField.repaint();
            }
        });

        for (int i = 0; i < COUNT_BALLS; i++) {
            fillCanvasWithBubbles();
        }
        add(gameField);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    void fillCanvasWithBubbles() {
        int d = random.nextInt(20) + 60;
        int x = random.nextInt(WINDOW_WIDTH - d);
        int y = random.nextInt(WINDOW_HEIGHT - d);
        Color color = COLORS[random.nextInt(COLORS.length)];
        bubbles.add(new Bubble(x, y, d, color));
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }
}
