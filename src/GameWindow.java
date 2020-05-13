import javax.swing.*;
import java.awt.*;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameWindow extends JFrame {
    final String TITLE_OF_PROGRAM = "Bubble Burst";
    private static ArrayList<Ball> balls;
    private static final int COUNT_BALLS = 100;
    static final int WINDOW_WIDTH = 800;
    static final int WINDOW_HEIGHT = 700;
    static Random random;
    final Color[] COLORS = {Color.red, Color.green, Color.blue, Color.cyan, Color.magenta};

    public GameWindow() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        random = new Random();
        balls = new ArrayList<>();
        PaintBalls canvas = new PaintBalls(balls);
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                canvas.deleteBall(e.getX(), e.getY());
                canvas.repaint();
            }
        });
        for (int i = 0; i < COUNT_BALLS; i++) {
            addBall();
        }
        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    void addBall() {
        int d = random.nextInt(20) + 60;
        int x = random.nextInt(WINDOW_WIDTH - d);
        int y = random.nextInt(WINDOW_HEIGHT - d);
        Color color = COLORS[random.nextInt(COLORS.length)];
        balls.add(new Ball(x, y, d, color));
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }
}
