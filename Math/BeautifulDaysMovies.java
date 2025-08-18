import java.io.*;

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER i (starting day)
     * 2. INTEGER j (ending day)
     * 3. INTEGER k (divisor)
     */

    public static int beautifulDays(int i, int j, int k) {
        int beautifulDaysCount = 0;

        // Loop through every day in the range [i, j].
        for (int day = i; day <= j; day++) {
            // To reverse the number, we can convert it to a string,
            // reverse it, and convert it back to an integer.
            StringBuilder sb = new StringBuilder(String.valueOf(day));
            int reversedDay = Integer.parseInt(sb.reverse().toString());

            // Check if the absolute difference is evenly divisible by k.
            if (Math.abs(day - reversedDay) % k == 0) {
                beautifulDaysCount++;
            }
        }
        
        return beautifulDaysCount;
    }

}

public class BeautifulDaysMovies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
