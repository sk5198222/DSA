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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        // The 256th day of the year is the Day of the Programmer.

        // Special case for the transition year 1918 in Russia.
        // After Jan 31, the next day was Feb 14. 13 days were lost.
        // The 256th day in 1918 was September 26th.
        if (year == 1918) {
            return "26.09.1918";
        }

        boolean isLeapYear;

        // Determine if it's a leap year based on the calendar system.
        if (year < 1918) {
            // Julian calendar: Leap year is divisible by 4.
            isLeapYear = (year % 4 == 0);
        } else {
            // Gregorian calendar: Leap year is divisible by 400,
            // or divisible by 4 but not by 100.
            isLeapYear = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        }

        // In a leap year, February has 29 days, so the 256th day is September 12th.
        if (isLeapYear) {
            return "12.09." + year;
        } else {
            // In a common year, February has 28 days, so the 256th day is September 13th.
            return "13.09." + year;
        }
    }

}

public class DayoftheProgrammer{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
