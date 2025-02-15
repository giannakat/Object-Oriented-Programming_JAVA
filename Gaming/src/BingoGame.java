import java.util.*;

class BingoGame implements Runnable {
    private final boolean[] results = new boolean[76];
    private final List<BingoCard> cards = new ArrayList<>();
    private volatile boolean bingo = false;

    public BingoGame(int numPlayers) {
        results[0] = true;
        for (int i = 1; i <= numPlayers; i++) {
            cards.add(new BingoCard(i));
        }
    }

    public void run() {
        Set<Integer> drawnNumbers = new TreeSet<>();
        Random rand = new Random();
        while (!bingo) {
            int num;
            do {
                num = rand.nextInt(75) + 1;
            } while (results[num]);
            results[num] = true;
            drawnNumbers.add(num);
            System.out.println("Number drawn: " + num);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public boolean[] getResults() {
        return results;
    }

    public void declareBingo(BingoCard card) {
        bingo = true;
        System.out.println("Card " + card.getId() + " completes pattern!");
    }
}
