package Strings;

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
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER steps
     * 2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int altitude = 0; // Current altitude, starts at sea level.
        int valleys = 0;  // Number of valleys traversed.

        // Iterate through each step in the path.
        for (char step : path.toCharArray()) {
            if (step == 'U') {
                altitude++;
                // Check if this step up brought us back to sea level.
                // If so, we just completed a valley.
                if (altitude == 0) {
                    valleys++;
                }
            } else { // The step must be 'D'
                altitude--;
            }
        }
        return valleys;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
