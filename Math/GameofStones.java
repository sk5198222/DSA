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
     * Complete the 'gameOfStones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER n as parameter.
     */

    public static String gameOfStones(int n) {
        // This game has a repeating pattern of winning and losing states
        // based on the number of stones modulo 7.
        
        // A player is in a losing position if every possible move
        // leads to a winning position for the opponent.
        // Analysis shows that if n % 7 is 0 or 1, the current player
        // cannot make a move that forces a loss on the opponent.
        
        if (n % 7 == 0 || n % 7 == 1) {
            // If Player 1 starts with n stones where n % 7 is 0 or 1,
            // they are in a losing position.
            return "Second";
        } else {
            // Otherwise, Player 1 can always make a move that leaves
            // the opponent in a losing position (n % 7 = 0 or 1).
            return "First";
        }
    }

}

public class GameofStones{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String result = Result.gameOfStones(n);

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
