import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JFrame {
    private static final int WINDOW_WIDTH = 800; //
    private static final int WINDOW_HEIGHT = 700;
    private static final int COUNT_BALLS = 100;
    private final String TITLE_OF_PROGRAM = "Bubble Burst";
    private static Random random;

    public static ArrayList<Bubble> getBubbles() {
        return bubbles;
    }

    private static ArrayList<Bubble> bubbles;
    private final Color[] COLORS = {Color.red, Color.green, Color.blue, Color.cyan, Color.magenta};

    public GameBoard() {
        initWindow();
    }

    private void initWindow() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        random = new Random();
        bubbles = new ArrayList<>();
        PaintBubbles canvas = new PaintBubbles(bubbles);
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                canvas.deleteBubble(e.getX(), e.getY());
                canvas.repaint();
            }
        });
        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    void addBubble() {
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
