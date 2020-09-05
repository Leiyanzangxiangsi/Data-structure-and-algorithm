import java.util.Scanner;

//并不需要记录
/*
虽然感觉这个题目好像要用long long ，才能过，但实际上用int就行，而且long long会超时
*/
public class Bag01_dp {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        bag01(N, V, v, w);
    }

    public static void bag01(int N, int V, int[] v, int[] w){

        // int[][] dp=new int[N+1][V+1];
        // for(int i=1;i<=N;i++){
        //     for(int j=0;j<=V;j++){
        //         dp[i][j]=dp[i-1][j];
        //         if(j-v[i-1]>=0){
        //             dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i-1]]+w[i-1]);
        //         }
        //     }
        // }
        //  System.out.println(dp[N][V]);
        int[] dp = new int[V+1];
        for(int i = 1;i <= N;i++){
            // 从大到小遍历
            for(int j = V;j >= 0;j--){
                if(j - v[i-1] >= 0){
                    dp[j]=Math.max(dp[j],dp[j - v[i-1]] + w[i-1]);
                }
            }
        }
        System.out.println(dp[V]);
    }
    public static void bag_wanquan(int N, int V, int[] v, int[] w){

        int[] dp=new int[V+1];
        for(int i = 0;i < N; i++){
            // 代码与01背包的区别，从小到大遍历
            for(int j = 0;j <= V;j++){
                if(j >= v[i]){
                    dp[j] = Math.max(dp[j], dp[j-v[i]]+w[i]);
                }
            }
        }
        System.out.println(dp[V]);
    }

    public static void bag_wanquan1(int N, int V, int[] v, int[] w, int[] s){

        // int[][] dp=new int[N+1][V+1];
        // for(int i=1;i<=N;i++){
        //     for(int j=0;j<=V;j++){
        //         for(int k=0;k<=s[i-1];k++){
        //             if(j>=k*v[i-1]){
        //                 dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
        //             }
        //         }
        //     }
        // }
        // System.out.println(dp[N][V]);
        int[] dp=new int[V+1];
        for(int i=1;i<=N;i++){
            // 01背包扩展，体积从大到小遍历
            for(int j=V;j>=0;j--){
                // 对物品数量进行遍历
                for(int k=0;k<=s[i-1];k++){
                    if(j>=k*v[i-1]){
                        dp[j]=Math.max(dp[j],dp[j-k*v[i-1]]+k*w[i-1]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }


}
