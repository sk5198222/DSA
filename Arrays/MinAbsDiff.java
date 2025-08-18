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
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Sort the array in ascending order.
        // After sorting, the minimum difference will be between adjacent elements.
        Collections.sort(arr);

        // Initialize minDifference with a large value.
        int minDifference = Integer.MAX_VALUE;

        // Iterate through the sorted array to find the minimum difference
        // between adjacent elements.
        for (int i = 0; i < arr.size() - 1; i++) {
            // Calculate the absolute difference between the current and next element.
            int currentDifference = arr.get(i + 1) - arr.get(i);

            // Update the minimum difference if the current one is smaller.
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
            }
        }

        return minDifference;
    }

}

public class MinAbsDiff{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
