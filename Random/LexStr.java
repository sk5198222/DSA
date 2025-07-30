package Random;

import java.util.*;

public class LexStr {

    public static void main(String[] args) {
        getSmallestAndLargest("welcometojava", 3);
    }
    
        public static void getSmallestAndLargest(String s, int k) {
            
            List<String> arr=new ArrayList<>();
            
            int i=0;
            while(i<=s.length()-k){
                arr.add(s.substring(i,(i+k)));
                i++;
            }

            String largest=arr.get(0);
            String smallest=largest;

            for(i=1; i<arr.size(); i++){
                String temp=arr.get(i);
                if(temp.compareTo(largest)>0)
                    largest=temp;
                if(temp.compareTo(smallest)<0)
                    smallest=temp;
            }

            System.out.println(arr);
            System.out.println(smallest + "\n" + largest);
        }
}
