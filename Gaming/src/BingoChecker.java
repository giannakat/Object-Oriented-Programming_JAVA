
abstract class BingoChecker implements Runnable {
    protected final BingoGame game;
    protected final BingoCard card;

    public BingoChecker(BingoGame game, BingoCard card) {
        this.game = game;
        this.card = card;
    }
}


