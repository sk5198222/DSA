package Sorting;
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
     * Complete the 'marcsCakewalk' function below.
     *
     * The function is expected to return a LONG.
     * The function accepts INTEGER_ARRAY calorie as parameter.
     */

    public static long marcsCakewalk(List<Integer> calorie) {
        // To minimize the total miles, Marc should eat the cupcakes
        // in descending order of calories. This pairs the largest calorie
        // values with the smallest powers of 2.
        
        // Sort the list in descending (reverse) order.
        Collections.sort(calorie, Collections.reverseOrder());
        
        long totalMiles = 0;
        
        // Iterate through the sorted list and calculate the miles for each cupcake.
        for (int i = 0; i < calorie.size(); i++) {
            // The miles for the i-th cupcake (0-indexed) is calorie * 2^i.
            totalMiles += calorie.get(i) * Math.pow(2, i);
        }
        
        return totalMiles;
    }

}

public class MarcsCakewalk{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> calorie = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
