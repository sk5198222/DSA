package Strings;
import java.io.*;

class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        int changedLetters = 0;
        // The expected repeating pattern.
        String expectedPattern = "SOS";

        // Iterate through the entire received signal.
        for (int i = 0; i < s.length(); i++) {
            // The expected character is determined by the position in the "SOS" pattern.
            // i % 3 will cycle through 0, 1, 2, 0, 1, 2, ...
            char expectedChar = expectedPattern.charAt(i % 3);
            
            // If the received character doesn't match the expected one, count it as an error.
            if (s.charAt(i) != expectedChar) {
                changedLetters++;
            }
        }
        
        return changedLetters;
    }

}

public class MarsExploration{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
