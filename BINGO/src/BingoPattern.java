import java.util.ArrayList;
import java.util.List;

public abstract  class BingoPattern implements Runnable{
    List<BingoChecker> bcheckerlist = new ArrayList<>();
    BingoGame bingoGame;
    BingoCard bingoCard;

    public BingoPattern(BingoGame bingoGame, BingoCard bingoCard){
        this.bingoGame = bingoGame;
        this.bingoCard = bingoCard;
    }

    public void run(){
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i<n; i++){
            threads.add(new Thread(new BingoCheckers()));
        }
    }
}
