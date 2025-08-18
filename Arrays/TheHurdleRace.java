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
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. INTEGER_ARRAY height
     */

    public static int hurdleRace(int k, List<Integer> height) {
        // Find the maximum height among all the hurdles.
        // Collections.max() is a convenient way to do this.
        int maxHurdleHeight = Collections.max(height);

        // Compare the maximum hurdle height with the character's jump ability.
        if (maxHurdleHeight > k) {
            // If the tallest hurdle is higher than the character can jump,
            // the number of doses needed is the difference.
            return maxHurdleHeight - k;
        } else {
            // If the character can already clear the tallest hurdle, no doses are needed.
            return 0;
        }
    }

}

public class TheHurdleRace {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> height = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
