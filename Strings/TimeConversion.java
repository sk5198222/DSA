package Strings;
import java.io.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Extract the parts of the time string
        String amPm = s.substring(8, 10); // "AM" or "PM"
        String hourStr = s.substring(0, 2);
        String restOfTime = s.substring(2, 8); // ":mm:ss"
        int hour = Integer.parseInt(hourStr);

        if (amPm.equals("PM")) {
            // If it's PM and not 12 PM, add 12 to the hour.
            // 12 PM is a special case where the hour doesn't change.
            if (hour != 12) {
                hour += 12;
            }
        } else { // It's AM
            // If it's 12 AM, the hour becomes 00 in 24-hour format.
            if (hour == 12) {
                hour = 0;
            }
        }

        // Format the new hour to have a leading zero if it's a single digit.
        String newHourStr = String.format("%02d", hour);

        // Reconstruct and return the time in 24-hour format.
        return newHourStr + restOfTime;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
