import java.util.Scanner;


//背包问题会超时怎么解决？

public class GLDtest3 {

    static int bestval = 0;              //最优值；当前的最大价值，初始化为0

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int TotCap = in.nextInt();

        double[] w = new double[n];  //每个物品的重量
        int[] v = new int[n];   //每个物品的价值
        int[] x = new int[n];   //x[i]=1代表物品i放入背包，0代表不放入

        for (int i = 0; i<n; i++){
            w[i] = in.nextDouble();
            v[i] = in.nextInt();
        }

        dfs(0, 0,0, w, v, x, n, TotCap);

        System.out.println(bestval);
    }

    //cw当前包内物品重量，cv当前包内物品价值,i代表第i个物体
    public static void dfs(int i, int cv, int cw, double[] w, int[] v, int[] x, int n, int TotCap) {
        if(i > n - 1) {
            if(cv > bestval)            //是否超过了最大价值
                bestval = cv;             //得到最大价值
        }
        else{
            for(int j = 0; j <= 1; j++)    //枚举物体i所有可能的路径，
            {
                x[i] = j;
                if(cw + x[i]*w[i] <= TotCap)  //满足约束,继续向子节点探索
                {
                    cw += w[i]*x[i];
                    cv += v[i]*x[i];
                    dfs(i+1, cv, cw, w, v, x, n, TotCap);
                    cw -= w[i]*x[i];    //回溯上一层物体的选择情况
                    cv -= v[i]*x[i];
                }
            }
        }
    }
}
