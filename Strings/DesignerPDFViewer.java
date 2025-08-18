package Strings;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY h
     * 2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        int maxHeight = 0;

        // Iterate through each character in the word.
        for (char c : word.toCharArray()) {
            // Find the height of the current character.
            // 'a' corresponds to index 0, 'b' to 1, etc.
            int charHeight = h.get(c - 'a');
            
            // Update the maximum height if the current character is taller.
            if (charHeight > maxHeight) {
                maxHeight = charHeight;
            }
        }

        // The area of the highlighted rectangle is the tallest letter's height
        // multiplied by the number of letters in the word.
        return maxHeight * word.length();
    }

}

public class DesignerPDFViewer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
