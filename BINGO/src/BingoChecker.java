public abstract class BingoChecker implements Runnable{
    BingoGame bingoGame;
    BingoCard bingoCard;

    public BingoChecker(BingoGame bingoGame, BingoCard bingoCard){
        this.bingoGame = bingoGame;
        this.bingoCard = bingoCard;
    }
}
