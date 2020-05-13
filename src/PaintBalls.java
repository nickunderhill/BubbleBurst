import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class PaintBalls extends JPanel {

    private final ArrayList<Ball> balls;

    public PaintBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball ball : balls) {
            ball.paintBall(g);
        }
    }

    void deleteBall(int x, int y) {
        for (int i = balls.size() - 1; i > -1; i--) {
            double dx = balls.get(i).x + balls.get(i).d/2 - x;
            double dy = balls.get(i).y  + balls.get(i).d/2 - y;
            double d = Math.sqrt(dx * dx + dy * dy);
            if (d < balls.get(i).d/2) {
                balls.remove(i);
                break;
            }
        }
    }
}