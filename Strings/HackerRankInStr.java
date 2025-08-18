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
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
        String target = "hackerrank";
        int targetIndex = 0; // Pointer for the target string "hackerrank"
        int stringIndex = 0; // Pointer for the input string s

        // Iterate while both pointers are within their respective string bounds.
        while (targetIndex < target.length() && stringIndex < s.length()) {
            // If the characters match, advance the pointer for the target string.
            if (s.charAt(stringIndex) == target.charAt(targetIndex)) {
                targetIndex++;
            }
            // Always advance the pointer for the input string.
            stringIndex++;
        }

        // If the targetIndex reached the end of "hackerrank", it means all
        // characters were found in the correct order.
        if (targetIndex == target.length()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class HackerRankInStr {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

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
