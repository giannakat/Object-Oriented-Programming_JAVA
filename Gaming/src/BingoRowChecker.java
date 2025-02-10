public class BingoRowChecker extends BingoChecker{
    private final int row;
    public BingoRowChecker(BingoCard card, int row) {
        super(card);
        this.row = row;
    }
    @Override
    public void run() {
        System.out.println("Checking row " + row + " for Card " + card.getId());
    }
}
