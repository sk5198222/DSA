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
     * Complete the 'camelcase' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int camelcase(String s) {
        // According to the problem, there's always at least one word.
        // So, we start our count at 1 for the first word.
        int wordCount = 1;

        // Iterate through each character of the string.
        for (char c : s.toCharArray()) {
            // Check if the character is an uppercase letter.
            // Each uppercase letter signifies the start of a new word.
            if (Character.isUpperCase(c)) {
                wordCount++;
            }
        }

        // Return the total count of words.
        return wordCount;
    }

}

public class CamelCase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
