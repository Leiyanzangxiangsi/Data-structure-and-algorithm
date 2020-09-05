

// 青蛙跳台阶问题

import java.util.Scanner;

public class Jump {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(jump(7));
        System.out.println(jump3(3));
        System.out.println(jump4(7, 7));

    }
    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    如果n=1，只有一种跳法，那就是1
    如果n=2，那么有两种跳法，2，[1,1]
    如果n=3，那么有三种跳法，[1,1,1],,[1,2],[2,1]
    如果n=4，那么有五种跳法，[1,1,1,1],[1,1,2],[1,2,1],[2,1,1],[2,2]
    如果n=5，那么有八种跳法，[1,1,1,1,1],[1,1,1,2],[1,1,2,1],[1,2,1,1],[2,1,1,1],[2,2,1],[2,1,2],[1,2,2]
    结果为1，2，3，5，8  这不特么是斐波那切数列嘛*/

    public static int jump(int n){
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        return jump(n-1)+jump(n-2);
    }
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    //f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
    /*3. 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)= f(0) + f(1) + f(2) + f(3) + ... + f(n-2)+f(n-1)
    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    so  f(n)=2*f(n-1)
    */

    public static int jump3(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return 2 * jump3(n - 1);
        }
    }

    /*4. 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个m级的台阶总共有多少种跳法。
    先列多项式：
    f(n) =  f(n-1) + f(n-2) + f(n-3) + ... + f(n-m)
    f(n-1) =   f(n-2) + f(n-3) + ... + f(n-m) + f(n-m-1)
    化简得：f(n) = 2f(n-1) - f(n-m-1)
    */
    public static int jump4(int n, int m) {
        //当大于m的时候是上面的公式
        if(n > m){
            return 2*jump4(n-1, m) - jump4(n-1-m, m);
        }
        //当小于等于m的时候就是和n级的相同了
        if (n <= 1) {
            return 1;
        } else {
            return 2 * jump4(n - 1,n);
        }
    }
}





