import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n (number of towers)
     * 2. INTEGER m (height of each tower)
     */

    public static int towerBreakers(int n, int m) {
        // This is a game theory problem that simplifies significantly.
        // The optimal move for any player is to reduce a tower's height to 1,
        // making that tower unplayable for the rest of the game.
        
        // Case 1: If the tower height is 1, Player 1 has no possible moves and loses immediately.
        if (m == 1) {
            return 2; // Player 2 wins.
        }

        // Case 2: The number of towers 'n' is even.
        // Player 1 makes a move on a tower. Player 2 can mirror that move on another tower.
        // Since there's an even number of towers, Player 2 will always have a tower to move on
        // after Player 1's turn. Player 2 will make the last move.
        if (n % 2 == 0) {
            return 2; // Player 2 wins.
        }

        // Case 3: The number of towers 'n' is odd and height m > 1.
        // Player 1 will make the first move, the third, the fifth, and so on.
        // Since there's an odd number of towers, Player 1 will make the final move,
        // leaving Player 2 with no available moves.
        return 1; // Player 1 wins.
    }

}

public class TowerBreakers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

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
