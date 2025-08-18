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
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER k
     * 3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int n = a.size();
        // The array pattern repeats every 'n' rotations, so we only need to
        // consider the remainder of k divided by n.
        int effectiveRotations = k % n;

        List<Integer> result = new ArrayList<>();

        // For each query, calculate the original index of the element.
        for (int queryIndex : queries) {
            // A right rotation moves an element from index i to i+1.
            // To find the original index of an element that is now at 'queryIndex',
            // we need to look 'effectiveRotations' steps back (to the left).
            // The modulo operator handles the circular nature of the array.
            // Adding 'n' before the final modulo ensures the result is non-negative.
            int originalIndex = (queryIndex - effectiveRotations + n) % n;
            
            result.add(a.get(originalIndex));
        }

        return result;
    }

}

public class CircularArrRotation{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.circularArrayRotation(a, k, queries);

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
