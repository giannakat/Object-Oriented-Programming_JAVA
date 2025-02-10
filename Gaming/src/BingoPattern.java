import java.util.ArrayList;
import java.util.List;

public abstract class BingoPattern implements Runnable {
    protected final BingoCard card;
    protected final List<BingoChecker> checkers = new ArrayList<>();

    public BingoPattern(BingoCard card) {
        this.card = card;
    }

    @Override
    public void run() {
        List<Thread> threads = new ArrayList<>();
        for (BingoChecker checker : checkers) {
            Thread t = new Thread(checker);
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) { return; }
        }
        System.out.println("Card " + card.getId() + " completes pattern!");
    }

}



