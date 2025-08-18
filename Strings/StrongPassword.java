package Strings;
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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Define the character sets for validation.
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        // Flags to track if each character type is present.
        boolean hasNumber = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        // Iterate through the password to check for each character type.
        for (char c : password.toCharArray()) {
            if (numbers.indexOf(c) != -1) hasNumber = true;
            if (lower_case.indexOf(c) != -1) hasLower = true;
            if (upper_case.indexOf(c) != -1) hasUpper = true;
            if (special_characters.indexOf(c) != -1) hasSpecial = true;
        }

        // Count how many character types are missing.
        int missingTypes = 0;
        if (!hasNumber) missingTypes++;
        if (!hasLower) missingTypes++;
        if (!hasUpper) missingTypes++;
        if (!hasSpecial) missingTypes++;

        // Calculate the number of characters needed to meet the length requirement of 6.
        int lengthDeficit = 6 - n;

        // The result is the maximum of the two requirements.
        // For example, if 3 types are missing but the length is only 1, we need to add
        // 5 characters to reach length 6. Those 5 characters can satisfy the 3 missing types.
        // If 1 type is missing and the length is 10, we only need to add 1 character.
        return Math.max(missingTypes, lengthDeficit);
    }

}

public class StrongPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
