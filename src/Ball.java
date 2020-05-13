import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {
    int x, y, d;
    Color color;

    Ball(int x, int y, int d, Color color) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.color = color;
    }

    public void paintBall(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, d, d);
        g.setColor(Color.black);
        g.drawOval(x, y, d, d);
    }
}
