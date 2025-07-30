package Random;
import java.util.*;

public class StrRev {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        sc.close();
        StringBuilder B=new StringBuilder(A).reverse();
        if(A.equals(B.toString()))
          System.out.println("Yes");
        else
          System.out.println("No");
        
    }
}



