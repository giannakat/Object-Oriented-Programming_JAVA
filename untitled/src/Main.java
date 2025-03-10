import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine().toLowerCase(); // Convert to lowercase for consistency

        if (password.isEmpty()) {
            System.out.println("Password is empty");
            return;
        }

        ImprovedBruteForcePasswordCracker bruteForce = new ImprovedBruteForcePasswordCracker(password);
        Thread thread = new Thread(bruteForce);
        thread.start();

        try {
            thread.join(); // Wait for brute-force attack to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}