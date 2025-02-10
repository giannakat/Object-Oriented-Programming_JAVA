import java.util.*;

public class BingoGame implements Runnable{
    Scanner scanner = new Scanner(System.in);
    private final boolean[] result = new boolean[76];
    private boolean bingo = false;
    private final List<BingoCard> cards = new ArrayList<>();

    public BingoGame(){
        result[0] = true;
        for()
    }

    @Override
    public void run() {
        Random random = new Random();
        Set<Integer> chosenNumbers = new TreeSet<>();

        System.out.println("How many players: ");
        int totalCard = scanner.nextInt();
        for(int i = 0; i < totalCard; i++){
            cards.add(new BingoCard(i+1));
        }

        for(BingoCard card : cards){
            Thread t = new Thread(new BingoPatternPlus(card));
            patternThreads.add(t);
            t.start();
        }

        while (!bingo) {
            int num;
            do { num = random.nextInt(75) + 1; } while (result[num]);
            result[num] = true;
            chosenNumbers.add(num);

            System.out.println("Number Drawn: " + num);
            System.out.println("Numbers so far: " + chosenNumbers);

            synchronized (this) {
                notifyAll(); // Notify checkers waiting for updates
            }

            try { Thread.sleep(300); } catch (InterruptedException e) { break; }
        }

        }

    }
}
