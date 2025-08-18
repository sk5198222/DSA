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
     * Complete the 'howManyGames' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER p (initial price)
     * 2. INTEGER d (discount)
     * 3. INTEGER m (minimum price)
     * 4. INTEGER s (starting budget)
     */

    public static int howManyGames(int p, int d, int m, int s) {
        int gamesBought = 0;
        int currentPrice = p;

        // Continue buying games as long as the budget is sufficient.
        while (s >= currentPrice) {
            // Buy the current game.
            gamesBought++;
            s -= currentPrice;
            
            // Calculate the price of the next game.
            // The price decreases by 'd' but does not go below 'm'.
            currentPrice = Math.max(currentPrice - d, m);
        }
        
        return gamesBought;
    }

}

public class HalloweenSale{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        int m = Integer.parseInt(firstMultipleInput[2]);

        int s = Integer.parseInt(firstMultipleInput[3]);

        int answer = Result.howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
