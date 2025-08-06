package Strings;

public class StrTokens {

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        String s = """
                           YES      leading spaces        are valid,    problemsetters are         evillllll
                """;
        ;
        // scan.nextLine();
        // scan.close();
        s.trim();
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        String[] arr = s.split("[\\s',?!._@]+");
        System.out.println(arr.length);
        for (String s1 : arr) {
            System.out.println(s1);
        }
    }
}
