
class BingoColumnChecker extends BingoChecker {
    private final int col;

    public BingoColumnChecker(BingoGame game, BingoCard card, int col) {
        super(game, card);
        this.col = col;
    }

    public void run() {
        int[][] cardNumbers = card.getCard();
        for (int i = 0; i < 5; i++) {
            int num = cardNumbers[i][col];
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