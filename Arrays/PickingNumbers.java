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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Create a frequency map to count occurrences of each number.
        // A Map is used here for flexibility, but an array could also work
        // if the number range is known and small.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        
        // Iterate through the unique numbers present in the array.
        for (int key : frequencyMap.keySet()) {
            // The longest subarray can be formed by numbers 'key' and 'key + 1'.
            // Get the frequency of 'key' and 'key + 1'.
            // If 'key + 1' is not in the map, getOrDefault returns 0.
            int currentLength = frequencyMap.get(key) + frequencyMap.getOrDefault(key + 1, 0);
            
            // Update the maximum length found so far.
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        
        return maxLength;
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
