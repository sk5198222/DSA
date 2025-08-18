import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. INTEGER x1
     * 2. INTEGER v1
     * 3. INTEGER x2
     * 4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Condition 1: The first kangaroo must be faster to catch up.
        // If v1 is less than or equal to v2, it will never close the gap.
        if (v1 <= v2) {
            return "NO";
        }

        // Condition 2: The distance gap must be perfectly divisible by the speed difference.
        // This ensures they meet exactly on a jump (j is a whole number).
        if ((x2 - x1) % (v1 - v2) == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}

public class NumberLineJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);
        int v1 = Integer.parseInt(firstMultipleInput[1]);
        int x2 = Integer.parseInt(firstMultipleInput[2]);
        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}