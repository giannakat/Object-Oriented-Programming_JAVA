class BingoPatternPlus extends BingoPattern {
    public BingoPatternPlus(BingoGame game, BingoCard card) {
        super(game, card);
        checkers.add(new Thread(new BingoRowChecker(game, card, 2)));
        checkers.add(new Thread(new BingoColumnChecker(game, card, 2)));
    }
}