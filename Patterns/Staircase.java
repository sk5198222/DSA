package Patterns;
import java.io.*;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        int m=n-1;
        for(int i=1; i<=n; i++){
            int z=1;
            while(z<=m){
                System.out.print(" ");      
                z++;
            }
            m--;
            int j=i;
            while(j>0){
                System.out.print("#");
                j--;
            }
            System.out.print("\n");
        }
        
    }

}

public class Staircase{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}