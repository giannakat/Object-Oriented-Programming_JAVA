class BingoPatternHash extends BingoPattern {
    public BingoPatternHash(BingoGame game, BingoCard card) {
        super(game, card);
        checkers.add(new Thread(new BingoRowChecker(game, card, 1)));
        checkers.add(new Thread(new BingoRowChecker(game, card, 3)));
        checkers.add(new Thread(new BingoColumnChecker(game, card, 1)));
        checkers.add(new Thread(new BingoColumnChecker(game, card, 3)));
    }
}