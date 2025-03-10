
import java.util.ArrayList;
import java.util.List;

public class ImprovedBruteForcePasswordCracker implements Runnable {

    private final String password;
    private final int length;
    private final int threads;
    private final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    private boolean found = false;
    private Thread[] th;
    private final List<String> foundTh = new ArrayList<>(); // Store valid thread patterns

    public ImprovedBruteForcePasswordCracker(String password) {
            this.password = password;
            this.length = password.length();
            this.threads = length*5;
            this.th = new Thread[threads];
    }

    @Override
    public void run() {
        int threadCount = 0;

        for (int i = 0; i < length; i++) {
            for (char vowel : VOWELS) {
                final int pos = i;
                final int threadNumber = threadCount + 1;
                final String targetPassword = password;

                th[threadCount] = new Thread(() -> {
                    if (found) return; // Stop if password is found

                    // Generate attempt string
                    char[] attempt = new char[length];
                    for (int j = 0; j < length; j++) {
                        attempt[j] = (j == pos) ? vowel : '_';
                    }

                    String attemptStr = new String(attempt);
                    System.out.println(String.format("Thread %02d: %s", threadNumber, attemptStr));

                    // Check if attempt has correct vowel positions
                    boolean matchesVowels = true;
                    for (int j = 0; j < length; j++) {
                        if (isVowel(targetPassword.charAt(j)) && attemptStr.charAt(j) == targetPassword.charAt(j)) {
                            matchesVowels = true;
                            synchronized (foundTh) {
                                foundTh.add(attemptStr);
                            }
                        }
                    }

                });

                th[threadCount].start();
                threadCount++;
            }
        }

        // Ensure all threads complete before printing results
        for (Thread t : th) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print valid threads that could find the password
        System.out.println("\nThreads that possibly found the password: " + foundTh);
    }

    private boolean isVowel(char c) {
        for (char vowel : VOWELS) {
            if (c == vowel) return true;
        }
        return false;
    }
}


//        this.password = password.toLowerCase();
//        this.length = password.length();
//        this.threads = length * VOWELS.length; // Total threads = length * 5
//        this.th = new Thread[threads];