public class Game {
    private final GameBoard board; // link to game board

    public Game() {
        this.board = new GameBoard();
    }

    public void initGame() {
        int showDelay = 1000;
        int counter = 0;
        while (true) {
            board.addBubble();
            board.repaint();
            counter++;
            if (counter >= 5) {
                break;
            }
            if (counter % 10 == 0 && showDelay > 100) {
                showDelay -= 100;
            }
            try {
                Thread.sleep(showDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
