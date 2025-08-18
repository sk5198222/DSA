package Strings;
import java.io.*;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        StringBuilder encryptedString = new StringBuilder();

        // Reduce k to be within the alphabet range to handle large rotation factors.
        int effectiveKey = k % 26;

        for (char ch : s.toCharArray()) {
            // Check if the character is an alphabet letter.
            if (Character.isLetter(ch)) {
                // Determine the base character ('a' for lowercase, 'A' for uppercase).
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                
                // Calculate the new character's position after shifting.
                // The formula is: base + (original_char - base + key) % 26
                char newChar = (char) (base + (ch - base + effectiveKey) % 26);
                
                encryptedString.append(newChar);
            } else {
                // If it's not a letter, append it without any changes.
                encryptedString.append(ch);
            }
        }

        return encryptedString.toString();
    }

}

public class CaesarCipher{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
