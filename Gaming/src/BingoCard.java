import java.util.*;
import java.util.List;
import java.util.Random;

public class BingoCard {
    private final int id;
    private final int[][] card = new int[5][5];
    private static final Random random = new Random();

    public BingoCard(int id){
        this.id = id;
        generateCard();
    }

    private void generateCard() {
        int start = 1;
        for(int col = 0; col < 5; col++){
            List<Integer> numbers = new ArrayList<>();
            for(int i = start; i < start+ 15; i++){
                numbers.add(i);
            }

            Collections.shuffle(numbers);
            for(int row = 0; row < 5; row++){
                if(col == 2 && row == 2){
                    card[row][col] = 0;
                } else {
                    card[row][col] = numbers.remove(0);
                }
            }
            start+=15;
        }
    }

    public int getId(){
        return id;
    }

    public int[][] getCard(){
        return card;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Card" + id + "\n");

        for(int[] row:card){
            for(int num:row){
                sb.append(String.format("%2d", num));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
