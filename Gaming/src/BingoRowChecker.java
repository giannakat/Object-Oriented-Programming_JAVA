class BingoRowChecker extends BingoChecker {
    private final int row;

    public BingoRowChecker(BingoGame game, BingoCard card, int row) {
        super(game, card);
        this.row = row;
    }

    public void run() {
        int[][] cardNumbers = card.getCard();
        for (int num : cardNumbers[row]) {
            while (!game.getResults()[num]) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Card " + card.getId() + " loses while waiting for " + num);
                    return;
                }
            }
        }
        game.declareBingo(card);
    }
}