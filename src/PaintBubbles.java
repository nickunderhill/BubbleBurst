import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class PaintBubbles extends JPanel {

    private final ArrayList<Bubble> bubbles;

    public PaintBubbles(ArrayList<Bubble> bubbles) {
        this.bubbles = bubbles;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Bubble bubble : bubbles) {
            bubble.paintBubble(g);
        }
    }

    void deleteBubble(int x, int y) {
        for (int i = bubbles.size() - 1; i >= 0; i--) {
            int dx = bubbles.get(i).x + bubbles.get(i).d / 2 - x;
            int dy = bubbles.get(i).y + bubbles.get(i).d / 2 - y;
            int d = (int) Math.sqrt(dx * dx + dy * dy);
            if (d < bubbles.get(i).d / 2) {
                bubbles.remove(i);
                break;
            }
        }
    }
}