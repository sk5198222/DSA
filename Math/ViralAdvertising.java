import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int n) {
        // Initialize the state for Day 1.
        int shared = 5;
        int cumulativeLikes = 0;

        // Loop from day 1 to the target day n.
        for (int day = 1; day <= n; day++) {
            // Calculate how many people liked the ad on the current day.
            // Integer division automatically handles the floor operation.
            int liked = shared / 2;

            // Add the new likes to the cumulative total.
            cumulativeLikes += liked;

            // Calculate how many people will be advertised to on the next day.
            shared = liked * 3;
        }

        return cumulativeLikes;
    }

}

public class ViralAdvertising{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
