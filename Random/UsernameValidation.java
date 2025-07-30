package Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UsernameValidation {
    private static final Scanner scan = new Scanner(System.in);
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{7,29}$");

    private static final boolean isValid(String userName) {
        return pattern.matcher(userName).matches();
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();
            if(isValid(userName))
                System.out.println("Valid");
            else
                System.out.println("Invalid");
        }
        scan.close();
    }
}