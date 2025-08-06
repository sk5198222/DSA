package Strings;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StrAnagram {

    static boolean isAnagram(String a, String b) {
        int size=0;
        a=a.toLowerCase();
        b=b.toLowerCase();
        
        if (a.length() != b.length()) {
            return false;
        }
        else if(a.length() == b.length()) {
            size=a.length();
            Map<Character, Integer> map = new HashMap<>();
            
            for(int i=0;i<size;i++){
                char ch=a.charAt(i);
                if(map.containsKey(ch)){
                    map.replace(ch, map.get(ch)+1);
                }
                else{
                    map.put(ch, 1);
                }
            }

            for(int i=0;i<size;i++){
                char ch=b.charAt(i);
                if(map.containsKey(ch)){
                    map.replace(ch, map.get(ch)-1);
                }
                else{
                    map.put(ch, -1);
                }
            }

            if(map.containsValue(-1)){
                return false;
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}