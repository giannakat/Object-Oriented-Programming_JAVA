import java.util.ArrayList;
import java.util.List;

abstract class BingoPattern implements Runnable {
    protected final BingoGame game;
    protected final BingoCard card;
    protected final List<Thread> checkers = new ArrayList<>();

    public BingoPattern(BingoGame game, BingoCard card) {
        this.game = game;
        this.card = card;
    }

    public void run() {
        for (Thread checker : checkers) {
            checker.start();
        }
        for (Thread checker : checkers) {
            try {
                checker.join();
            } catch (InterruptedException e) {
                System.out.println("Card " + card.getId() + " loses");
                return;
            }
        }
    }
}



