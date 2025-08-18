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
     * Complete the 'theLoveLetterMystery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int theLoveLetterMystery(String s) {
        int operations = 0;
        int left = 0;
        int right = s.length() - 1;

        // Iterate from both ends of the string towards the center.
        while (left < right) {
            // To make the string a palindrome, the characters at 'left' and 'right'
            // must be the same. Since we can only reduce a character's value,
            // we must change the larger character to match the smaller one.
            // The number of operations is the absolute difference of their ASCII values.
            operations += Math.abs(s.charAt(left) - s.charAt(right));
            
            // Move the pointers inward.
            left++;
            right--;
        }
        
        return operations;
    }

}

public class LoveLetterMystery{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.theLoveLetterMystery(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
