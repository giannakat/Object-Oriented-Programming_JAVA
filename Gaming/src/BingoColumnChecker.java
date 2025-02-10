public class BingoColumnChecker extends BingoChecker {
    private final int col;
    public BingoColumnChecker(BingoCard card, int col) {
        super(card);
        this.col = col;
    }
    @Override
    public void run() {
        System.out.println("Checking column " + col + " for Card " + card.getId());
    }
}
