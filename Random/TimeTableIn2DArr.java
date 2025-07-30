package Random;
import java.io.*;
import java.util.*;
import java.util.stream.*;


import static java.util.stream.Collectors.toList;

public class TimeTableIn2DArr {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        
        int[][] a = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = arr.get(i).get(j);
            }
        }
        
        int temp=0,sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
                if (i == 0 && j == 0)
                    sum = temp;
                else if (temp > sum)
                    sum = temp;
            }
        }
        System.out.println(sum);
    }
}
