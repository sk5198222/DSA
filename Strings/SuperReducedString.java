package Strings;

import java.io.*;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        // Use a StringBuilder to efficiently build the reduced string.
        StringBuilder sb = new StringBuilder();

        // Iterate through each character of the input string.
        for (char c : s.toCharArray()) {
            // Check if the StringBuilder is not empty and if the current character
            // matches the last character in the StringBuilder.
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                // If they match, it's a pair. Delete the last character.
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // If they don't match, or if the StringBuilder is empty,
                // append the current character.
                sb.append(c);
            }
        }

        // After iterating through the whole string, check the result.
        // If the StringBuilder is empty, return "Empty String".
        if (sb.length() == 0) {
            return "Empty String";
        } else {
            // Otherwise, return the reduced string.
            return sb.toString();
        }
    }
}

public class SuperReducedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
