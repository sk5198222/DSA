package Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListValidInpEle {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int s=sc.nextInt();
    List<int[]> arr=new ArrayList<>();
    for(int i=0; i<s; i++){
      int size=sc.nextInt();
      int arrNow[]=new int[size];
      for(int j=0; j<size; j++){
        arrNow[j]=sc.nextInt();
      }
      arr.add(arrNow);
    }
    s=sc.nextInt();
    List<Object> list=new ArrayList<>();
    for(int i=0; i<s; i++){
      int i1=sc.nextInt();
      int i2=sc.nextInt();
      try{
        list.add(arr.get(i1-1)[i2-1]);
      }
      catch(Exception ex){
        list.add("ERROR!");
      }
    }
    sc.close();
    for (Object obj : list) {
      System.out.println(obj);
    }
  }
}