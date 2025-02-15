import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        BingoGame game = new BingoGame(numPlayers);
        Thread gameThread = new Thread(game);
        gameThread.start();
    }
}
