package Strings;
import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        String firstNumStr = "";
        boolean isBeautiful = false;

        // Iterate through possible lengths for the first number, from 1 up to half the string's length.
        for (int len = 1; len <= s.length() / 2; len++) {
            firstNumStr = s.substring(0, len);
            long firstNum = Long.parseLong(firstNumStr);

            StringBuilder generatedString = new StringBuilder(firstNumStr);
            long nextNum = firstNum + 1;

            // Build the sequence by appending consecutive numbers.
            while (generatedString.length() < s.length()) {
                generatedString.append(nextNum);
                nextNum++;
            }

            // If the generated string exactly matches the original, we've found our answer.
            if (generatedString.toString().equals(s)) {
                isBeautiful = true;
                // Since we are iterating from the shortest possible length,
                // the first match we find will have the smallest starting number.
                break;
            }
        }

        if (isBeautiful) {
            System.out.println("YES " + firstNumStr);
        } else {
            System.out.println("NO");
        }
    }

}

public class SeparateTheNos{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
