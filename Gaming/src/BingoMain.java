import java.util.Scanner;


public class BingoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.close();

        BingoGame game = new BingoGame();
        Thread gameThread = new Thread(game);
        gameThread.start();
    }
}