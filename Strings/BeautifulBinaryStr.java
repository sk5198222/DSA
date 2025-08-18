package Strings;
import java.io.*;

class Result {

    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) {
        int moves = 0;
        // Iterate through the string, stopping 2 characters before the end
        // so we can check for the "010" substring of length 3.
        for (int i = 0; i <= b.length() - 3; ) {
            // Check if the substring starting at index i is "010".
            if (b.substring(i, i + 3).equals("010")) {
                // If it is, we need to make one move to change it.
                moves++;
                // We can greedily change the last character of the pattern.
                // This prevents creating new "010"s and allows us to jump
                // our search ahead by 3 positions.
                i += 3;
            } else {
                // If no "010" is found, just move to the next character.
                i++;
            }
        }
        return moves;
    }

}

public class BeautifulBinaryStr{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String b = bufferedReader.readLine();

        int result = Result.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
