
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

// 记录是按时间顺序给的
public class qustion2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        int n = Integer.valueOf(N);

        String[][] luxian=new String[n][];
        for (int i = 0;i < n;i++){
            String in = scanner.nextLine();
            luxian[i] = in.split(" ");
        }

        int time = 0;
        String start=luxian[0][0];
        for (int i=0; i <  n; i++){
            for (int j = 0; j < 2; j++){
                if (luxian[i][j].equals(start)&&j==1){
                    time++;
                    if (i<n-1) {
                        start = luxian[i + 1][0];
                    }
                }
            }
        }
        System.out.print(time);
    }

}

