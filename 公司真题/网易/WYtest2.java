import java.util.*;

public class WYtest2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        System.out.println(translateNum(s));

    }


    public static int translateNum(String s) {

        int[] dp = new int[s.length()+1];       //动态规划问题
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i ++){
            if (i==2){
                String temp = s.substring(i-2, i);
                if(temp.compareTo("10") == 0 || temp.compareTo("11") == 0)
                    dp[i] = dp[i-1] + dp[i-2];
                else
                    dp[i] = dp[i-1];
            }

            else {
                String temp = s.substring(i-3, i);

                if (temp.compareTo("100") == 0)
                    dp[i] = dp[i-3] + dp[i-1];
                else if (temp.compareTo("101") == 0)
                    dp[i] = dp[i-3] + dp[i-1];
                else if (temp.compareTo("110") == 0)
                    dp[i] = dp[i-3] + dp[i-2] + dp[i-1] ;
                else if (temp.compareTo("111") == 0)
                    dp[i] = dp[i-3] + dp[i-2] + dp[i-1] ;
                else if (temp.compareTo("111") == 0)
                    dp[i] = dp[i-3] + dp[i-2] + dp[i-1] ;
                else if (temp.compareTo("010") == 0)
                    dp[i] = dp[i-2] + dp[i-1] ;
                else if (temp.compareTo("011") == 0)
                    dp[i] = dp[i-2] + dp[i-1] ;
                else {
                    dp[i] = dp[i-1];
                }
            }

        }
        return dp[s.length()];
    }
}



