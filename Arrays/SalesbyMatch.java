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
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // This set will store the colors of socks that are waiting for a pair.
        Set<Integer> unpairedSocks = new HashSet<>();
        int pairs = 0;

        // Iterate through each sock in the pile.
        for (int sockColor : ar) {
            // Check if we already have an unpaired sock of the same color.
            if (unpairedSocks.contains(sockColor)) {
                // If we do, we've found a pair!
                pairs++;
                // Remove the color from the set since it's now paired.
                unpairedSocks.remove(sockColor);
            } else {
                // If we don't, add this sock's color to the set of unpaired socks.
                unpairedSocks.add(sockColor);
            }
        }

        // Return the total number of pairs found.
        return pairs;
    }

}

public class SalesbyMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}