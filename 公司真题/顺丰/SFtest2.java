import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



public class SFtest2 {

    //背包问题，多重循环
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();   //n个任务

        int[][] times = new int[n][2];  //相当于重量
        int[] v = new int[n];           //价值

        for (int i = 0; i < n; i++) {
            times[i][0] = in.nextInt();
            times[i][1] = in.nextInt();
            v[i] = in.nextInt();
        }

        System.out.println(Getmax(times, v, n));
    }

    public static int Getmax(int[][] times, int[] v, int n){

        int max = 0;
        for (int i = 0;i < n;i++){      //从第一个任务开始

            int sum = v[i];
            List<Integer> l = new LinkedList<>();
            l.add(i);

            for (int j = 0; j < n; j++){        //从后面的任务遍历
                if (i == j)
                    continue;
                if (xiangrong(times, l, j)){    //如果和选择的任务都能相容
                    l.add(j);                   //添加到这个集合里
                    sum = sum + v[j];           //价值加进去
                }
            }

            if (sum > max)                      //价值是否最大？
                max = sum;
        }

        return max;
    }

    public static boolean xiangrong(int[][] times, List<Integer> l, int j){

        //和前面所有的都相容
        for (int a : l){
            /*if ((times[j][0] < times[a][1] && times[j][1] > times[a][1])
                    || (times[j][1] > times[a][0] && times[j][0] < times[a][0])
                    || (times[j][0] < times[a][0] && times[j][1] > times[a][1])
                    || (times[j][0] > times[a][0] && times[j][1] < times[a][1]))*/
            if (!(times[j][1] < times[a][0] || times[j][0] > times[a][1]))
                return false;
        }
        return true;
    }
}
