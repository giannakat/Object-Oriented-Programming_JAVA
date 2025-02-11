import java.util.*;
import java.util.List;
import java.util.Random;

public class BingoCard {
    private final int id;
    static int ID;
    private final int[][] numbers = new int[5][5];
    private static final Random random = new Random();

    public BingoCard(){
        id = ++ID;
        createCard();
    }

    private void createCard() {
        int start = 1;
        for(int col = 0; col < 5; col++){
            List<Integer> numbers = new ArrayList<>();
            for(int i = start; i < start+ 15; i++){
                numbers.add(i);
            }

            Collections.shuffle(numbers);
            for(int row = 0; row < 5; row++){
                if(col == 2 && row == 2){
                    this.numbers[row][col] = 0;
                } else {
                    this.numbers[row][col] = numbers.remove(0);
                }
            }
            start+=15;
        }
    }


    public String toString(){
        StringBuilder sb = new StringBuilder("B   I   N   G   O" + "\n");

        for(int[] row: numbers){
            for(int num:row){
                sb.append(String.format("%2d  ", num));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}