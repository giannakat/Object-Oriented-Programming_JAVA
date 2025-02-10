public class BingoPatternPlus extends BingoPattern {
    public BingoPatternPlus(BingoCard card) {
        super(card);
        checkers.add(new BingoRowChecker(card, 2));
        checkers.add(new BingoColumnChecker(card, 2));
    }
}
