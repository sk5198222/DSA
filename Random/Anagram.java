package Random;
 public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        System.out.println(count);

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("listen", "silent"));
    }
}