import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingCloudsRevisited {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int currentCloud = 0;
        int n = c.length;

        // A do-while loop is used because the character always makes at least one jump.
        // The game continues until the character lands back on cloud 0.
        do {
            // Calculate the index of the next cloud in the circular path.
            currentCloud = (currentCloud + k) % n;

            // Every jump costs 1 unit of energy.
            energy--;

            // If the cloud landed on is a thunderhead (value 1), it costs 2 extra energy.
            if (c[currentCloud] == 1) {
                energy -= 2;
            }
        } while (currentCloud != 0);

        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
