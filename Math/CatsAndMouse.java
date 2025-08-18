import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CatsAndMouse{

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        // Calculate the absolute distance of each cat from the mouse.
        int distA = Math.abs(x - z);
        int distB = Math.abs(y - z);

        // Compare the distances to determine the winner.
        if (distA < distB) {
            return "Cat A";
        } else if (distB < distA) {
            return "Cat B";
        } else {
            // If the distances are equal, the mouse escapes.
            return "Mouse C";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
