import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        // Calculate the number of turns from the front of the book.
        // Each turn reveals two pages, so we can simply divide the target page by 2.
        // Integer division handles both even and odd page numbers correctly.
        int turnsFromFront = p / 2;

        // Calculate the total number of "turnable spreads" in the book.
        int totalTurns = n / 2;

        // The number of turns from the back is the total number of turns
        // minus the number of turns it would take from the front.
        int turnsFromBack = totalTurns - turnsFromFront;

        // Return the smaller of the two values.
        return Math.min(turnsFromFront, turnsFromBack);
    }

}

public class DrawingBook{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}