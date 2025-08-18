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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Step 1: Sort each row of the grid alphabetically.
        for (int i = 0; i < grid.size(); i++) {
            char[] rowChars = grid.get(i).toCharArray();
            Arrays.sort(rowChars);
            // Update the grid with the new sorted string.
            grid.set(i, new String(rowChars));
        }

        // Step 2: Check if each column is sorted alphabetically.
        int numRows = grid.size();
        // Assuming a square or rectangular grid where all rows have the same length.
        int numCols = grid.get(0).length();

        // Iterate through each column.
        for (int j = 0; j < numCols; j++) {
            // Iterate through the rows of the current column.
            for (int i = 0; i < numRows - 1; i++) {
                // Compare the character in the current row with the one in the next row.
                if (grid.get(i).charAt(j) > grid.get(i + 1).charAt(j)) {
                    // If any column is not sorted, return "NO" immediately.
                    return "NO";
                }
            }
        }

        // If all columns are sorted, return "YES".
        return "YES";
    }

}

public class GridChallenge{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
