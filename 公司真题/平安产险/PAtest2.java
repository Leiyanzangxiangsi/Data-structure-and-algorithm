import java.util.Scanner;




public class PAtest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();


        System.out.println(getnums(n));

    }

    public static int getnums(int n){

        int dp0 = 1;
        int dp1 = 1;
        int dp2 = 0;

        if (n==1)
            return 1;
        if (n==2)
            return 2;

        for (int i=3;i<=n;i++){
            dp2 = dp0 + dp1;
            dp0 = dp1;
            dp1 = dp2;
        }

        return dp2 + 1;
    }
}
