public class BingoPatternHash extends BingoPattern{
    public BingoPatternHash(BingoCard card) {
        super(card);
        checkers.add(new BingoRowChecker(card, 1));
        checkers.add(new BingoRowChecker(card, 3));
        checkers.add(new BingoColumnChecker(card, 1));
        checkers.add(new BingoColumnChecker(card, 3));
    }
}
