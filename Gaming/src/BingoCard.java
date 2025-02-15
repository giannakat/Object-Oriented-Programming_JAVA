import java.util.*;
import java.util.concurrent.*;

class BingoCard {
    private final int[][] card;
    private final int id;

    public BingoCard(int id) {
        this.id = id;
        this.card = new int[5][5];
        generateCard();
    }

    private void generateCard() {
        Random rand = new Random();
        for (int col = 0; col < 5; col++) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1 + (col * 15); i <= 15 + (col * 15); i++) {
                numbers.add(i);
            }
            Collections.shuffle(numbers);
            for (int row = 0; row < 5; row++) {
                card[row][col] = (col == 2 && row == 2) ? 0 : numbers.get(row);
            }
        }
    }

    public int[][] getCard() {
        return card;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Card ").append(id).append("\n");
        sb.append(" B   I   N   G   O \n");
        for (int[] row : card) {
            for (int num : row) {
                sb.append(String.format("%2s  ", num == 0 ? "F" : num)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
