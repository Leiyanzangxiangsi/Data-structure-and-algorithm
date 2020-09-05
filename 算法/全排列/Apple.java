


import java.util.Scanner;
import java.lang.Math;

public class Apple {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();

            System.out.println(count(m, n));
        }

    }

    // 苹果相同，盘子相同
    // 递归条件，苹果和盘子的数量不能为0
    public static int count(int m, int n){
        // 只有一个苹果，返回1
        if (m < 0 || n <0)
            return 0;
        else if (m == 1 || n==1){
            return 1;
        }
        else{
            return  count(m, n - 1) + count(m - n, n);
        }
    }
}
