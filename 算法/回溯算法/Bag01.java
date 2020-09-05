





//**************************************************************************
// 01背包问题
//**************************************************************************


public class Bag01 {

    static int n = 3;                      //物体个数
    static int TotCap = 16;                 //背包的容量

    static int[] bestx = new int[n];       //最后的安放结果，0放，1不放
    static int bestval = 0;              //最优值；当前的最大价值，初始化为0

    static int[] w = new int[]{10,8,5};  //每个物品的重量
    static int[] v = new int[]{5,4,1};   //每个物品的价值
    static int[] x = new int[]{0,0,0};   //x[i]=1代表物品i放入背包，0代表不放入

    public static void main(String[] args) {


        dfs(0, 0,0);

        System.out.println(bestval);
        for(int i = 0;i < n;i++)
            System.out.println(bestx[i]);     //得到选中的物品
    }

    //cw当前包内物品重量，cv当前包内物品价值,i代表第i个物体
    public static void dfs(int i, int cv, int cw) {
        //满足条件，到达了决策树的最底层
        if(i == n) {
            if(cv > bestval){             //是否超过了最大价值
                bestval = cv;             //得到最大价值
                for (int k = 0; k < n; k++)
                    bestx[k] = x[k];      //得到选中的物品
            }
        }

        else{
            for(int j = 0; j <= 1; j++)    //枚举物体i所有可能的路径，就两种，选或者不选
            {
                x[i] = j;
                if(cw + x[i]*w[i] <= TotCap)  //满足约束,继续向子节点探索
                {
                    cw += w[i]*x[i];
                    cv += v[i]*x[i];
                    dfs(i+1, cv, cw);
                    cw -= w[i]*x[i];    //回溯上一层物体的选择情况
                    cv -= v[i]*x[i];
                }
            }
        }
    }
}
