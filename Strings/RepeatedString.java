package Strings;
import java.io.*;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. LONG n
     */

    public static long repeatedString(String s, long n) {
        long countAInS = 0;
        // First, count the number of 'a's in the original string s.
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countAInS++;
            }
        }

        // Calculate how many full repetitions of s fit into n.
        long fullRepetitions = n / s.length();
        
        // Calculate the total 'a's from these full repetitions.
        long totalAs = fullRepetitions * countAInS;
        
        // Calculate the length of the remaining part of the string.
        long remainderLength = n % s.length();
        
        // Count the 'a's in the remaining part of the string.
        for (int i = 0; i < remainderLength; i++) {
            if (s.charAt(i) == 'a') {
                totalAs++;
            }
        }
        
        return totalAs;
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
