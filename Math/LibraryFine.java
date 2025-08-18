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
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER d1 (return day)
     * 2. INTEGER m1 (return month)
     * 3. INTEGER y1 (return year)
     * 4. INTEGER d2 (due day)
     * 5. INTEGER m2 (due month)
     * 6. INTEGER y2 (due year)
     */

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Check for lateness in order of severity: year, month, then day.

        // 1. If the book is returned after the due year.
        if (y1 > y2) {
            return 10000;
        }

        // 2. If the book is returned in the same year, but after the due month.
        if (y1 == y2 && m1 > m2) {
            return 500 * (m1 - m2);
        }

        // 3. If the book is returned in the same year and month, but after the due day.
        if (y1 == y2 && m1 == m2 && d1 > d2) {
            return 15 * (d1 - d2);
        }

        // 4. If none of the above, the book is on time or early.
        return 0;
    }

}

public class LibraryFine {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);
        int m1 = Integer.parseInt(firstMultipleInput[1]);
        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);
        int m2 = Integer.parseInt(secondMultipleInput[1]);
        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
