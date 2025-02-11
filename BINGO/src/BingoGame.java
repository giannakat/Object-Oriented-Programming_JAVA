import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoGame implements Runnable{
    Scanner sc = new Scanner(System.in);
    boolean[] result = new boolean[76];
    boolean bingo;

    BingoGame(){
       result[0] = true;
       bingo=false;
    }
    @Override
    public void run() {
        System.out.println("Enter number of players: ");
        int n = sc.nextInt();
        List<BingoCard> cards = new ArrayList<>();

        for(int i = 0; i < n; i++){
            cards.add(new BingoCard());
        }

        List<Thread> threads = new ArrayList<>();
        for(BingoCard card: cards){
            threads.add(new Thread(new BingoPatternPlus(this, card)));
        }


       ;

    }
}
