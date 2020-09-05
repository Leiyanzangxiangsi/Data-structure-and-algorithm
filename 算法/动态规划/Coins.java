import java.util.Arrays;
import java.util.Scanner;

class Coins {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] coins = {3,4,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));


    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        for (int i = 0; i <= amount;i++)        //dp要初始化成最大值
            dp[i] = amount+1;

        dp[0] = 0;

        for (int i = 0;i <= amount;i++){

            for (int coin : coins){
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }

        System.out.println(Arrays.toString(dp));
        if (dp[amount] == amount + 1)
            return -1;
        else
            return dp[amount];
    }
}