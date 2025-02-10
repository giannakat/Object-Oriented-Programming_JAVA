public abstract class BingoChecker implements Runnable{
    protected final BingoCard card;
    public BingoChecker(BingoCard card) { this.card = card; }
}
