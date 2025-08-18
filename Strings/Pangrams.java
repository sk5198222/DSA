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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Create a boolean array to represent the 26 letters of the alphabet.
        boolean[] alphabetPresent = new boolean[26];
        
        // Convert the input string to lowercase to ignore case.
        String lowerCaseS = s.toLowerCase();
        
        // Iterate through each character of the string.
        for (char c : lowerCaseS.toCharArray()) {
            // Check if the character is a lowercase letter.
            if (c >= 'a' && c <= 'z') {
                // Mark the corresponding letter as present in our checklist.
                // 'a' corresponds to index 0, 'b' to 1, and so on.
                alphabetPresent[c - 'a'] = true;
            }
        }
        
        // Check if all letters were found.
        for (boolean isPresent : alphabetPresent) {
            if (!isPresent) {
                // If any letter is missing, it's not a pangram.
                return "not pangram";
            }
        }
        
        // If the loop completes, all letters were present.
        return "pangram";
    }

}

public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
