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
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n (number of prisoners)
     * 2. INTEGER m (number of sweets)
     * 3. INTEGER s (starting chair)
     */

    public static int saveThePrisoner(int n, int m, int s) {
        // This problem can be solved with a single modular arithmetic formula.
        // We want to find the final chair number after distributing 'm' sweets
        // starting from chair 's' in a circle of 'n' chairs.

        // The position is the sum of the starting chair and the number of sweets,
        // adjusted for the fact that the first sweet goes to the starting chair.
        // (s - 1) adjusts the start to be 0-indexed.
        // (m - 1) adjusts for the number of steps after the first sweet.
        // The sum is taken modulo n to wrap around the circle.
        // Finally, +1 converts the 0-indexed result back to a 1-indexed chair number.
        
        int lastPrisoner = (s + m - 2) % n + 1;
        
        return lastPrisoner;
    }

}

public class SaveThePrisoner{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.saveThePrisoner(n, m, s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
