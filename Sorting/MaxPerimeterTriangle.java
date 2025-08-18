package Sorting;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Sort the sticks in non-decreasing order.
        Collections.sort(sticks);

        // Iterate from the end of the list to find the largest possible perimeter.
        // We need at least 3 sticks, so we go down to index 2.
        for (int i = sticks.size() - 1; i >= 2; i--) {
            int sideA = sticks.get(i - 2);
            int sideB = sticks.get(i - 1);
            int sideC = sticks.get(i);

            // Check for the triangle inequality theorem.
            // Since the array is sorted (a <= b <= c), we only need to check if a + b > c.
            if (sideA + sideB > sideC) {
                // The first valid triangle found will have the maximum perimeter
                // and satisfy the tie-breaking rules due to the sorted order.
                List<Integer> result = new ArrayList<>();
                result.add(sideA);
                result.add(sideB);
                result.add(sideC);
                return result;
            }
        }

        // If no valid triangle is found after checking all triplets, return -1.
        List<Integer> noTriangle = new ArrayList<>();
        noTriangle.add(-1);
        return noTriangle;
    }

}

public class MaxPerimeterTriangle{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
