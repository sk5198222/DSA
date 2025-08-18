import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubArray {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int size=sc.nextInt();
    int[] arr=new int[size];
    for(int i=0;i<size;i++){
        arr[i]=sc.nextInt();
    }
    sc.close();
    
    int count=0;
    Set<int[]> arrNow=new HashSet<>();
    for(int i=0;i<size;i++){
      for(int j=i; j<size; j++){
        arrNow.add(Arrays.copyOfRange(arr, i, j+1));
      }  
    }

    for(int[] arr1: arrNow){
      int sum=0;
      for(int i=0;i<arr1.length;i++){
        sum+=arr1[i];
      }
      if(sum<0){
        count++;
      }
    }

    System.out.println(count);
  }
}
