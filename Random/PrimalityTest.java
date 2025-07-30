package Random;
import java.io.*;
import java.math.*;

public class PrimalityTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger no=new BigInteger(bufferedReader.readLine());
        bufferedReader.close();

        if(no.isProbablePrime(1))
          System.out.println("prime");
        else
          System.out.println("not prime");
    }
}
