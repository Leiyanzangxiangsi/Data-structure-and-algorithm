import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



// 暴力解吧
import java.util.Scanner;
        import java.util.*;

public class qustion1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();    //这个是有几组

        getnums(n);



    }
    public static void getnums(int n){

        int ansnum = 0;
        Queue<Integer> ans = new LinkedList<>();
        for (int i = 1; i <= n/4;i++){
            if (isnum(i, i*4)){
                ansnum++;
                ans.offer(i);
                ans.offer(i*4);
            }
        }

        System.out.println(ansnum);
        while (!ans.isEmpty()){
            System.out.print(ans.poll());
            System.out.print(' ');
            System.out.print(ans.poll());
            System.out.print('\n');
        }
    }

    //判断两个数是不是
    public static boolean isnum(int a, int b){

        // 一个栈，一个队列
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        while (a > 0){
            s.push(a%10);
            a = a/10;
        }

        while (b > 0){
            q.offer(b%10);
            b = b/10;
        }

        if (s.size() != q.size())
            return false;
        else {
            while (!s.isEmpty() && !q.isEmpty()){
                int x = s.pop();
                int y = q.poll();
                if (x!=y)
                    return false;
            }
        }
        return true;
    }
}



