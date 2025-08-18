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
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
        // Use a HashMap to store the last seen index of each number.
        // Key: number, Value: index.
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        // Iterate through the array with its index.
        for (int i = 0; i < a.size(); i++) {
            int currentNum = a.get(i);

            // Check if we have seen this number before.
            if (lastSeenIndex.containsKey(currentNum)) {
                // If yes, calculate the distance from the last time we saw it.
                int prevIndex = lastSeenIndex.get(currentNum);
                int distance = i - prevIndex;
                
                // Update the minimum distance if the current one is smaller.
                minDistance = Math.min(minDistance, distance);
            }
            
            // Update the map with the current index of the number.
            lastSeenIndex.put(currentNum, i);
        }

        // If minDistance was never updated, it means no matching pairs were found.
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minDistance;
        }
    }

}

public class MinDistances{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
