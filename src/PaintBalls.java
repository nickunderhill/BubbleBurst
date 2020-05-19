import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class PaintBalls extends JPanel {

    private final ArrayList<Bubble> bubbles;

    public PaintBalls(ArrayList<Bubble> bubbles) {
        this.bubbles = bubbles;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Bubble bubble : bubbles) {
            bubble.paintBall(g);
        }
    }

    void deleteBall(int x, int y) {
        for (int i = bubbles.size() - 1; i > -1; i--) {
            double dx = bubbles.get(i).x + bubbles.get(i).d / 2 - x;
            double dy = bubbles.get(i).y + bubbles.get(i).d / 2 - y;
            double d = Math.sqrt(dx * dx + dy * dy);
            if (d < bubbles.get(i).d / 2) {
                bubbles.remove(i);
                break;
            }
        }
    }
}