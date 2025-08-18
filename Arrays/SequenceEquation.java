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
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
        int n = p.size();
        // Create an array to store the 1-based index of each number in p.
        // This acts as a hash map for quick lookups.
        int[] positions = new int[n + 1];
        for (int i = 0; i < n; i++) {
            // Key: the number in p. Value: its 1-based index.
            positions[p.get(i)] = i + 1;
        }

        List<Integer> result = new ArrayList<>();
        
        // Iterate x from 1 to n.
        for (int x = 1; x <= n; x++) {
            // First, find the index of x. Let's call it indexOfX.
            // p(indexOfX) = x
            int indexOfX = positions[x];
            
            // Then, find the index of indexOfX. This is our y.
            // p(y) = indexOfX
            int y = positions[indexOfX];
            
            result.add(y);
        }

        return result;
    }

}

public class SequenceEquation{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.permutationEquation(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
